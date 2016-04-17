package com.example.user.step02_broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by lee on 2016-04-14.
 */
public class MyReceiver extends BroadcastReceiver{//1. BroadcastReceiver 추상클래스 상속

    //2. onReceive() 메소드 오버라이딩
    @Override
    public void onReceive(Context context, Intent intent) {
        //3. 방송이 수신되면 실행순서가 여기로 들어온다.
        Toast.makeText(context, "MERONG 방송이 수신 되었네?", Toast.LENGTH_SHORT).show();
        //4. 방송 수신자 객체는 AndroidManifest.xml 에 등록이 되어 있어야 동작한다.

    }
}









