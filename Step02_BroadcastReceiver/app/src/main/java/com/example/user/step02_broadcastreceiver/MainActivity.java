package com.example.user.step02_broadcastreceiver;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
                implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button broadcastBtn=(Button)findViewById(R.id.broadcastBtn);
        broadcastBtn.setOnClickListener(this);

        Button broadcastBtn2=(Button)findViewById(R.id.broadcastBtn2);
        broadcastBtn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.broadcastBtn: //커스텀 방송하기 버튼을 눌렀을때
                Intent intent=new Intent();
                intent.setAction("com.gura.MERONG");
                sendBroadcast(intent);
                break;
            case R.id.broadcastBtn2:// 10초후에 방송하기 버튼을 눌렀을때
                //10초 이후에 handler 객체에 빈 메세지 보내기
                handler.sendEmptyMessageDelayed(0, 10000);
                break;
        }
    }

    //맴버필드로 핸들러 객체 정의하기
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            //handler 객체에 메세지가 도착하면 실행되는 메소드
            Intent intent=new Intent();
            intent.setAction("com.gura.MERONG");
            sendBroadcast(intent);
        }
    };
}












