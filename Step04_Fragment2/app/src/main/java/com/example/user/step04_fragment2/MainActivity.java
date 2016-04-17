package com.example.user.step04_fragment2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity
                implements InputFragment.InputFragmentListener{
    //필요한 맴버필드 정의하기
    ConsoleFragment cFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ConsoleFragment 객체의 참조값을 얻어와서 맴버필드에 저장한다.
        FragmentManager fm=getSupportFragmentManager();
        cFragment=(ConsoleFragment)fm.findFragmentById(R.id.consoleFragment);
    }
    //InputFragment 에서 호출할 메소드
    @Override
    public void sendMessage(String msg) {
        //전달받은 문자열을 ConsoleFragment 에 전달한다.
        cFragment.appendMessage(msg);
    }
    //액티비티 이동 버튼을 눌렀을때 호출되는 메소드
    public void move(View v){
        startActivity(new Intent(this, SubActivity.class));
    }
}






