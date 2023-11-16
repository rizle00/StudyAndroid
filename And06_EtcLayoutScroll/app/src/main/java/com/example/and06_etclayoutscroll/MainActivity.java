package com.example.and06_etclayoutscroll;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv_text;
    ScrollView scroll_v;
    HorizontalScrollView scroll_h;
    View btm_nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tv_text = findViewById(R.id.tv_text);
        btm_nav = findViewById(R.id.btm_nav);
        scroll_v = findViewById(R.id.scroll_v);
        scroll_h = findViewById(R.id.scroll_h);

        btm_nav.setOnClickListener(v -> {
            Log.d("scroll location", "getScrollY: "+scroll_v.getScrollY());
            Log.d("scroll location", "getScrollX: "+scroll_h.getScrollX());
            scroll_v.scrollTo(0,scroll_v.getScrollY()+100);
            scroll_h.smoothScrollTo(scroll_h.getScrollX()+100,0);
        });
//        tv_text.setText(1); int형을 넣으면  res하위에 있는 리소스 아이디로 판단. String 형태로 바꿔서 넣어줘야함
//         int errorNum =1;
//        tv_text.setText(errorNum);
        
        tv_text.setText("글자"); // 기존 글자를 현재 파라메터의 String으로 바꿈
        tv_text.append(" 붙이기");
        for (int i =0; i<40; i++){

            for (int j =0; j<30; j++){
                tv_text.append("잘려라"+j);
            }tv_text.append("\n붙어라");
        }

    }


}