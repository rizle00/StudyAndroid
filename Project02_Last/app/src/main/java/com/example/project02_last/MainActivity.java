package com.example.project02_last;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.project02_last.common.CommonConn;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new CommonConn(this, "asd.kmj").addParamMap("param", "last").onExcute((isResult, data) -> {
            Log.d("Last", "onCreate: "+data);
        });
    }
}