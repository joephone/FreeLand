package com.transcendence.greenstar.demo.shoppingcart.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import com.transcendence.greenstar.R;
import com.transcendence.greenstar.demo.shoppingcart.model.DishMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cheng on 16-11-10.
 */
public class LeftMenuAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private ArrayList<DishMenu> mMenuList;
    private int mSelectedNum;
    private List<onItemSelectedListener> mSelectedListenerList;

    public interface onItemSelectedListener{
        void onLeftItemSelected(int position,DishMenu menu);
    }

    public void addItemSelectedListener(onItemSelectedListener listener){
        if(mSelectedListenerList!=null) {
            mSelectedListenerList.add(listener);
        }
    }

    public void removeItemSelectedListener(onItemSelectedListener listener){
        if(mSelectedListenerList!=null && !mSelectedListenerList.isEmpty()){
            mSelectedListenerList.remove(listener);
        }
    }

    public LeftMenuAdapter(Context mContext, ArrayList<DishMenu> mMenuList){
        this.mContext = mContext;
        this.mMenuList = mMenuList;
        this.mSelectedNum = -1;
        this.mSelectedListenerList = new ArrayList<>();
        if(mMenuList.size()>0){
            mSelectedNum = 0;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_demo_shopping_cart_left_menu_item, parent, false);
        LeftMenuViewHolder viewHolder = new LeftMenuViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        DishMenu dishMenu = mMenuList.get(position);
        LeftMenuViewHolder viewHolder = (LeftMenuViewHolder)holder;
        viewHolder.menuName.setText(dishMenu.getMenuName());
        if(mSelectedNum==position){
            viewHolder.menuLayout.setSelected(true);
        }else{
            viewHolder.menuLayout.setSelected(false);
        }
    }

    @Override
    public int getItemCount() {
        return mMenuList.size();
    }

    public void setSelectedNum(int selectedNum) {
        if(selectedNum<getItemCount() && selectedNum>=0 ) {
            this.mSelectedNum = selectedNum;
            notifyDataSetChanged();
        }
    }


    private class LeftMenuViewHolder extends RecyclerView.ViewHolder{

        TextView menuName;
        LinearLayout menuLayout;

        public LeftMenuViewHolder(final View itemView) {
            super(itemView);
            menuName = (TextView)itemView.findViewById(R.id.left_menu_textview);
            menuLayout = (LinearLayout)itemView.findViewById(R.id.left_menu_item);
            menuLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int clickPosition = getAdapterPosition();
//                    setSelectedNum(clickPosition);
                    notifyItemSelected(clickPosition);
                }
            });
        }
    }

    private void notifyItemSelected(int position) {
        if(mSelectedListenerList!=null && !mSelectedListenerList.isEmpty()){
            for(onItemSelectedListener listener:mSelectedListenerList){
                listener.onLeftItemSelected(position,mMenuList.get(position));
            }
        }
    }
}
