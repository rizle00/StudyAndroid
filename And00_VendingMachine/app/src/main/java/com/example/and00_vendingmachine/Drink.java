package com.example.and00_vendingmachine;

import android.widget.Button;
import android.widget.TextView;

public class Drink {
    //음료명, 음료 가격, 음료 개수
    //각각의 데이터를 변수를 하나씩 지정하여 사용하기 보다는 묶어서 관리하는게 조금 더 효율적(데이터 정합성이 높음)
    //기)drinkCnt1; drinkPrice1...2...3..

    private String name;
    private int price, cnt;
     TextView tv_name, tv_quan;
     Button btn_order;

    public Drink(String name, int price, int cnt, TextView tv_name, TextView tv_quan, Button btn_order) {
        this.name = name;
        this.price = price;
        this.cnt = cnt;
        this.tv_name = tv_name;
        this.tv_quan = tv_quan;
        this.btn_order = btn_order;
        
        tv_name.setText(name+" "+price+" 원");
        tv_quan.setText(cnt+"  개 남음");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
        tv_quan.setText(cnt+ " 개 남음");
    }
}
