package com.example.project01_kmjtalk.friend;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.project01_kmjtalk.R;
import com.example.project01_kmjtalk.databinding.ActivityFriendDetailBinding;

public class FriendDetailActivity extends AppCompatActivity {

    ActivityFriendDetailBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityFriendDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();
        //===  스테이터스바를 투명하게 만들고 액티비티를 조금 키우는 작업
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        window.setStatusBarColor(Color.TRANSPARENT);
        View view = getWindow().getDecorView();
        view.setSystemUiVisibility(view.getSystemUiVisibility() & ~view.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

//        따로 공부 x

        FriendDTO dto = (FriendDTO) getIntent().getSerializableExtra("dto");
        binding.tvName.setText(dto.getName());
        binding.imgvProfile.setImageResource(dto.getProfileImg());
        binding.imgvBg.setImageResource(dto.getSubImg());

        binding.imgvClose.setOnClickListener(v -> {
            finish();
        });
    }
}