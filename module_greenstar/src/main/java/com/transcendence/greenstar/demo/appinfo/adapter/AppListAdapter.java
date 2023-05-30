package com.transcendence.greenstar.demo.appinfo.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.transcendence.greenstar.R;
import com.transcendence.greenstar.demo.appinfo.act.AppInfoDetailsAc;
import com.transcendence.greenstar.demo.appinfo.bean.AppInfoBean;
import com.transcendence.greenstar.demo.appinfo.config.KeyConstants;
import com.transcendence.greenstar.demo.appinfo.config.NotifyConstants;

import java.util.ArrayList;


/**
 * detail: App 列表 Adapter
 * Created by Ttt
 */
public class AppListAdapter extends RecyclerView.Adapter<AppListAdapter.ViewHolder>{

    // 上下文
    private Activity mActivity;
    // 数据源
    private ArrayList<AppInfoBean> listDatas = new ArrayList<>();

    /**
     * 初始化适配器
     * @param mActivity
     */
    public AppListAdapter(Activity mActivity) {
        this.mActivity = mActivity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder viewHolder = null;
        // 判断类型
        if (viewType == 0){
            View itemView = LayoutInflater.from(mActivity).inflate(R.layout.activity_demo_appinfo_fragment_list_item, null, false);
            viewHolder = new ViewHolder(itemView, viewType);
        }
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // 获取实体类
        AppInfoBean bean = listDatas.get(position);
        // 判断类型
        if (holder.iType == 0){
            // 设置 app 名
            holder.iai_name_tv.setText(bean.getAppName() + "");
            // 设置 app 包名
            holder.iai_pack_tv.setText(bean.getAppPackName() + "");
            // 设置 app 图标
            holder.iai_igview.setImageDrawable(bean.getAppIcon());
            /**
             *    TextView tv_version_name;
             *         TextView tv_version_code;
             *         TextView tv_app_type;
             *         TextView tv_app_size;
             *         TextView tv_in_time;
             *         TextView tv_up_time;
             *         TextView tv_flags;
             */
            holder.tv_version_name.setText(bean.getVersionName());
            holder.tv_version_code.setText(bean.getVersionCode() + "");
            holder.tv_app_type.setText(bean.getAppType() + "");
            holder.tv_app_size.setText(bean.getApkSize() + "");
            holder.tv_in_time.setText(bean.getFirstInstallTime() + "");
            holder.tv_up_time.setText(bean.getLastUpdateTime() + "");

//            String packageName = packageInfo.packageName;  //包名
//            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
//
//
//            holder.tv_flags.setText(ApplicationInfo.FLAG + "");



        }
    }

    @Override
    public int getItemCount() {
        return listDatas.size();
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    // ==

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        int iType;
        // == View ==
        RelativeLayout iai_rela;
        ImageView iai_igview;
        TextView iai_name_tv;
        TextView iai_pack_tv;
        TextView tv_version_name;
        TextView tv_version_code;
        TextView tv_app_type;
        TextView tv_app_size;
        TextView tv_in_time;
        TextView tv_up_time;
        TextView tv_flags;

        public ViewHolder(View itemView, int iType){
            super(itemView);
            this.iType = iType;
            // 判断类型
            if (iType == 0) {
                iai_rela = (RelativeLayout) itemView.findViewById(R.id.iai_rela);
                iai_igview = (ImageView) itemView.findViewById(R.id.iai_igview);
                iai_name_tv = (TextView) itemView.findViewById(R.id.iai_name_tv);
                iai_pack_tv = (TextView) itemView.findViewById(R.id.iai_pack_tv);
                tv_version_name = (TextView) itemView.findViewById(R.id.tv_version_name);
                tv_version_code = (TextView) itemView.findViewById(R.id.tv_version_code);
                tv_app_type = (TextView) itemView.findViewById(R.id.tv_app_type);
                tv_app_size = (TextView) itemView.findViewById(R.id.tv_app_size);
                tv_in_time = (TextView) itemView.findViewById(R.id.tv_in_time);
                tv_up_time = (TextView) itemView.findViewById(R.id.tv_up_time);
                tv_flags = (TextView) itemView.findViewById(R.id.tv_flags);
                // 设置点击事件
                iai_rela.setOnClickListener(this);
            }
        }

        @Override
        public void onClick(View view) {
            // 判断类型
            if (iType == 0){
                // 获取当前索引
                int pos = getLayoutPosition();
                // 获取Item
                AppInfoBean appInfoBean = listDatas.get(pos);
                // 进行跳转
                Intent intent = new Intent(mActivity, AppInfoDetailsAc.class);
                intent.putExtra(KeyConstants.KEY_PACKNAME, appInfoBean.getAppPackName());
                mActivity.startActivityForResult(intent, NotifyConstants.FOR_R_APP_DETAILS);
            }
        }
    }

    // ==

    /**
     * 设置数据源
     * @param listDatas
     */
    public void setListDatas(ArrayList<AppInfoBean> listDatas) {
        if (listDatas == null){
            return;
        }
        this.listDatas = listDatas;
        // 刷新适配器
        notifyDataSetChanged();
    }

    /**
     * 清空数据
     */
    public void clearData(){
        this.listDatas.clear();
        // 刷新适配器
        notifyDataSetChanged();
    }
}
