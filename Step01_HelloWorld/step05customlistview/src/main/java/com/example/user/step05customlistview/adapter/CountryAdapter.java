package com.example.user.step05customlistview.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.step05customlistview.R;
import com.example.user.step05customlistview.dto.CountryDto;

import java.util.List;

/**
 * Created by lee on 2016-04-09.
 */

/*
    Custom Adapter 만들기

    - BaseAdapter 추상 클래스를 상속 받아서 만든다.
 */
public class CountryAdapter extends BaseAdapter{
    //필요한 맴버필드 정의하기
    Context context;
    int layoutRes;
    List<CountryDto> list;
    LayoutInflater inflater;


    //생성자
    public CountryAdapter(Context context, int layoutRes, List<CountryDto> list){
        this.context=context;
        this.layoutRes=layoutRes;
        this.list=list;
        // xml 문서를 전개해서 View 객체를 만들어주는 레이아웃 전개자 객체
        inflater=LayoutInflater.from(context);
    }
    //모델의 전체 갯수리턴
    @Override
    public int getCount() {
        return list.size();
    }
    //position 에 해당하는 인덱스의 모델 리턴하기
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }
    //position 에 해당하는 모델의 아이디 리턴 (없으면 position 을 id 로 사용)
    @Override
    public long getItemId(int position) {
        return position;
    }
    //position 에 해당하는 셀 View 를 리턴해주는 메소드
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //로그 찍기
        Log.d("getView()", "position:"+position);
        //처음에는 convertView 에 null 이 전달된다.
        if(convertView==null){
            Log.d("getView()", "convertView == null");
            //레이아웃 전개자 객체를 이용해서 셀 View 를 만든다.
            convertView=inflater.inflate(layoutRes, parent, false);
        }
        //필요한 객체의 참조값 얻어오기
        ImageView imageView=(ImageView)convertView.findViewById(R.id.imageView);
        TextView textView=(TextView)convertView.findViewById(R.id.textView);
        //position 에 해당하는 데이터를 모델에서 불러온다.
        CountryDto dto=list.get(position);
        //셀 View 에 데이터 출력
        imageView.setImageResource(dto.getImageResId());
        textView.setText(dto.getName());
        //구성된 셀 View 를 리턴해준다.
        return convertView;
    }
}









