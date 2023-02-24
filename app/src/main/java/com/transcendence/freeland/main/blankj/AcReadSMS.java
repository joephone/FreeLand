package com.transcendence.freeland.main.blankj;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.transcendence.core.base.activity.BaseAc;
import com.transcendence.core.utils.log.LogUtils;
import com.transcendence.freeland.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author joephone
 * @date 2023/2/9
 * @desc
 */
public class AcReadSMS extends BaseAc implements View.OnClickListener{


    private ListView lv_sms_list;
    private TextView tv;
    private List<Map<String,Object>> data;
    private SimpleAdapter simpleAdapter;
    private ContentResolver contentResolver;

    public static void launch(Context context){
        Intent intent = new Intent(context, AcReadSMS.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_sms);

        //获取访问者
        contentResolver = getContentResolver();

        lv_sms_list = (ListView) findViewById(R.id.lv);
        tv = findViewById(R.id.tv);
        tv.setOnClickListener(this);
        data = new ArrayList<Map<String,Object>>();
        //适配器
        simpleAdapter = new SimpleAdapter(this,data,android.R.layout.simple_list_item_2,new String[]{"names","note"},new int[]{android.R.id.text1,android.R.id.text2});
        lv_sms_list.setAdapter(simpleAdapter);
    }


    public void getContactsSms() {
        LogUtils.d("getContactsSms");
        //读取所有短信
        Uri uri=Uri.parse("content://sms/");
        ContentResolver resolver = getContentResolver();
        Cursor cursor = resolver.query(uri, new String[]{"_id", "address", "body", "date", "type"}, null, null, null);
        if(cursor!=null&&cursor.getCount()>0){
            int _id;
            String address;
            String body;
            String date;
            int type;
            while (cursor.moveToNext()){
                Map<String,Object>map=new HashMap<String,Object>();
                _id=cursor.getInt(0);
                address=cursor.getString(1);
                body=cursor.getString(2);
                date=cursor.getString(3);
                type=cursor.getInt(4);
                map.put("names",body);
                data.add(map);
                LogUtils.i("_id="+_id+" address="+address+" body="+body+" date="+date+" type="+type);
                //通知适配器发生改变
                simpleAdapter.notifyDataSetChanged();
            }

        }
    }

    @Override
    public void onClick(View v) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && ContextCompat.checkSelfPermission
                (this, Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_SMS}, 0);
        } else {
            getContactsSms();
        }
    }

    //请求权限后的结果回调
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 0) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getContactsSms();
            } else {
                Toast.makeText(this, "你拒绝了该权限，无法保存图片！", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
