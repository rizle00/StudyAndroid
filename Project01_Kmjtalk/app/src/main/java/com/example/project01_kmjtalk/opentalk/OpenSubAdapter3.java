package com.example.project01_kmjtalk.opentalk;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project01_kmjtalk.databinding.ItemOpentalkChat2Binding;
import com.example.project01_kmjtalk.databinding.ItemOpentalkChatVerticalBinding;

import java.util.ArrayList;

public class OpenSubAdapter3 extends RecyclerView.Adapter<OpenSubAdapter3.ViewHolder> {

    ArrayList<OpenSubDTOS.OpenSub3DTO> list;

    public OpenSubAdapter3(ArrayList<OpenSubDTOS.OpenSub3DTO> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         // LayoutInflater 생성
        ItemOpentalkChatVerticalBinding binding = ItemOpentalkChatVerticalBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
        h.binding.imgvProfile.setImageResource(list.get(i).getBackgroundImgRes());
        h.binding.tvName.setText(list.get(i).getRoomTitle());
        h.binding.tvNum.setText(list.get(i).getChatCnt()+"명 참여중");
        h.binding.tvTime.setText(list.get(i).getRecentChat());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ItemOpentalkChatVerticalBinding binding;// 바인딩 처리
        public ViewHolder(@NonNull ItemOpentalkChatVerticalBinding binding) {

            super(binding.getRoot());// 전체 레이아웃
            this.binding = binding;
        }
    }
}
