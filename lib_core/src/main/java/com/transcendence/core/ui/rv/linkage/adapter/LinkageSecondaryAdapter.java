package com.transcendence.core.ui.rv.linkage.adapter;
/*
 * Copyright (c) 2018-present. KunMinX
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.transcendence.core.R;
import com.transcendence.core.ui.rv.linkage.adapter.viewholder.LinkageSecondaryFooterViewHolder;
import com.transcendence.core.ui.rv.linkage.adapter.viewholder.LinkageSecondaryHeaderViewHolder;
import com.transcendence.core.ui.rv.linkage.adapter.viewholder.LinkageSecondaryViewHolder;
import com.transcendence.core.ui.rv.linkage.bean.BaseGroupedItem;
import com.transcendence.core.ui.rv.linkage.contract.ILinkageSecondaryAdapterConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by KunMinX at 19/4/29
 */
public class LinkageSecondaryAdapter<T extends BaseGroupedItem.ItemInfo> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

  private List<BaseGroupedItem<T>> mItems;
  private static final int IS_HEADER = 0;
  private static final int IS_LINEAR = 1;
  private static final int IS_GRID = 2;
  private static final int IS_FOOTER = 3;
  private boolean mIsGridMode;

  private final ILinkageSecondaryAdapterConfig<T> mConfig;

  public ILinkageSecondaryAdapterConfig<T> getConfig() {
    return mConfig;
  }

  public List<BaseGroupedItem<T>> getItems() {
    return mItems;
  }

  public boolean isGridMode() {
    return mIsGridMode && mConfig.getGridLayoutId() != 0;
  }

  public void setGridMode(boolean isGridMode) {
    mIsGridMode = isGridMode;
  }

  public LinkageSecondaryAdapter(List<BaseGroupedItem<T>> items, ILinkageSecondaryAdapterConfig<T> config) {
    mItems = items;
    if (mItems == null) {
      mItems = new ArrayList<>();
    }
    mConfig = config;
  }

  public void initData(List<BaseGroupedItem<T>> list) {
    mItems.clear();
    if (list != null) {
      mItems.addAll(list);
    }
    notifyDataSetChanged();
  }

  @Override
  public int getItemViewType(int position) {
    if (mItems.get(position).isHeader) {
      return IS_HEADER;
    } else if (TextUtils.isEmpty(mItems.get(position).info.getTitle()) &&
            !TextUtils.isEmpty(mItems.get(position).info.getGroup())) {
      return IS_FOOTER;
    } else if (isGridMode()) {
      return IS_GRID;
    } else {
      return IS_LINEAR;
    }
  }

  @NonNull
  @Override
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    Context context = parent.getContext();
    mConfig.setContext(context);
    if (viewType == IS_HEADER) {
      View view = LayoutInflater.from(context).inflate(mConfig.getHeaderLayoutId(), parent, false);
      return new LinkageSecondaryHeaderViewHolder(view);
    } else if (viewType == IS_FOOTER) {
      int footerLayout = mConfig.getFooterLayoutId() == 0
              ? R.layout.ui_rv_linkpage_default_adapter_secondary_footer
              : mConfig.getFooterLayoutId();
      View view = LayoutInflater.from(context).inflate(footerLayout, parent, false);
      return new LinkageSecondaryFooterViewHolder(view);
    } else if (viewType == IS_GRID && mConfig.getGridLayoutId() != 0) {
      View view = LayoutInflater.from(context).inflate(mConfig.getGridLayoutId(), parent, false);
      return new LinkageSecondaryViewHolder(view);
    } else {
      View view = LayoutInflater.from(context).inflate(mConfig.getLinearLayoutId(), parent, false);
      return new LinkageSecondaryViewHolder(view);
    }
  }

  @Override
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
    final BaseGroupedItem<T> linkageItem = mItems.get(holder.getAdapterPosition());
    if (getItemViewType(holder.getAdapterPosition()) == IS_HEADER) {
      LinkageSecondaryHeaderViewHolder headerViewHolder = (LinkageSecondaryHeaderViewHolder) holder;
      mConfig.onBindHeaderViewHolder(headerViewHolder, linkageItem);
    } else if (getItemViewType(holder.getAdapterPosition()) == IS_FOOTER) {
      LinkageSecondaryFooterViewHolder footerViewHolder = (LinkageSecondaryFooterViewHolder) holder;
      mConfig.onBindFooterViewHolder(footerViewHolder, linkageItem);
    } else {
      LinkageSecondaryViewHolder secondaryViewHolder = (LinkageSecondaryViewHolder) holder;
      mConfig.onBindViewHolder(secondaryViewHolder, linkageItem);
    }
  }

  @Override
  public int getItemCount() {
    return mItems.size();
  }

}
