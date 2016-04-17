package com.example.user.step07_servicebind;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
                                implements View.OnClickListener,
                                NotiService.NotiServiceListener{
    //서비스에 바인딩 되었는지 여부
    boolean isBinded=false;
    //서비스의 참조값을 담을 맴버필드
    NotiService service;
    //필요한 맴버필드
    EditText inputMsg;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView)findViewById(R.id.textView);
        inputMsg=(EditText)findViewById(R.id.inputMsg);
        //버튼의 참조값 얻어와서 리스너 등록하기
        Button startBtn=(Button)findViewById(R.id.startBtn);
        Button endBtn=(Button)findViewById(R.id.endBtn);
        Button sendBtn=(Button)findViewById(R.id.sendBtn);
        startBtn.setOnClickListener(this);
        endBtn.setOnClickListener(this);
        sendBtn.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        //NotiService 객체에 바인딩 요청
        Intent intent=new Intent(this, NotiService.class);
        bindService(intent, conn, Context.BIND_AUTO_CREATE);
    }
    //서비스 연결객체
    ServiceConnection conn=new ServiceConnection() {
        //서비스와 바인딩 되었을때 호출되는 메소드
        @Override
        public void onServiceConnected(ComponentName name, IBinder binder) {
            isBinded=true; //바인딩 여부를 true 로 바꿔준다.
            //원래 Type 으로 캐스팅
            NotiService.LocalBinder localBinder=(NotiService.LocalBinder)binder;
            //서비스의 참조값을 얻어와서 맴버필드에 저장한다.
            service=localBinder.getService();
            //바인더 객체에 액티비티의 참조값을 전달한다.
            localBinder.setActivity(MainActivity.this);
            Toast.makeText(MainActivity.this, "서비스에 바인딩 되었습니다.",
                    Toast.LENGTH_SHORT).show();
        }
        //서비스와 바인딩 해제 되었을때 호출되는 메소드
        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBinded=false;
            service=null;
        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        if(isBinded){//서비스에 연결되어 있다면
            //바인딩 해제
            unbindService(conn);
            isBinded=false;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.startBtn:
                //서비스 시작 시키기
                Intent i=new Intent(this, NotiService.class);
                startService(i);
                break;
            case R.id.endBtn:
                //서비스 종료 시키기
                Intent i2=new Intent(this, NotiService.class);
                stopService(i2);
                break;
            case R.id.sendBtn:
                if(isBinded){//서비스와 연결되어 있다면
                    //입력한 문자열을 서비스에 넣어준다.
                    String msg=inputMsg.getText().toString();
                    service.addMsg(msg);
                }else{
                    Toast.makeText(this,"서비스와 바인딩되지 않았습니다.",
                            Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
    //서비스가 특정 시점에서 호출할 메소드
    @Override
    public void fromService(String msg) {
        //서비스에서 전달된 문자열을 UI 에 출력하기
        textView.setText(msg);
    }
}




