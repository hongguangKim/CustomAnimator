package com.example.myapplication;

import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;

import jp.wasabeef.recyclerview.animators.BaseItemAnimator;

/**
 * Created by jinhongguang on 16/10/30.
 */
public class MyItemAnimators extends BaseItemAnimator {

    @Override
    protected void preAnimateRemoveImpl(RecyclerView.ViewHolder holder) {
                ViewCompat.setPivotY(holder.itemView, 0);
    }

    @Override
    protected void animateRemoveImpl(RecyclerView.ViewHolder holder) {
        ViewCompat.animate(holder.itemView)
                .scaleX(0)
                .scaleY(0)
                .setDuration(getRemoveDuration())
                .setInterpolator(mInterpolator)
                .setListener(new DefaultRemoveVpaListener(holder))
                .setStartDelay(getRemoveDelay(holder))
                .start();
    }

    @Override
    protected void preAnimateAddImpl(RecyclerView.ViewHolder holder) {
        ViewCompat.setScaleX(holder.itemView, 0);
        ViewCompat.setScaleY(holder.itemView, 0);
    }


    @Override
    protected void animateAddImpl(RecyclerView.ViewHolder holder) {
        ViewCompat.animate(holder.itemView)
                .scaleX(1)
                .scaleY(1)
                .setDuration(getRemoveDuration())
                .setInterpolator(mInterpolator)
                .setListener(new DefaultRemoveVpaListener(holder))
                .setStartDelay(getRemoveDelay(holder))
                .start();
    }
}
