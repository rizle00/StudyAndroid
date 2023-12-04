package com.example.and10_fragmentadapter.recycler;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.and10_fragmentadapter.R;
import com.example.and10_fragmentadapter.listV.ListDTO;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.KmjViewHolder> {


//    onCreateViewHolder : 내가 만들어둔  ViewHolder를 직접 만들어서 return을 해줌
//    1회성으로 생성이 완료되면 다시 메소드를 실행 x
//    LayoutInflater가 필요하다!!

    LayoutInflater inflater;
    ArrayList<ListDTO> list;

    public RecyclerAdapter(LayoutInflater inflater, ArrayList<ListDTO> list) {
        this.inflater = inflater;
        this.list = list;
    }

    @NonNull
    @Override
    public KmjViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("리사이클뷰", "onCreateViewHolder: ");
        View v = inflater.inflate(R.layout.item_listv, parent, false);
        KmjViewHolder holder = new KmjViewHolder(v);
        return holder;
    }

//    onBindViewHolder : onCreateViewHolder에서 만들어둔 ViewHolder에 데이터를 넣고 다시 우리한테 줌(데이터 바인딩 처리)

    @Override
    public void onBindViewHolder(@NonNull KmjViewHolder h, int i) {
        h.imgv_lay.setImageResource(list.get(i).getImgRes());
        h.tv_name.setText(list.get(i).getName());
        h.tv_gender.setText(list.get(i).getGender());
        h.tv_age.setText(list.get(i).getAge());

    }

//    몇 개의 칸이 필요한지 써주는 구간: list.size()
    @Override
    public int getItemCount() {
        return list.size();
    }

//    1.ViewHolder라는 클래스를 내부에 만들어준다.( 뷰들을 묶어두기 위한 DTO)
//    1-1. extends ViewHolder를 해줌.
//      View itemView : View v = LayoutInflater.inflate(...);

    public class KmjViewHolder extends RecyclerView.ViewHolder {

        ImageView imgv_lay;
        TextView tv_name, tv_gender, tv_age;

        public KmjViewHolder(@NonNull View v) {
            super(v);
            imgv_lay = v.findViewById(R.id.imgv_lay);
            tv_name = v.findViewById(R.id.tv_name);
            tv_gender = v.findViewById(R.id.tv_gender);
            tv_age = v.findViewById(R.id.tv_age1);
        }
    }
}
