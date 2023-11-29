package com.example.and00_vendingmachine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tv_name1, tv_name2, tv_name3, tv_name4,
            tv_quan1, tv_quan2, tv_quan3, tv_quan4,
            tv_money;
    ImageView imgv1, imgv2, imgv3, imgv4;
    Button btn_order1, btn_order2, btn_order3, btn_order4,
            btn_input, btn_output;
    EditText edt_money;

    int money;
    int [] counts;
    HashMap<String, Integer> map;
//    int drinkCnt1, drinkPrice1;
//    int drinkCnt2, drinkPrice2;
//    int drinkCnt3, drinkPrice3;
//    int drinkCnt4, drinkPrice4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findId();
        btn_input.setOnClickListener(this);

//        Drink drink1 = new Drink("콜라", 800, 10, tv_name1, tv_quan1, btn_order1);
//        Drink drink2 = new Drink("사이다", 1000, 10, tv_name2, tv_quan2, btn_order2);
//        Drink drink3 = new Drink("환타", 1200, 10, tv_name3, tv_quan3, btn_order3);
//        Drink drink4 = new Drink("데미소다", 1300, 10, tv_name4, tv_quan4, btn_order4);
        ArrayList<Drink> drinkList = new ArrayList<>();
        drinkList.add(new Drink("콜라", 800, 10, tv_name1, tv_quan1, btn_order1));
        drinkList.add(new Drink("사이다", 1000, 10, tv_name2, tv_quan2, btn_order2));
        drinkList.add(new Drink("환타", 1200, 10, tv_name3, tv_quan3, btn_order3));
        drinkList.add(new Drink("데미소다", 1300, 10, tv_name4, tv_quan4, btn_order4));
        counts = new int[drinkList.size()];
        for (int i = 0; i<drinkList.size(); i++){
            final int IDX = i;
            drinkList.get(i).btn_order.setOnClickListener(v -> {
                if(money<drinkList.get(IDX).getPrice()) {
                    Toast.makeText(this, "잔액이 부족합니다", Toast.LENGTH_SHORT).show();
                    return;
                } else if (drinkList.get(IDX).getCnt()<1) {
                        Toast.makeText(this, "재고가 부족합니다", Toast.LENGTH_SHORT).show();
                        return;
                    }
                drinkList.get(IDX).setCnt(drinkList.get(IDX).getCnt()-1);
                money -= drinkList.get(IDX).getPrice();
                tv_money.setText("잔돈 "+money+"원");
                counts[IDX]++;
            });

        }
        btn_output.setOnClickListener(v -> {
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        });
    }

    public void findId(){

        tv_name1 = findViewById(R.id.tv_name1);
        tv_name2 = findViewById(R.id.tv_name2);
        tv_name3 = findViewById(R.id.tv_name3);
        tv_name4 = findViewById(R.id.tv_name4);
        tv_quan1 = findViewById(R.id.tv_quan1);
        tv_quan2 = findViewById(R.id.tv_quan2);
        tv_quan3 = findViewById(R.id.tv_quan3);
        tv_quan4 = findViewById(R.id.tv_quan4);
        tv_money = findViewById(R.id.tv_money);
        imgv1 = findViewById(R.id.imgv1);
        imgv2 = findViewById(R.id.imgv2);
        imgv3 = findViewById(R.id.imgv3);
        imgv4 = findViewById(R.id.imgv4);
        btn_order1 = findViewById(R.id.btn_order1);
        btn_order2 = findViewById(R.id.btn_order2);
        btn_order3 = findViewById(R.id.btn_order3);
        btn_order4 = findViewById(R.id.btn_order4);
        btn_input = findViewById(R.id.btn_input);
        btn_output = findViewById(R.id.btn_output);
        edt_money = findViewById(R.id.edt_money);

    }

    @Override
    public void onClick(View v) {
        btn_input.setOnClickListener(v1 ->{

            money += getEditTextInt(edt_money);
            setTv_money();
            edt_money.setText("");

        } );
//        btn_order1.setOnClickListener(v1 -> {
//            if(money<drinkPrice1){
//                Toast.makeText(this, "잔액이 부족합니다", Toast.LENGTH_SHORT).show();
//                return;
//            } else if (drinkCnt1<1) {
//                Toast.makeText(this, "재고가 부족합니다", Toast.LENGTH_SHORT).show();
//                return;
//            }
//            drinkCnt1--;
//            money -= drinkPrice1;
//            tv_quan1.setText(drinkCnt1+"개 남음");
//            tv_money.setText("잔돈 "+money+"원");
//        });
    }
    public int getEditTextInt(EditText editText){
        try {
            int rtnInt = Integer.parseInt(editText.getText().toString());
            if(rtnInt>0){
                return rtnInt;
            } else{
                
            Toast.makeText(this, "0이상의 값을 입력해 주세요",Toast.LENGTH_SHORT).show();
            }

        }catch (NumberFormatException e){
            
            Toast.makeText(this, "숫자를 입력해 주세요",Toast.LENGTH_SHORT).show();
        }
        catch (Exception e){
            Toast.makeText(this, "오류 발생, 재시도 하세요",Toast.LENGTH_SHORT).show();
        }
        return 0;
    }

    public void setTv_money(){
        tv_money.setText("잔돈 "+money+"원");
    }
}