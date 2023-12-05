package com.example.and10_fragmentadapter.melon;

public class MelonDTO {

    private int imgRes_melon, rank;
    private String title, singer;

    public int getImgRes_melon() {
        return imgRes_melon;
    }

    public void setImgRes_melon(int imgRes_melon) {
        this.imgRes_melon = imgRes_melon;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public MelonDTO(int imgRes_melon, int rank, String title, String singer) {
        this.imgRes_melon = imgRes_melon;
        this.rank = rank;
        this.title = title;
        this.singer = singer;
    }
}
