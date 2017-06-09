package com.example.administrator.newsappnew20.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.administrator.newsappnew20.Obj.Image2Text;
import com.example.administrator.newsappnew20.R;

import java.util.List;

/**
 * Created by Administrator on 2017/6/8/008.
 */

public class RecyClerViewAdapter extends RecyclerView.Adapter<RecyClerViewAdapter.CustomViewHolder> {
    private List<Image2Text> items;
    private Context context;
    private OnItemClickListener mOnItemClickListener = null;
    //define interface
    public static interface OnItemClickListener {
        void onItemClick(View view , int position);
    }
    public RecyClerViewAdapter(List<Image2Text> newItems,Context context){
        this.items=newItems;
        this.context=context;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news,parent,false);
        return new CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.textView.setText(items.get(position).getTitle());
//        holder.imageView.setBackgroundColor(items.get(position).getPhotoId());
        Glide.with(context)
                .load(items.get(position).getPhotoId()).asGif().diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    protected final static class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView textView ;
        protected ImageView imageView;
        public CustomViewHolder (View itemView) {
            super(itemView);
            this.textView = (TextView) itemView.findViewById (R. id.text);
            this.imageView= (ImageView) itemView.findViewById(R.id.image);
        }
    }
}
