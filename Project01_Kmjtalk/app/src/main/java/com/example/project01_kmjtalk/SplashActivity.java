package com.example.project01_kmjtalk;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.webkit.RenderProcessGoneDetail;

public class SplashActivity extends AppCompatActivity {

//    스플래시 액티비티 : 마케팅효과, 초기 데이터 로딩 시간..
//    Handler() : 작업을 지연시키거나 메세지로 보낸 후 사용을 위한 객체 (예약)
//    runOnUiThread : 백그라운드에서 메인(UI) 스레드를 전달(바꿈)할 때 사용. (안정성 ↑)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
//        ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().hide();//액션바 숨기기 (NoActionBar의 경우 NullPointerException 발생!)

//      ProgressDialog : 로딩중에 사용자가 어떤 동작을 하고 있는지 인지를 못하는 경우 프로그램을 오류나, 버그로 의심을 하고
//        기다림을 멈춤-> 조작,  조작(x) -> 앱은 로딩 중이다(0)
        ProgressDialog dialog = new ProgressDialog(this);
        dialog.setTitle("Kmj Talk");
        dialog.setMessage("로딩 중 대기 바랍니다...");
        dialog.setCancelable(false);// 다이얼로그를 취소하지 못하게 처리
        dialog.show();//실제 보이는 처리

        new Handler().postDelayed(()->{
            dialog.dismiss();
            intentMain();
            Log.d("스플래시", "onCreate: 5초후");
        }, 5 * 1000);
    }

    public void intentMain(){
        runOnUiThread(()->{
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}