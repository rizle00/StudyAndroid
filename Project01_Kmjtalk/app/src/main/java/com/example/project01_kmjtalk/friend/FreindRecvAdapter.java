package com.example.project01_kmjtalk.friend;

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

    public FreindRecvAdapter(LayoutInflater inflater, ArrayList<FriendDTO> list) {
        this.inflater = inflater;
        this.list = list;
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
