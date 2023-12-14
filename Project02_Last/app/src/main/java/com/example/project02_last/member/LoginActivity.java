package com.example.project02_last.member;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.example.project02_last.R;
import com.example.project02_last.common.CommonConn;
import com.example.project02_last.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //error..
        Glide.with(this).load("https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEhrZRAWsM83xaOIa23IXKU0rA6uf1-KDtMIg6s-Jp5xQQm_J0dcYE0bvImQlsowFDzBu9z2kV2tub_Je7FylUqbyE1hw7xVqxY76XJ8d3JTQs8uq8fxkOltE2q-sn6mHG-7LVcX9K7XgQKgtlQSMf4FjwZKxrAUVSIAnkty16dl_O27u_csk7K6UgCS30c/s1600/90d7dc6da4c525eb216ba32e3929943caf9d91de.gif")
                .error(R.drawable.ic_launcher_foreground)
                .fallback(R.drawable.ic_launcher_background)
                .into(binding.imgvLogo);


//        new CommonConn(this, "asd.kmj").addParamMap("param", "adddata").onExcute((isResult, data) -> {
//            Log.d("test", "onCreate: "+isResult+data);
//        });
        binding.btnLogin.setOnClickListener(v -> {
            CommonConn conn =  new CommonConn(this, "login.me");
            conn.addParamMap("user_id", binding.edtId.getText().toString())
                    .addParamMap("user_pw", binding.edtPw.getText().toString());
            conn.onExcute((isResult, data) -> {
                //서버가 응답을 함. (또는 오류)
            });

        });

    }
}