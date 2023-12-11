package com.example.project01_kmjtalk.opentalk;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project01_kmjtalk.databinding.ItemOpentalkChatBinding;

import java.util.ArrayList;

public class OpenSubAdapter1 extends RecyclerView.Adapter<OpenSubAdapter1.ViewHolder> {

    ArrayList<OpenSubDTOS.OpenSub1DTO> list;

    public OpenSubAdapter1(ArrayList<OpenSubDTOS.OpenSub1DTO> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         // LayoutInflater 생성
        ItemOpentalkChatBinding binding = ItemOpentalkChatBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
        h.binding.imgvChat1.setImageResource(list.get(i).getImgTitle());
        h.binding.tvChatcnt.setText(list.get(i).getChatCnt()+"");
        h.binding.tvMsg.setText(list.get(i).getRecentChat());
        h.binding.tvDate.setText(list.get(i).getChatDate());
        h.binding.tvName.setText(list.get(i).getRoomTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ItemOpentalkChatBinding binding;// 바인딩 처리
        public ViewHolder(@NonNull ItemOpentalkChatBinding binding) {

            super(binding.getRoot());// 전체 레이아웃
            this.binding = binding;
        }
    }
}
