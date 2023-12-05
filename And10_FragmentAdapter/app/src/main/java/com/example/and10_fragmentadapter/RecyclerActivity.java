package com.example.and10_fragmentadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.and10_fragmentadapter.melon.MelonFragment;

public class RecyclerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        getSupportFragmentManager().beginTransaction().replace(R.id.container1, new MelonFragment()).commit();
    }
}