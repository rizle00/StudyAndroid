package com.example.project01_kmjtalk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.project01_kmjtalk.chat.ChatFragment;
import com.example.project01_kmjtalk.databinding.ActivityMainBinding;
import com.example.project01_kmjtalk.friend.FriendFragment;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ActionBar actionBar = getSupportActionBar();
        actionBar.setElevation(0f);


//        binding.bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                return false;
//            }
//        });

//        getSupportFragmentManager().beginTransaction().replace(R.id.container, new FriendFragment()).commit();
        changeFragment(new FriendFragment());
        binding.bottomNav.setOnItemSelectedListener(item -> {
            if(item.getItemId()==R.id.tab1){
//                actionBar.setTitle("친구");
                changeFragment(new FriendFragment());
            } else if(item.getItemId()==R.id.tab2){
                changeFragment(new ChatFragment());

            }  else if(item.getItemId()==R.id.tab3){

            }  else if(item.getItemId()==R.id.tab4){

            }  else if(item.getItemId()==R.id.tab5){

            }

            actionBar.setTitle(item.getTitle());

            return false;
        });


    }

    public void changeFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }
}