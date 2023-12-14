package com.example.and00_middletoand;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.and00_middletoand.middle.ApiClient;
import com.example.and00_middletoand.middle.ApiInterface;
import com.example.and00_middletoand.middle.MiddleVO;
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
//      ApiInterface가 초기화 = Retrofit객체.create(ApiInterface.class);
        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        MiddleVO vo = new MiddleVO();
        vo.setDoubleF(3.14);
        vo.setIntF(11);
        vo.setStr("kmjStr");

        String jsonData = new Gson().toJson(vo);

        HashMap<String, Object> params = new HashMap<>();
        params.put("andParam", "kmj");
        params.put("andParam", jsonData); // overwrite

        apiInterface.getData("vaa.and",params).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                //응답이 있음
                Log.d("레트로핏", "onResponse: " +response.body());
                Log.d("레트로핏", "onResponse: " +response.errorBody());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
//              서버 꺼짐 등의 이유로 실패
                t.printStackTrace();
                Log.d("레트로핏", "onFailure: "+t.getMessage());
                Log.d("레트로핏", "onFailure: "+t.toString());
            }
        });
//        excute -> 사용 x
    }
}