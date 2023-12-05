package com.example.and10_fragmentadapter.melon;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.and10_fragmentadapter.R;
import com.example.and10_fragmentadapter.recycler.RecyclerAdapter;

import java.util.ArrayList;


public class MelonFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_melon, container, false);
        RecyclerView recv = v.findViewById(R.id.recV2);
        ArrayList<MelonDTO> list  = new ArrayList<>();
        list.add(new MelonDTO(R.drawable.chart_img1,1,"Perfect Night", "LE SSERAFILM(르세라핌)"));
        list.add(new MelonDTO(R.drawable.chart_img2,2,"Drama", "aespa"));
        list.add(new MelonDTO(R.drawable.chart_img3,3,"Baddie", "IVE(아이브)"));
        list.add(new MelonDTO(R.drawable.chart_img4,4,"To.X", "태연(TAEYEON)"));
        list.add(new MelonDTO(R.drawable.chart_img5,5,"사랑은 늘 도망가", "임영웅"));
        list.add(new MelonDTO(R.drawable.chart_img6,6,"Seven(feat.Latto)-Clean Ver", "정국"));
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(inflater, list);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recv.setLayoutManager(manager);
        recv.setAdapter(adapter);

        return  v;
    }
}