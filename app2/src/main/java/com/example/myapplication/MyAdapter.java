package com.example.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

/**
 * Created by jinhongguang on 16/10/30.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private LayoutInflater mInflater;
    private Context context;
    private List<String> mTitles=null;
    private OnItemClickListener mOnItemClickListener;

    interface OnItemClickListener{
        public void onClick(int position);
    }

    public MyAdapter(Context context,List<String> data){
        this.context = context;
        this.mTitles = data;
        this.mInflater=LayoutInflater.from(context);

    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
        View v = (View) inflater.inflate(R.layout.my_view, null);
        MyViewHolder viewHolder=new MyViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.item_tv.setText("Frame"+position);
    }

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener){
        this.mOnItemClickListener=mOnItemClickListener;
    }

    public void removeItem(int position){
        if (position != -1) {
            mTitles.remove(position);
            notifyItemRemoved(position);
        }
    }

    public void addItem(int position){
        mTitles.add("Frame"+position);
        notifyItemInserted(position);
    }

    @Override
    public int getItemCount() {
        return mTitles.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public MyView item_tv;
        public MyViewHolder(View itemView) {
            super(itemView);
            item_tv = (MyView) itemView.findViewById(R.id.counter_view);
            itemView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    try {mOnItemClickListener.onClick(getLayoutPosition());}catch (Exception e){}
                    return false;
                }
            });
        }

    }
}
