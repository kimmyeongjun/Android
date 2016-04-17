package com.example.user.step03listener;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity
                                implements View.OnClickListener{
    //참조값을 담을 맴버필드 선언
    EditText inputMsg;
    Button sendBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        // activity_main2.xml 로 전개된 View 중에서 id 가 inputMsg 인 View 의
        // 참조값을 얻어와서 맴버필드에 저장하기
        inputMsg=(EditText)findViewById(R.id.inputMsg);
        sendBtn=(Button)findViewById(R.id.sendBtn);
        //버튼에 리스너 등록하기
        sendBtn.setOnClickListener(this);

        //버튼의 참조값 얻어오기
        Button sendBtn2=(Button)findViewById(R.id.sendBtn2);
        sendBtn2.setOnClickListener(listener);
    }
    //리스너를 맴버필드로 정의하기
    View.OnClickListener listener=new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            //입력한 문자열 읽어오기
            String msg=inputMsg.getText().toString();
            //토스트 메세지 띄우기
            Toast.makeText(Main2Activity.this, msg, Toast.LENGTH_SHORT).show();
            //입력창 초기화
            inputMsg.setText("");
        }
    };

    @Override
    public void onClick(View v) {
        //입력한 문자열 읽어오기
        String msg=inputMsg.getText().toString();
        //토스트 메세지 띄우기
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        //입력창 초기화
        inputMsg.setText("");
    }
}








