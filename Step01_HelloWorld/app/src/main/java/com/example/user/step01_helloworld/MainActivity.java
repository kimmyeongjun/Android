package com.example.user.step01_helloworld;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // res/layout/activity_main.xml 문서를 전개해서 화면구성하기
        setContentView(R.layout.activity_main);
    }

    //버튼을 눌렀을때 호출되는 메소드
    public void buttonClicked(View v){
        Toast.makeText(this, "버튼을 눌렀네요?", Toast.LENGTH_SHORT).show();
    }
}











