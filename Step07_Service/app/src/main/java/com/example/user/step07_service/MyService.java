package com.example.user.step07_service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.widget.Toast;

/*
    [ UI 없이 백그라운드에서 동작할수 있는 Service 객체 ]

    1. Service 추상 클래스를 상속 받아서 만든다.
    2. onBind() 메소드를 오버라이딩한다.
    3. 백그라운드에서 서버와의 통신을 하거나, 음악 재생등의 작업을 할수 있다.
 */
public class MyService extends Service{
    //지금 예제에서는 필요 없지만 Activity 와 바인딩할때 필요하다
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    //서비스가 시작될때 호출되는 메소드
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "서비스가 시작 되었습니다.", Toast.LENGTH_SHORT).show();
        unRegisterAlarm();//알람 해제
        /*
        1. return START_STICKY;
           메모리가 부족해서 운영체제가 서비스를 kill 시킨다음
           메모리가 여유가 생기면 자동으로 서비스객체를 생성해서 다시 서비스를 시작
           시키는 옵션
        2. return START_NOT_STICKY;
           메모리가 부족해서 운영체제가 서비스를 kill 시킨다음 자동으로
           다시 서비스를 시작 시키지말라는 옵션
        */
        return START_NOT_STICKY;
    }
    //서비스가 종료 될때 호출된다.
    @Override
    public void onDestroy() {
        Toast.makeText(this, "서비스가 종료 됩니다.", Toast.LENGTH_SHORT).show();
        //방송수신자 객체를 활성화 시킬 Intent 객체
        Intent i=new Intent();
        //방송의 이름을 정한다.
        i.setAction("com.gura.ALARM_RECEIVER");
        //인텐트 전달자 객체
        PendingIntent pIntent=
                PendingIntent.getBroadcast(this,0,i,0);
        //디바이스를 부팅한 이후의 경과 시간 얻어오기
        long thisTime= SystemClock.elapsedRealtime();
        //첫번째 알람 시간을 지정한다. (1/1000 초 단위)
        long alarmTime=thisTime + 1000*60; //1분후
        //알람 메니져 객체 얻어오기
        AlarmManager aManager=(AlarmManager)
                getSystemService(Context.ALARM_SERVICE);
        //반복적으로 알람이 발생하도록 설정
        aManager.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                alarmTime,  //최초 알람 발생 시점
                1000*60*3,  //반복 주기
                pIntent);   //인텐트 전달자 객체
        super.onDestroy(); //여기가 호출되기 전에 마무리 작업을 한다.
    }

    //알람 해제 하는 메소드
    public void unRegisterAlarm(){
        Intent intent=new Intent();
        intent.setAction("com.gura.ALARM_SERVICE");
        PendingIntent pIntent=PendingIntent.getBroadcast(this, 0, intent, 0);
        AlarmManager aManager=(AlarmManager)
                getSystemService(Context.ALARM_SERVICE);
        aManager.cancel(pIntent);
    }
}








