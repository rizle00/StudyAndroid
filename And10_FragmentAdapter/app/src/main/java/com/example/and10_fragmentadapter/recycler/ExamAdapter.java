package com.example.and10_fragmentadapter.recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.and10_fragmentadapter.R;

public class ExamAdapter extends RecyclerView.Adapter<ExamAdapter.ViewHolder> {

//    1.onCreateViewHolder부분에서 필요 : "Layout"Inflater -> parent(칸)
//     1-1. 레이아웃 인플레이터가 붙일 xml(layout)
    LayoutInflater inflater;

    public ExamAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_melon, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

//    1.ViewHolder 클래스를 상속받아 구현 된 CustomerViewHolder를 만듬

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView kmj;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
