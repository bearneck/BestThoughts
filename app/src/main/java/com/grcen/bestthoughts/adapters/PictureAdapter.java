package com.grcen.bestthoughts.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.grcen.bestthoughts.R;
import com.grcen.bestthoughts.Bean.Picture;

import java.util.List;

public class PictureAdapter extends RecyclerView.Adapter<PictureAdapter.ViewHolder> {
    private Context mContext;
    private List<Picture> mPictureList;

    public class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView iconId;
        ImageView imageId;
        TextView name;
        TextView content;
        TextView zannum;
        TextView contentnum;
        TextView sharenum;
        ImageButton deleteButton;

        public ViewHolder(View view){
            super(view);
            cardView = (CardView) view;
            iconId = (ImageView) view.findViewById(R.id.icon);
            imageId = (ImageView) view.findViewById(R.id.picture_image);
            name = (TextView) view.findViewById(R.id.name);
            content = (TextView) view.findViewById(R.id.content);
            zannum = (TextView) view.findViewById(R.id.zan);
            contentnum = (TextView) view.findViewById(R.id.comment);
            sharenum = (TextView) view.findViewById(R.id.share);
            deleteButton = (ImageButton) view.findViewById(R.id.dis);
        }
    }
    public PictureAdapter(List<Picture> pictureList){
        mPictureList = pictureList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (mContext == null){
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.picture_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Picture picture = mPictureList.get(position);
        holder.name.setText(picture.getName());
        holder.content.setText(picture.getContent());
        holder.zannum.setText(picture.getZannum() + " ");//int不能直接转换成string
        holder.contentnum.setText(picture.getContentnum() + " ");
        holder.sharenum.setText(picture.getSharenum() + " ");
        Glide.with(mContext).load(picture.getIconId()).into(holder.iconId);
        Glide.with(mContext).load(picture.getImageId()).into(holder.imageId);
        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mPictureList.size()==1){
                    Snackbar.make(v,"再删就没有了",Snackbar.LENGTH_SHORT).show();
                }else {
                    //删除自带默认动画
                    removeData(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mPictureList.size();
    }
    public void removeData(int position) {
        mPictureList.remove(position);
        notifyItemRemoved(position);
        if(position != mPictureList.size()){ // 如果移除的是最后一个，忽略
            notifyItemRangeChanged(position, mPictureList.size() - position);
        }
    }
}
