package com.example.user.step03_notification;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Noti2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noti);
        //TextView 의 참조값 얻어오기
        TextView textView=(TextView)findViewById(R.id.textView);
        //전달된 인텐트 객체의 참조값 얻어오기
        Intent intent=getIntent();
        //인텐트 객체에 담긴 내용 읽어와서
        String msg=intent.getStringExtra("msg");
        //출력하기
        textView.setText(msg);

        //알림 해제
        NotificationManager notiManager=
                (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        notiManager.cancel(AppConstants.NOTI_TYPE_2);
    }
}








