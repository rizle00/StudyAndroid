package com.example.project02_last.member;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.project02_last.MainActivity;
import com.example.project02_last.R;
import com.example.project02_last.common.CommonConn;
import com.example.project02_last.databinding.ActivityLoginBinding;
import com.google.gson.Gson;
import com.kakao.sdk.auth.model.OAuthToken;
import com.kakao.sdk.common.KakaoSdk;
import com.kakao.sdk.user.UserApiClient;
import com.navercorp.nid.NaverIdLoginSDK;
import com.navercorp.nid.oauth.NidOAuthLogin;
import com.navercorp.nid.oauth.OAuthLoginCallback;
import com.navercorp.nid.profile.NidProfileCallback;
import com.navercorp.nid.profile.data.NidProfileResponse;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;

public class LoginActivity extends AppCompatActivity {


    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //    NaverIdLoginSDK.initialize(context, {OAUTH_CLIENT_ID}, {OAUTH_CLIENT_SECRET}, {OAUTH_CLIENT_NAME})
//        values -> key.xml (gitignore)
//      getString


//        getHashKey();


        NaverIdLoginSDK.INSTANCE.initialize(this, getString(R.string.CLIENT_ID), getString(R.string.CLIENT_SECERET), "Project02_Last");

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
            login(binding.edtId.getText().toString(), binding.edtPw.getText().toString());

        });

        naverLogin();
        binding.imgvKakaoLogin.setOnClickListener(v -> {

            kakaoLogin(this);
        });
    }

    //  kakao는 key 값을 우리에게 제공 x (email, mobile)
    public void kakaoLogin(Context context) {
//        KakaoSdk.init(this, "{NAVIVE_APP_KEY}");
        KakaoSdk.init(this, getString(R.string.NATIVE_APP_KEY));
//        카카오톡 설치 여부 , true -> 설치가 되어있으면 앱으로 인증(권장)
//                          false-> 웹뷰(크롬)를 이용해서 인증
        Function2<OAuthToken, Throwable, Unit> callback = new Function2<OAuthToken, Throwable, Unit>() {
            @Override
            public Unit invoke(OAuthToken oAuthToken, Throwable error) {
                if (error == null) {
                    Log.d("kakao", "invoke: " + oAuthToken.getAccessToken());
//                    kakaotalk -> 하단 메뉴 5 더보기 -> 우측 상단 설정 -> 카카오 계정 -> 연결된 서비스 관리 -> 외부서비스
                    UserApiClient.getInstance().me((user, throwable) -> {
                        if (throwable == null) {
                            Log.d("kakao", "invoke: (정보)" + user.getKakaoAccount().getProfile().getNickname());
                            Log.d("kakao", "invoke: (정보)" + user.getKakaoAccount().getProfile().getProfileImageUrl());
                        } else {
                            Log.d("kakao", "invoke: 오류 " + throwable.getMessage());
                        }

                        return null;
                    });


                } else {
                    Log.d("kakao", "invoke: " + error.getMessage());
                }
                return null;
            }
        };

//            Function2<OAuthToken, Throwable, Unit> callback2 = (oAuthToken, throwable) -> {
//
//                return null;
//            };

        if(UserApiClient.getInstance().isKakaoTalkLoginAvailable(context)){
                Log.d("카카오", "kakaoLogin: 카카오톡이 설치 되어 있음 -> APP");
                UserApiClient.getInstance().loginWithKakaoTalk(context, callback);
            }    else{
                Log.d("카카오", "kakaoLogin: 카카오톡이 설치 X -> WEB");
                UserApiClient.getInstance().loginWithKakaoAccount(context, callback);
            }
        }


        public void naverLogin () {
            binding.buttonOAuthLoginImg.setOAuthLogin(new OAuthLoginCallback() {
                @Override
                public void onSuccess() {
                    Log.d("naver", "onSuccess: " + NaverIdLoginSDK.INSTANCE.getAccessToken());

                    new NidOAuthLogin().callProfileApi(new NidProfileCallback<NidProfileResponse>() {
                        @Override
                        public void onSuccess(NidProfileResponse nidProfileResponse) {
//

                            assert nidProfileResponse.getProfile() != null;
                            Log.d("naver", "onSuccess: " + nidProfileResponse.getProfile().getEmail());

                            login(nidProfileResponse.getProfile().getEmail(), null);
                            Log.d("naver", "onSuccess: " + nidProfileResponse.getProfile().getMobile());
                            Log.d("naver", "onSuccess: " + nidProfileResponse.getProfile().getName());
                            Log.d("naver", "onSuccess: " + nidProfileResponse.getProfile().getProfileImage());
                        }

                        @Override
                        public void onFailure(int i, @NonNull String s) {

                        }

                        @Override
                        public void onError(int i, @NonNull String s) {

                        }
                    });
                }

                @Override
                public void onFailure(int i, @NonNull String s) {
                    Log.d("naver", "onFailure: ");
                }

                @Override
                public void onError(int i, @NonNull String s) {
                    Log.d("naver", "onError: ");

                }
            });
        }

        private void getHashKey () {
            PackageInfo packageInfo = null;
            try {
                packageInfo = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
            if (packageInfo == null)
                Log.e("KeyHash", "KeyHash:null");

            assert packageInfo != null;
            for (Signature signature : packageInfo.signatures) {
                try {
                    MessageDigest md = MessageDigest.getInstance("SHA");
                    md.update(signature.toByteArray());
                    Log.d("KeyHash", Base64.encodeToString(md.digest(), Base64.DEFAULT));
                } catch (NoSuchAlgorithmException e) {
                    Log.e("KeyHash", "Unable to get MessageDigest. signature=" + signature, e);
                }
            }
        }

        public void login (String user_id, String user_pw){
            CommonConn conn = new CommonConn(this, "login.me");
            conn.addParamMap("user_id", user_id);

            if(user_pw==null){
                conn.addParamMap("social","y");
            }else{
                conn.addParamMap("user_pw", user_pw);
            }
            conn.onExcute((isResult, data) -> {
                //서버가 응답을 함. (또는 오류)
//                1.toJson (내가 String json으로 데이터를 줘야함)
//                2.fromJson (String json을 받아와서 내가 원하는 형태로 바꿈)
                MemberVO vo = new Gson().fromJson(data, MemberVO.class);
                if (vo == null) {
                    Toast.makeText(this, "아이디 또는 패스워드 틀림", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            });
        }

}
