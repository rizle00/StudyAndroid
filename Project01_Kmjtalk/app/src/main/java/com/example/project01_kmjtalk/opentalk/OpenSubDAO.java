package com.example.project01_kmjtalk.opentalk;


import com.example.project01_kmjtalk.R;
import com.example.project01_kmjtalk.opentalk.OpenSubDTOS;

import java.util.ArrayList;

public class OpenSubDAO {

    ArrayList<OpenSubDTOS.OpenSub1DTO> getOpenSub1List(){
        ArrayList<OpenSubDTOS.OpenSub1DTO> list = new ArrayList<>();
        list.add(new OpenSubDTOS().new OpenSub1DTO(R.drawable.bg1, 1500, "[광주광역시 정보] 광주전남 정보",  "사진 3장을 보냈습니다", "오전 11:48"));
        list.add(new OpenSubDTOS().new OpenSub1DTO(R.drawable.bg2, 55, "청바지",  "티츄 하실분", "오후 12:01"));
        list.add(new OpenSubDTOS().new OpenSub1DTO(R.drawable.bg3, 125, "오르카 라이딩",  "날씨가 좋다", "오전 11:07"));
        list.add(new OpenSubDTOS().new OpenSub1DTO(R.drawable.bg4, 236, "커피정보..",  "커피 마싰다", "12월10일"));
        return list;
    }

    ArrayList<OpenSubDTOS.OpenSub2DTO> getOpenSub2List(){
        ArrayList<OpenSubDTOS.OpenSub2DTO> list = new ArrayList<>();
        list.add(new OpenSubDTOS().new OpenSub2DTO(R.drawable.bg5, 130, "간헐적단식",  "30분전", new String[]{"#어쩌고","#저쩌고","#그리고","#....."}));
        list.add(new OpenSubDTOS().new OpenSub2DTO(R.drawable.bg6, 317, "헬스 모임",  "방금대화", new String[]{"#사레레","#3대500","#헬스장","#....."}));
        list.add(new OpenSubDTOS().new OpenSub2DTO(R.drawable.bg7, 12, "광주 크로스핏 모임",  "12월5일", new String[]{"#버핏","#힘들어","#죽어","#....."}));
        list.add(new OpenSubDTOS().new OpenSub2DTO(R.drawable.bg8, 1700, "다이어트는 영원한..",  "방금 대화", new String[]{"#식단","#운동","#식당","#....."}));
        return list;
    }
    ArrayList<OpenSubDTOS.OpenSub3DTO> getOpenSub3List(){
        ArrayList<OpenSubDTOS.OpenSub3DTO> list = new ArrayList<>();
        list.add(new OpenSubDTOS().new OpenSub3DTO(R.drawable.profile4, 150, "광주 와인모임",  "사진 3장을 보냈습니다"));
        list.add(new OpenSubDTOS().new OpenSub3DTO(R.drawable.profile5, 255, "맛집 찾아",  "티츄 하실분"));
        list.add(new OpenSubDTOS().new OpenSub3DTO(R.drawable.profile6, 25, "광주 라이딩",  "날씨가 좋다"));
        list.add(new OpenSubDTOS().new OpenSub3DTO(R.drawable.profile7, 36, "커피정보..",  "파나마 게이샤..."));
        return list;
    }
}
