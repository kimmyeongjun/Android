package com.example.user.step05customlistview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.step05customlistview.dto.CountryDto;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //전달된 인텐트 객체의 참조값을 얻어온다.
        Intent intent=getIntent();
        //Intent 객체에 담긴 CountryDto 객체를 얻어온다.
        CountryDto dto=(CountryDto)intent.getSerializableExtra("dto");
        //activity_detail.xml 로 전개된 View 의 참조값 얻어오기
        ImageView detailImage=(ImageView)findViewById(R.id.detailImageView);
        TextView detailName=(TextView)findViewById(R.id.detailName);
        TextView snippet=(TextView)findViewById(R.id.snippet);
        //CountryDto 에 담긴 정보를 출력하기
        detailImage.setImageResource(dto.getImageResId());
        detailName.setText(dto.getName());
        snippet.setText(" 어쩌구.. 저쩌구.. 자세한 정보...");
    }
    //확인 버튼을 눌렀을때 호출되는 메소드
    public void end(View v){
        //액티비티 종료
        finish();
    }
}







