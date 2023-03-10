package com.transcendence.music.main.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.core.widget.TextViewCompat;

import com.transcendence.music.R;
import com.transcendence.music.main.LvMenuItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author joephone
 * @date 2023/1/20
 * @desc
 */
public class MenuItemAdapter extends BaseAdapter {

    private int mIconSize;
    private LayoutInflater mInflater;
    private Context mContext;

    public MenuItemAdapter(Context context){
        mInflater = LayoutInflater.from(context);
        mContext = context;
        mIconSize = context.getResources().getDimensionPixelSize(R.dimen.drawer_icon_size);//24dp
    }

    private List<LvMenuItem> mItems = new ArrayList<LvMenuItem>(
            Arrays.asList(
                    new LvMenuItem(R.drawable.topmenu_icn_night, "夜间模式"),
                    new LvMenuItem(R.drawable.topmenu_icn_skin, "主题换肤"),
                    new LvMenuItem(R.drawable.topmenu_icn_time, "定时关闭音乐"),
                    new LvMenuItem(R.drawable.topmenu_icn_vip, "下载歌曲品质"),
                    new LvMenuItem(R.drawable.topmenu_icn_exit, "退出")

            ));

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return 3;
    }

    @Override
    public int getItemViewType(int position) {
        return mItems.get(position).type;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LvMenuItem item = mItems.get(position);
        switch (item.type) {
            case LvMenuItem.TYPE_NORMAL:
                if (convertView == null) {
                    convertView = mInflater.inflate(R.layout.design_drawer_item, parent,
                            false);
                }
                TextView itemView = (TextView) convertView;
                itemView.setText(item.name);
                Drawable icon = mContext.getResources().getDrawable(item.icon);
                // setIconColor(icon);
                if (icon != null) {
                    icon.setBounds(0, 0, mIconSize, mIconSize);
                    TextViewCompat.setCompoundDrawablesRelative(itemView, icon, null, null, null);
                }

                break;
            case LvMenuItem.TYPE_NO_ICON:
                if (convertView == null) {
                    convertView = mInflater.inflate(R.layout.design_drawer_item_subheader,
                            parent, false);
                }
                TextView subHeader = (TextView) convertView;
                subHeader.setText(item.name);
                break;
            case LvMenuItem.TYPE_SEPARATOR:
                if (convertView == null) {
                    convertView = mInflater.inflate(R.layout.design_drawer_item_separator,
                            parent, false);
                }
                break;
        }

        return convertView;
    }
}
