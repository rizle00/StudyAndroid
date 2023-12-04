package com.example.and10_fragmentadapter.melon;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter {

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ImageView imgv_melon,imgv_updown, imgv_play;
            TextView tv_rank, tv_title, tv_singer;
        }
    }
}
