package com.example.and10_fragmentadapter.listV;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.and10_fragmentadapter.R;

import java.util.ArrayList;
import java.util.Random;

public class ListBaseFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list, container, false);

        ListView listV = view.findViewById(R.id.listV);
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
        ListBaseAdapter adapter = new ListBaseAdapter(inflater,list);
        listV.setAdapter(adapter);
        return view;
    }
}