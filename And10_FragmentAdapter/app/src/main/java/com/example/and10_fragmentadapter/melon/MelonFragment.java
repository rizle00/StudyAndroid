package com.example.and10_fragmentadapter.melon;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.and10_fragmentadapter.R;
import com.example.and10_fragmentadapter.recycler.RecyclerAdapter;


public class MelonFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_melon, container, false);
        RecyclerView recv = v.findViewById(R.id.recV2);
        return  v;
    }
}