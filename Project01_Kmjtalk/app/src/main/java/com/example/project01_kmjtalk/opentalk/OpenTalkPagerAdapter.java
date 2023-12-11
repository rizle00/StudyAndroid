package com.example.project01_kmjtalk.opentalk;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class OpenTalkPagerAdapter extends FragmentStateAdapter {
//    FragmentStateAdapter <= 프래그먼트를 요소로 가진 어댑터 ( RecyclerView || ViewPager2 같이 사용함)
//    사용방법 자체가 간단함
//    같은 이름의 패키지가 있으면 androidx 가 대부분 맞음
    ArrayList<Fragment> list;

    public OpenTalkPagerAdapter(@NonNull Fragment fragment, ArrayList<Fragment> list) {
        super(fragment); //부모클래스의 생성자
        this.list = list;
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return list.get(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
