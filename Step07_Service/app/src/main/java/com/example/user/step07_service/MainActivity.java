package com.example.user.step07_service;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //서비스를 시작 시키기 위한 Intent 객체
        Intent intent=new Intent(this, MyService.class);
        //서비스 시작 시키기
        startService(intent);
    }
}
