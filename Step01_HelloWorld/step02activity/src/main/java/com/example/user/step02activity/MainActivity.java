package com.example.user.step02activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //Activity 이동 버튼을 눌렀을때 호출되는 메소드
    public void move(View v){
        Intent intent=new Intent(this, DetailActivity.class);

        startActivity(intent);
    }

}
