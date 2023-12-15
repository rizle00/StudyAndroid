package com.example.project02_last.customer;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;

import androidx.annotation.NonNull;

import com.example.project02_last.common.CommonConn;
import com.example.project02_last.databinding.DialogCustomerBinding;
import com.google.gson.Gson;

public class CustomerDialog extends Dialog {
    //    Android : Dialog 종류가 많음 -> 머티리얼, 기타 모양을 찾아보고 사용하기 ( 현 :legacy)

    DialogCustomerBinding binding;

//    CustomerVO vo;

    @SuppressLint("SetTextI18n")
    public CustomerDialog(@NonNull Context context, CustomerVO vo) {
        super(context);
//        this.vo = vo;
        binding = DialogCustomerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.tvCusId.setText("고객번호 :" + vo.getCustomer_id());
        binding.edtName.setText(vo.getName());
        binding.edtEmail.setText(vo.getEmail());

        binding.btnApply.setOnClickListener(v -> {

            vo.setEmail(binding.edtEmail.getText().toString());
            vo.setName(binding.edtName.getText().toString());
            new CommonConn(context, "update.cu")
                    .addParamMap("vo", new Gson().toJson(vo)).onExcute((isResult, data) -> {

                dismiss();// 다이얼로그 자체가 안보이게 /show, dismiss
                if(!data.isEmpty()){

                }
            });
        });
    }

}
