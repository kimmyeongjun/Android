package com.example.user.step03listener;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText inputMsg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //EditText 객체의 참조값을 View Type 으로 얻어온다.
        View v = findViewById(R.id.inputMsg);
        //원래 Type 으로 casting
        inputMsg=(EditText)v;
    }
    //전송버튼을 눌렀을때 호출되는 메소드
    public void send(View v){
        // v 에는 눌러진 버튼의 참조값이 들어있다.
        //입력한 문자열 얻어오기
        String msg=inputMsg.getText().toString();
        //출력
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
