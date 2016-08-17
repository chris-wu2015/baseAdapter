package com.chris.wrecyclerview;

import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * recyclerView的item点击事件
 *
 * @author Wuzhangbing
 *         created at 2016/7/29 029
 */
@SuppressWarnings("Unchecked")
public abstract class OnItemClickListener<VH extends RecyclerView.ViewHolder> implements RecyclerView.OnItemTouchListener {
    private GestureDetectorCompat gestureDetector;
    private RecyclerView recyclerView;

    public OnItemClickListener(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
        gestureDetector = new GestureDetectorCompat(recyclerView.getContext(),
                new ItemTouchHelperGestureListener());
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        gestureDetector.onTouchEvent(e);
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        gestureDetector.onTouchEvent(e);
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }

    private class ItemTouchHelperGestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
            if (child != null) {
                VH vh = (VH) recyclerView.getChildViewHolder(child);
                onItemClick(child, vh);
            }
            return true;
        }

        @Override
        public void onLongPress(MotionEvent e) {
            View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
            if (child != null) {
                VH vh = (VH) recyclerView.getChildViewHolder(child);
                onItemLongClick(child, vh);
            }
        }
    }

    protected abstract void onItemClick(View clickedView, VH holder);

    protected void onItemLongClick(View clickedView, VH holder) {

    }
}
