package com.example.user.step07_servicebind;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.v4.app.NotificationCompat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NotiService extends Service {
    //알림을 띄울 메세지 목록
    List<String> msgList;
    //맴버필드로 바인더 객체를 가지고 있는다.
    IBinder binder=new LocalBinder();
    //액티비티의 참조값을 담을 맴버필드
    NotiServiceListener activity;

    @Override
    public void onCreate() {
        super.onCreate();
        //메세지 목록 객체를 생성한다.
        msgList=new ArrayList<>();
    }
    //액티비티에서 연결 요청이 오면 호출되는 메소드
    @Override
    public IBinder onBind(Intent intent) {
        //맴버필드에 있는 IBinder 객체를 리턴해준다.
        return binder;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //핸들러에 메세지 보내기
        handler.sendEmptyMessage(0);
        return START_NOT_STICKY;
    }
    //주기적으로 Notification 을 띄워주는 작업을 할 Handler 객체
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            //알림 띄우는 메소드 호출!
            if(msgList.size()>0){
                makeNotification();
            }
            //10초 이후에 다시 핸들러에 빈 메세지를 보낸다.
            handler.sendEmptyMessageDelayed(0, 1000 * 10);
        }
    };
    //알림을 띄우는 메소드
    public void makeNotification(){
        Random ran=new Random();
        //배열의 방번호 범위안에서 한개의 랜덤한 정수를 얻어낸다.
        int ranNum=ran.nextInt(msgList.size());
        //알림을 띄울 메세지
        String msg=msgList.get(ranNum);
        //알림을 클릭했을때 시작 시킬 Activity 정보를 가지고 있는 Intent 객체 생성
        Intent intent=new Intent(this, MainActivity.class);
        //새로운 Task 에서 액티비티를 실행할수 있도록 플레그 설정
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        //인텐트 전달자 객체에 인텐트 객체를 담는다.
        PendingIntent pIntent=
                PendingIntent.getActivity(this, 0, intent,0);

        //Notification 객체를 생성한다.
        Notification noti=new NotificationCompat.Builder(this)
                .setContentIntent(pIntent)  //인텐트 전달자 객체
                .setSmallIcon(android.R.drawable.ic_dialog_info) //간단 아이콘
                .setContentTitle("서비스에서 보냄") //알림의 제목
                .setContentText(msg) //알림 내용
                .setTicker(msg)  //상단에 떳다가 사라지는 미니 메세지
                .setDefaults(Notification.DEFAULT_SOUND
                        | Notification.DEFAULT_VIBRATE) //알림의 소리와 진동을 디폴트 설정으로
                .setAutoCancel(true) //알림을 클릭했을때 자동으로 알림이 취소 되는 설정
                .build();
        //알림 메니져 객체의 참조값을 얻어와서
        NotificationManager notiManager=(NotificationManager)
                getSystemService(Context.NOTIFICATION_SERVICE);
        //알림을 띄운다.
        notiManager.notify(999, noti);
        //알림에 띄운 메세지를 액티비티에도 전달한다.
        if(activity != null){
            activity.fromService(msg);
        }
    }
    //액티비티에서 호출할 예정인 메세지를 추가하는 메소드
    public void addMsg(String msg){
        msgList.add(msg);
    }

    @Override
    public void onDestroy() {
        //핸들러 메세지 제거
        handler.removeMessages(0);
        super.onDestroy();
    }
    //액티비티와 바인딩이 해제 되면 호출되는 메소드
    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    //Binder 클래스를 상속 받아서 LocalBinder 클래스를 정의한다.
    public class LocalBinder extends Binder{
        //서비스의 참조값을 리턴해주는 메소드
        public NotiService getService(){
            return NotiService.this;
        }
        //액티비티의 참조값을 전달 받을 메소드 (액티비티에서 호출할 예정)
        public void setActivity(NotiServiceListener activity){
            NotiService.this.activity=activity;
        }
    }

    //서비스에 바인딩할 액티비티가 구현할 인터페이스
    public interface NotiServiceListener{
        public void fromService(String msg);
    }
}











