package com.example.project02_last.customer;

import android.app.Dialog;
import android.content.Context;

import androidx.annotation.NonNull;

import com.example.project02_last.databinding.DialogJoinBinding;

public class JoinDialog extends Dialog {

    DialogJoinBinding binding;
    public JoinDialog(@NonNull Context context) {
        super(context);
        binding = DialogJoinBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }
}
