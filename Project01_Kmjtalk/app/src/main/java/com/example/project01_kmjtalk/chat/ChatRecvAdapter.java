package com.example.project01_kmjtalk.chat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project01_kmjtalk.databinding.ItemChatRecvBinding;
import com.example.project01_kmjtalk.friend.FriendDTO;

import java.util.ArrayList;

public class ChatRecvAdapter extends RecyclerView.Adapter<ChatRecvAdapter.viewHolder> {

    LayoutInflater inflater;
    ArrayList<FriendDTO> list;

    Context context;

    public ChatRecvAdapter(LayoutInflater inflater, ArrayList<FriendDTO> list, Context context) {
        this.inflater = inflater;
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemChatRecvBinding binding = ItemChatRecvBinding.inflate(inflater, parent, false);
        return new viewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class viewHolder extends RecyclerView.ViewHolder{

        ItemChatRecvBinding binding;
        public viewHolder(@NonNull ItemChatRecvBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
