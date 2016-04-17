package com.example.user.step06_viewpagersample;

import java.io.Serializable;

/**
 * Created by lee on 2016-04-16.
 */
public class CountryDto implements Serializable{
    private int imgResId; //국가 이미지의 리소스 아이디
    private String name; //국가의 이름
    public CountryDto(){}

    public CountryDto(int imgResId, String name) {
        this.imgResId = imgResId;
        this.name = name;
    }

    public int getImgResId() {
        return imgResId;
    }

    public void setImgResId(int imgResId) {
        this.imgResId = imgResId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
