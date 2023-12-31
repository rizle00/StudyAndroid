package com.example.project01_kmjtalk.opentalk;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project01_kmjtalk.R;
import com.example.project01_kmjtalk.chat.ChatFragment;
import com.example.project01_kmjtalk.databinding.FragmentOpenTalkMainBinding;
import com.example.project01_kmjtalk.friend.FriendFragment;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;
import java.util.List;

public class OpenTalkMainFragment extends Fragment {

    FragmentOpenTalkMainBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentOpenTalkMainBinding.inflate(inflater, container, false);
        OpenTalkPagerAdapter adapter = new OpenTalkPagerAdapter(this, getFragmentList());
        binding.pager2.setAdapter(adapter);


        binding.chipGroup.setOnCheckedChangeListener(new ChipGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull ChipGroup group, int checkedId) {
                if(checkedId == R.id.chip_1){
                    binding.pager2.setCurrentItem(0,true);
                } else  if(checkedId == R.id.chip_2){
                    binding.pager2.setCurrentItem(1,true);
                }  else  if(checkedId == R.id.chip_3){
                    binding.pager2.setCurrentItem(2,true);
                }  else  if(checkedId == R.id.chip_4){
                    binding.pager2.setCurrentItem(3,true);
                }
            }
            });


// 페이지가 바뀌면 칩이 셀렉트 되고 칩이 셀렉트 되면 페이지가 바뀌게.. 상호 관계를 만들어줌

//        pager의 스크롤이 변하면서 선택되어있는 아이템 변경시 (페이지) 실행되는 메소드(인터페이스)
        binding.pager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                if(position==0){
                    binding.chipGroup.check(R.id.chip_1);
                } else  if(position==1){
                    binding.chipGroup.check(R.id.chip_2);
                }  else  if(position==2){
                    binding.chipGroup.check(R.id.chip_3);
                }  else  if(position==3){
                    binding.chipGroup.check(R.id.chip_4);
                }

            }
        });


        return binding.getRoot();
    }

//    프레그먼트 리스트로 관리
    ArrayList<Fragment> getFragmentList(){
        ArrayList<Fragment> list = new ArrayList<>();
        list.add(new OpenTalkSubFragment());
        list.add(new OpenTalkSubFragment());
        list.add(new OpenTalkSubFragment());
        list.add(new OpenTalkSubFragment());
        return list;
    }
}