package com.example.carrot_eaxm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imgv_profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgv_profile = findViewById(R.id.imgv_profile);

        imgv_profile.setOnClickListener(v -> {
            Log.d("이미지 클릭", "onClick: ");
        });
    }
}