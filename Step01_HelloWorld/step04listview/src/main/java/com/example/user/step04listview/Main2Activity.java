package com.example.user.step04listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity
                            implements View.OnClickListener{
    ListView listView;
    ArrayAdapter<String> adapter; //아답타
    List<String> list; //모델
    EditText inputMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        listView=(ListView)findViewById(R.id.listView);
        inputMsg=(EditText)findViewById(R.id.inputMsg);
        //Adpater 에 연결할 Model 객체 생성
        list=new ArrayList<>();
        //ListView 에 연결할 Adapter 객체 생성
        adapter=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_single_choice,
                list);
        //ListView 에 아답타 연결하기
        listView.setAdapter(adapter);

        //Button 의 참조값 얻어와서 리스너 등록
        Button addBtn=(Button)findViewById(R.id.addBtn);
        addBtn.setOnClickListener(this);

        Button deleteBtn=(Button)findViewById(R.id.deleteBtn);
        deleteBtn.setOnClickListener(this);
    }
    //버튼을 눌렀을때 호출되는 메소드
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.addBtn: //추가 버튼을 눌렀을때
                //입력한 문자열 읽어오기
                String msg=inputMsg.getText().toString();
                //모델에 추가
                list.add(msg);
                //모델의 데이터가 바뀌었다고 아답타에 알린다.
                adapter.notifyDataSetChanged();//결과적으로 ListView 가 업데이트된다.
                //셀의 마지막 인덱스를 읽어온다.
                int lastPosition=adapter.getCount()-1;
                //부드럽게 해당 위치로 스크롤한다.
                listView.smoothScrollToPosition(lastPosition);
                //입력창 초기화
                inputMsg.setText("");
                break;
            case R.id.deleteBtn: //삭제 버튼을 눌렀을때
                //체크된 인덱스 얻어오기
                int checkedIndex=listView.getCheckedItemPosition();
                if(checkedIndex==-1){
                    Toast.makeText(this, "삭제할 셀을 선택하세요!",Toast.LENGTH_SHORT).show();
                    return;//메소드 종료
                }
                //모델에서 해당 데이터를 삭제
                list.remove(checkedIndex);
                //아답타에 모델의 데이타가 바뀌었다고 알린다.
                adapter.notifyDataSetChanged();
                //체크된 셀 초기화
                listView.clearChoices();
                break;
        }
    }
}








