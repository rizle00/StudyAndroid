package com.example.project01_kmjtalk.friend;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project01_kmjtalk.R;
import com.example.project01_kmjtalk.databinding.FragmentFriendBinding;

import java.util.ArrayList;


public class FriendFragment extends Fragment {

    FragmentFriendBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentFriendBinding.inflate(inflater, container, false);
        binding.recvFriend.setAdapter(new FreindRecvAdapter(inflater, getFriend()));
        binding.recvFriend.setLayoutManager(new LinearLayoutManager(getContext()));

        return binding.getRoot();
    }

    ArrayList<FriendDTO> getFriend(){
        ArrayList<FriendDTO> list = new ArrayList<>();
        list.add(new FriendDTO(R.drawable.profile1, R.drawable.bg1, "김이름", "（；´д｀）ゞ허허"));
        list.add(new FriendDTO(R.drawable.profile2, R.drawable.bg2, "김서리", "(´。＿。｀)귤팔아요"));
        list.add(new FriendDTO(R.drawable.profile3, R.drawable.bg3, "이사라", "한재골타고싶다"));
        list.add(new FriendDTO(R.drawable.profile4, R.drawable.bg4, "박불곰", "크아아앙"));
        list.add(new FriendDTO(R.drawable.profile5, R.drawable.bg5, "강기준", "💕 327"));
        list.add(new FriendDTO(R.drawable.profile6, R.drawable.bg6, "서이", "오늘은 ..."));
        list.add(new FriendDTO(R.drawable.profile7, R.drawable.bg7, "예림", "살아있음 w(ﾟДﾟ)w"));
        list.add(new FriendDTO(R.drawable.profile8, R.drawable.bg8, "재헌", "카톡 안됨 문자"));
        list.add(new FriendDTO(R.drawable.profile9, R.drawable.bg9, "한호", "아 술마시고 싶다"));
        list.add(new FriendDTO(R.drawable.profile10, R.drawable.bg10, "제이", ""));
     return list;}
}