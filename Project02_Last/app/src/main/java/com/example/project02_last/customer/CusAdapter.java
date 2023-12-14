package com.example.project02_last.customer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project02_last.databinding.ItemRecvCusBinding;

public class CusAdapter extends RecyclerView.Adapter<CusAdapter.ViewHolder> {

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRecvCusBinding binding = ItemRecvCusBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ItemRecvCusBinding binding;
        public ViewHolder(@NonNull ItemRecvCusBinding binding) {

            super(binding.getRoot());
            this.binding = binding;

        }
    }
}
