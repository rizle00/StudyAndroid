package com.example.and10_fragmentadapter.recycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.and10_fragmentadapter.R;

public class ExamActivity extends AppCompatActivity {

    RecyclerView recv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);
        recv = findViewById(R.id.recv); //"View" : 보여주는 기능만 구현 "Adapter" 뷰의 모든 모양이나 개수등의 항목을 설정(ViewHolder)


        ExamAdapter adapter = new ExamAdapter(getLayoutInflater());
        recv.setAdapter(adapter);
        recv.setLayoutManager(new LinearLayoutManager(this));// layoutmanager  방향성.
    }
}