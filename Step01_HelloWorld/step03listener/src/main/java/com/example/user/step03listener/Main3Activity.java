package com.example.user.step03listener;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main3Activity extends AppCompatActivity
                            implements View.OnClickListener{
    EditText inputMsg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        inputMsg=(EditText)findViewById(R.id.inputMsg);
        //버튼 3개의 참조값 얻어오기
        Button saveBtn=(Button)findViewById(R.id.saveBtn);
        Button updateBtn=(Button)findViewById(R.id.updateBtn);
        Button deleteBtn=(Button)findViewById(R.id.deleteBtn);
        //버튼에 리스너 등록하기
        saveBtn.setOnClickListener(this);
        updateBtn.setOnClickListener(this);
        deleteBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String str="";
        switch (v.getId()){
            case R.id.saveBtn:
                str="저장버튼";
                break;
            case R.id.updateBtn:
                str="수정버튼";
                break;
            case R.id.deleteBtn:
                str="삭제버튼";
                break;
        }
        //알림 다이얼로그 띄우기
        new AlertDialog.Builder(this)
                .setTitle("알림")
                .setMessage(str)
                .setNeutralButton("확인", null)
                .create()
                .show();
        /*
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("알림");
        builder.setMessage(str);
        builder.setNeutralButton("확인", null);
        AlertDialog dialog=builder.create();
        dialog.show();
        */
    }
}







