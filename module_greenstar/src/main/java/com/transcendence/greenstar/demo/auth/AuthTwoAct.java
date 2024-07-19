package com.transcendence.greenstar.demo.auth;

import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.transcendence.core.base.activity.AppAc;
import com.transcendence.greenstar.R;

/**
 * Created by Joephone on 2018/6/4 16:14
 * E-Mail Address：joephonechen@gmail.com
 * 新 认证第二步
 */
public class AuthTwoAct extends AppAc {


    ImageView ivLeftSelected;
    ImageView ivRightSelected;

    private boolean isFineControl;

    public static void start(Context context){
        Intent intent = new Intent(context,AuthTwoAct.class);
        context.startActivity(intent);
    }



    @Override
    protected int getLayoutId() {
        return R.layout.activity_demo_auth_step_two;
    }

    @Override
    protected void initView() {
        setTitle("选择医生类型");
        LinearLayout layoutLeft = findViewById(R.id.layout_left);
        LinearLayout layoutRight = findViewById(R.id.layout_right);
        ivLeftSelected = findViewById(R.id.ivLeftSelected);
        ivRightSelected = findViewById(R.id.ivRightSelected);

        TextView tvNext = findViewById(R.id.tv_next);
        layoutLeft.setOnClickListener(v -> {
            isFineControl = false;
            ivLeftSelected.setImageResource(R.drawable.icon_selected);
            ivRightSelected.setImageResource(R.drawable.icon_unselected);
        });

        layoutRight.setOnClickListener(v -> {
            isFineControl = true;
            ivRightSelected.setImageResource(R.drawable.icon_selected);
            ivLeftSelected.setImageResource(R.drawable.icon_unselected);
        });

        tvNext.setOnClickListener(v -> {
            if(isFineControl){
//                Intent intent = new Intent(AuthTwoAct.this, AuthThreeFCAct.class);
//                Bundle bundle = new Bundle();
//                bundle.putBoolean(Global.PUBLIC_INTENT_KEY.FLAG,isFineControl);
//                intent.putExtras(bundle);
//                startActivityForResult(intent,Global.REQUEST_CODE.AUTH);
            }else {
//                Intent intent = new Intent(AuthTwoAct.this, AuthThreeAct.class);
//                Bundle bundle = new Bundle();
//                bundle.putBoolean(Global.PUBLIC_INTENT_KEY.FLAG,isFineControl);
//                intent.putExtras(bundle);
//                startActivityForResult(intent,Global.REQUEST_CODE.AUTH);
            }
        });
    }





    @Override
    public void onResume() {
        super.onResume();
    }


}
