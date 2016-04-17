package com.example.user.step07_service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/*
    알람 방송을 받을 방송 수신자 객체
 */
public class AlarmReceiver extends BroadcastReceiver{
    //방송을 받으면 이메소드가 호출된다.
    @Override
    public void onReceive(Context context, Intent intent) {
        //서비스를 시작 시킨다.
        Intent i=new Intent(context, MyService.class);
        context.startService(i);
    }
}
