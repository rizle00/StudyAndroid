package com.example.and10_fragmentadapter.recycler;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.and10_fragmentadapter.R;
import com.example.and10_fragmentadapter.listV.ListDTO;

import java.util.ArrayList;
import java.util.Random;


public class RecyclerFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_recycler, container, false);
        RecyclerView recV = v.findViewById(R.id.recV);

        ArrayList<ListDTO> list = new ArrayList<>();
        list.add(new ListDTO(R.drawable.lay1, new Random().nextInt(30)+1, "조롱이","남"));
        list.add(new ListDTO(R.drawable.lay2, new Random().nextInt(30)+1, "찌룽이","여"));
        list.add(new ListDTO(R.drawable.lay3, new Random().nextInt(30)+1, "켄터키","여"));
        list.add(new ListDTO(R.drawable.lay4, new Random().nextInt(30)+1, "스트롱","여"));
        list.add(new ListDTO(R.drawable.lay5, new Random().nextInt(30)+1, "샤이가이","남"));
        list.add(new ListDTO(R.drawable.lay1, new Random().nextInt(30)+1, "조롱이","남"));
        list.add(new ListDTO(R.drawable.lay2, new Random().nextInt(30)+1, "찌룽이","여"));
        list.add(new ListDTO(R.drawable.lay3, new Random().nextInt(30)+1, "켄터키","여"));
        list.add(new ListDTO(R.drawable.lay4, new Random().nextInt(30)+1, "스트롱","여"));
        list.add(new ListDTO(R.drawable.lay5, new Random().nextInt(30)+1, "샤이가이","남"));
        list.add(new ListDTO(R.drawable.lay1, new Random().nextInt(30)+1, "조롱이","남"));
        list.add(new ListDTO(R.drawable.lay2, new Random().nextInt(30)+1, "찌룽이","여"));
        list.add(new ListDTO(R.drawable.lay3, new Random().nextInt(30)+1, "켄터키","여"));
        list.add(new ListDTO(R.drawable.lay4, new Random().nextInt(30)+1, "스트롱","여"));
        list.add(new ListDTO(R.drawable.lay5, new Random().nextInt(30)+1, "샤이가이","남"));

        RecyclerAdapter adapter = new RecyclerAdapter(inflater, list);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recV.setLayoutManager(manager);
        recV.setAdapter(adapter);

        return v;
    }
}