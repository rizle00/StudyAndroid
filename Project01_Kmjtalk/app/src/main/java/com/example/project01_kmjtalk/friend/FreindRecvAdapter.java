package com.example.project01_kmjtalk.friend;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project01_kmjtalk.databinding.ItemFriendRecvBinding;

import java.util.ArrayList;

public class FreindRecvAdapter extends RecyclerView.Adapter<FreindRecvAdapter.ViewHoler> {


    LayoutInflater inflater; //parent를 이용해서 초기화하는 방법 나중에
    ArrayList<FriendDTO> list;

    Context context;

    public FreindRecvAdapter(LayoutInflater inflater, ArrayList<FriendDTO> list, Context context) {
        this.inflater = inflater;
        this.list = list;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemFriendRecvBinding binding = ItemFriendRecvBinding.inflate(inflater, parent, false);
        return new ViewHoler(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoler h, int i) {
        h.binding.imgvProfile.setImageResource(list.get(i).getProfileImg());
        h.binding.tvName.setText(list.get(i).getName());
        h.binding.tvMsg.setText(list.get(i).getMsg());

        h.binding.lnFriend.setOnClickListener(v -> {
            Intent intent = new Intent(context, FriendDetailActivity.class);
            intent.putExtra("dto", list.get(i));
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


//    1.ViewHolder( view ) -> Binding을 사용해보기

    public class ViewHoler  extends RecyclerView.ViewHolder{

        ItemFriendRecvBinding binding;
        public ViewHoler(@NonNull ItemFriendRecvBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
