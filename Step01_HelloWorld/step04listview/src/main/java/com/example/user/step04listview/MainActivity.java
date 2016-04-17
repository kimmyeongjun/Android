package com.example.user.step04listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
                            implements AdapterView.OnItemClickListener{
    ListView listView;
    TextView infoText;
    List<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //TextView 의 참조값 얻어와서 맴버필드에 저장
        infoText=(TextView)findViewById(R.id.infoText);

        //Sample Data (Model)
        list=new ArrayList<>();
        list.add("김구라");
        list.add("해골");
        list.add("원숭이");
        list.add("주뎅이");
        list.add("덩어리");
        list.add("돼지");
        list.add("개다리");
        list.add("준발이");
        list.add("김구라");
        list.add("해골");
        list.add("원숭이");
        list.add("주뎅이");
        list.add("덩어리");
        list.add("돼지");
        list.add("개다리");
        list.add("준발이");
        list.add("김구라");
        list.add("해골");
        list.add("원숭이");
        list.add("주뎅이");
        list.add("덩어리");
        list.add("돼지");
        list.add("개다리");
        list.add("준발이");
        list.add("김구라");
        list.add("해골");
        list.add("원숭이");
        list.add("주뎅이");
        list.add("덩어리");
        list.add("돼지");
        list.add("개다리");
        list.add("준발이");

        //ListView 의 참조값 얻어와서 맴버필드에 저장하기
        listView=(ListView)findViewById(R.id.listView);
        //ListView 에 연결할 Adapter 객체의 참조값 얻어오기
        ArrayAdapter<String> adapter=
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1,
                        list);
        //ListView 에 Adapter 연결하기
        listView.setAdapter(adapter);
        //ItemClick 리스너 등록하기
        listView.setOnItemClickListener(this);
    }
    // ListView 의 셀을 클릭했을때 호출되는 메소드
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // position => 클릭한 셀의 인덱스 값
        Toast.makeText(this, position+" 번 인덱스!", Toast.LENGTH_SHORT).show();
        //클릭한 셀의 data
        String name=list.get(position);
        //TextView 에 출력
        infoText.setText("INFO : "+name);
    }
}









