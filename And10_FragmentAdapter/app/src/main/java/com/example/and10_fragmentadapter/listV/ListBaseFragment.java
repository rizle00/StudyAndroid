package com.example.and10_fragmentadapter.listV;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.example.and10_fragmentadapter.R;

public class ListBaseFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list, container, false);

        ListView listV = view.findViewById(R.id.listV);
        ListBaseAdapter adapter = new ListBaseAdapter(inflater);
        listV.setAdapter(adapter);
        return view;
    }
}