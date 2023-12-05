package com.example.and10_fragmentadapter.melon;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.and10_fragmentadapter.R;
import com.example.and10_fragmentadapter.listV.ListDTO;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {


    LayoutInflater inflater;
    ArrayList<MelonDTO> list;

    public RecyclerViewAdapter(LayoutInflater inflater, ArrayList<MelonDTO> list) {
        this.inflater = inflater;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_melon, parent, false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
        h.imgv_melon.setImageResource(list.get(i).getImgRes_melon());
        h.tv_rank.setText(list.get(i).getRank()+"");// setText에는 int가 들어가면 안됨, 리소스로 파악하고 찾음
        h.tv_title.setText(list.get(i).getTitle());
        h.tv_singer.setText(list.get(i).getSinger());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgv_melon;
        TextView tv_rank, tv_title, tv_singer;
        public ViewHolder(@NonNull View v) {
            super(v);
            imgv_melon = v.findViewById(R.id.imgv_melon);
            tv_rank = v.findViewById(R.id.tv_rank);
            tv_title = v.findViewById(R.id.tv_title);
            tv_singer = v.findViewById(R.id.tv_singer);

        }
    }
}
