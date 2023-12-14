package com.example.exam00_middletoand;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.exam00_middletoand.common.CommonConn;
import com.example.exam00_middletoand.common.CommonRetClient;
import com.example.exam00_middletoand.common.CommonService;
import com.example.exam00_middletoand.common.MiddleVO;
import com.google.gson.Gson;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        옵저버 패턴 순서 2번
//        양쪽은 같은 인터페이스를 참조한다
        new CommonConn(this,"aaa.kmj").onExcute(new CommonConn.KmjCallBack() {
            @Override
            public void onResult(boolean isResult, String data) {
                Log.d("Common", "onResult: "+data);
                Log.d("Common", "onResult: "+isResult);
            }
        });

//        CommonService commonService = CommonRetClient.getApiClient().create(CommonService.class);
//        HashMap<String, Object> params = new HashMap<>();
//        MiddleVO vo = new MiddleVO();
//        vo.setStr("kaaaa");
//        vo.setDoubleF(3.333);
//        vo.setIntF(1923);
//        String gData = new Gson().toJson(vo);
//        params.put("par",gData);



//        commonService.getData("asd.kmj", params).enqueue(new Callback<String>() {
//            @Override
//            public void onResponse(Call<String> call, Response<String> response) {
//                Log.d("레레", "onResponse: "+response.body());
//            }
//
//            @Override
//            public void onFailure(Call<String> call, Throwable t) {
//
//            }
//        });
    }
}