package com.example.project02_last;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.project02_last.common.CommonConn;
import com.example.project02_last.customer.CustomerFragment;
import com.example.project02_last.databinding.ActivityMainBinding;
import com.example.project02_last.file.FileActivity;
import com.example.project02_last.map.KmjMapFragment;

import me.ibrahimsn.lib.OnItemSelectedListener;

public class MainActivity extends AppCompatActivity implements OnItemSelectedListener {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.bottomBar.setOnItemSelectedListener(this);
        onItemSelect(0);
    }

    @Override
    public boolean onItemSelect(int i) {
        Log.d("btm", "onItemSelect: "+i);
        if(i == 0){
            getSupportFragmentManager().beginTransaction().replace(binding.container.getId(), new CustomerFragment()).commit();

        } else if (i==1) {
            Intent intent = new Intent(MainActivity.this, FileActivity.class);
            startActivity(intent);
        } else if (i==2) {
            getSupportFragmentManager().beginTransaction().replace(binding.container.getId(), new KmjMapFragment()).commit();
        }
        return false;
    }
}