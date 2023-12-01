package com.example.and10_fragmentadapter.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.and10_fragmentadapter.R;


public class MyFragment3 extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        
        View view = inflater.inflate(R.layout.fragment_my3, container, false);
        Button btn_frag3 = view.findViewById(R.id.btn_frag3);
        TextView tv_frag3 = view.findViewById(R.id.tv_frag3);
        btn_frag3.setOnClickListener(v -> {
            tv_frag3.setText("프래그먼트 3 붙었다");
        });
        
        return view;
    }
}