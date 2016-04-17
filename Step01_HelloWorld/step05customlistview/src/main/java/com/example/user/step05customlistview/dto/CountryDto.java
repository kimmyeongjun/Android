package com.example.user.step05customlistview.dto;

import java.io.Serializable;

/**
 * Created by lee on 2016-04-09.
 */
public class CountryDto implements Serializable{ // 인텐트에 담을수 있도록

    private int imageResId; //이미지 리소스 아이디
    private String name; //나라의 이름
    public CountryDto(){}

    public CountryDto(int imageResId, String name) {
        this.imageResId = imageResId;
        this.name = name;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
