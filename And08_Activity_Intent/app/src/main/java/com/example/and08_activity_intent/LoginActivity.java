package com.example.and08_activity_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText edt_id, edt_pw;
    Button btn_login;
    TextView tv_join;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edt_id = findViewById(R.id.etd_id);
        edt_pw = findViewById(R.id.edt_pw);
        btn_login = findViewById(R.id.btn_login);
        tv_join = findViewById(R.id.tv_join);

        tv_join.setOnClickListener(v -> {
            Intent intent = new Intent(this, JoinActivity.class);
            startActivity(intent);
        });

        //editText에 있는 글자를 가져오는 메소드 : editText.getText()
        //id가 admin 비밀번호가 admin1234인 경우 로그가 성공이라고 찍히고 그 외에는 실패! 가 찍히게 해보기

//        Toast.makeText(this, "나는 컨텍스트", Toast.LENGTH_SHORT).show();
//        new ContextTest().method(this);


        btn_login.setOnClickListener(v -> {
            //(Activity) Context : 모든 액티비티는 Context 자체
            //Context라는 것은 앱의 현재 상태나 환경에 대한 모든 정보를 제공하고 접근 할 수 있는 인터페이스( static)
            //화면 전환, 토스트 창을 보여주는 등의 디자인 관련 된 기능을 사용하기 위해서는 내가 현재 액티비티를 반드시 알려줘야 할 의무가 있음.

            //Intent 초기화 시 필요한 정보 : 화면 전환 시 -> 1.현재 앱의 상태(현재 화면.. 등), 2.실행이 되어야 할 화면(Activity)의 클래스 위치.
            Log.d("로그인", edt_id.getText()+"");
            Log.d("로그인", edt_pw.getText()+"");
            String id = String.valueOf(edt_id.getText());
            String pw = String.valueOf(edt_pw.getText());
            if(id.equals("admin")&&pw.equals("admin1234")){
                Log.d("로그인", "onCreate: 로그인 성공");
                Intent intent = new Intent(this, MainActivity.class);
                //(LoginActivity.)this -> 현재 위치이므로 생략 가능
                startActivity(intent);
            }
             else{
                Log.d("로그인", "onCreate: 실패");
            }
        });

    }

}