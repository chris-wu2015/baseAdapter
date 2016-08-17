package com.chris.wrecyclerview.adapter.base;


/**
 * Created by chris on 16/6/22.
 */
public interface ItemViewDelegate<T>
{

    int getItemViewLayoutId();

    boolean isForViewType(T item, int position);

    void convert(ViewHolder holder, T t, int position);


}
