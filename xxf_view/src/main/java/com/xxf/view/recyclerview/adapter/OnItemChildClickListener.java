package com.xxf.view.recyclerview.adapter;

import android.view.View;

import androidx.databinding.ViewDataBinding;

public interface OnItemChildClickListener<V extends ViewDataBinding, T> {

    /**
     * @param adapter
     * @param holder    item holder
     * @param childView item 子view
     * @param index     相对于List容器的位置
     * @param t         对应的数据项
     */
    void onItemChildClick(XXFRecyclerAdapter<V, T> adapter, XXFViewHolder<V, T> holder, View childView, int index, T t);
}