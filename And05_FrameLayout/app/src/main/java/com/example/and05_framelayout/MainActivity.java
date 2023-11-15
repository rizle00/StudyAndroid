package com.example.and05_framelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button btn_before, btn_after; // null
    ImageView imgV1, imgV2, imgV3; // null -> 객체를 이런 이름으로 사용하겠다(선언)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // activity_main.xml 에 있는 내용들을 메모리에 올림.

        btn_before = findViewById(R.id.btn_before);
        btn_after = findViewById(R.id.btn_after);
        imgV1 = findViewById(R.id.imgV1);
        imgV2 = findViewById(R.id.imgV2);
        imgV3 = findViewById(R.id.imgV3);
        //View를 상속받은 모든 위젯들은 (화면에 보이는 모든 것들, 레이아웃 포함) 사용자의 클릭을 감지하는 View.OnclickListener를 가지고 있다.
        btn_before.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //여기서 이벤트 처리
            }
        });

        btn_before.setOnClickListener(v -> {
            //사용자가 버튼을 누름
            //몇 번째 누른건지에 따라서 분기를 시켜야함
            // loop
            // logd, i, e, ...
            //logd를 활용!
            imgV3.setVisibility(View.GONE);
            Log.d("Kmj Log", "내가 쓰고 싶은 값");
            Log.e("Kmj Log", " 에러 로그 ", null );
            Log.i("Kmj Log", "Info : 뭔가 정보를 표기할 때 ");
            // 여기서 이벤트 처리, 마지막 세팅만 적용됨, 계속 덮어쓰기
        });

    }
}