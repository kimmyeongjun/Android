package com.example.user.step05customlistview;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.user.step05customlistview.adapter.CountryAdapter;
import com.example.user.step05customlistview.dto.CountryDto;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
                    implements AdapterView.OnItemClickListener{
    //필요한 맴버필드 정의하기
    ListView listView;
    List<CountryDto> list;
    CountryAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView)findViewById(R.id.listView);
        list=new ArrayList<>();
        //Model 에 Sample 데이터 넣어주기
        list.add(new CountryDto(R.drawable.austria, "오스트리아"));
        list.add(new CountryDto(R.drawable.belgium, "벨기에"));
        list.add(new CountryDto(R.drawable.brazil, "브라질"));
        list.add(new CountryDto(R.drawable.france, "프랑스"));
        list.add(new CountryDto(R.drawable.germany, "독일"));
        list.add(new CountryDto(R.drawable.greece, "그리스"));
        list.add(new CountryDto(R.drawable.israel, "이스라엘"));
        list.add(new CountryDto(R.drawable.italy, "이탈리아"));
        list.add(new CountryDto(R.drawable.japan, "일본"));
        list.add(new CountryDto(R.drawable.korea, "대한민국"));
        list.add(new CountryDto(R.drawable.poland, "폴란드"));
        list.add(new CountryDto(R.drawable.spain, "스페인"));
        list.add(new CountryDto(R.drawable.usa, "미국"));

        //Adapter
        adapter=new CountryAdapter(this, R.layout.listview_cell, list);
        //ListView 에 Adapter 연결
        listView.setAdapter(adapter);
        //ListView 에 아이템 클릭 리스너 등록
        listView.setOnItemClickListener(this);
    }
    //ListView 의 셀을 클릭하면 호출되는 메소드
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //클릭한 셀의 정보
        CountryDto dto=list.get(position);

        //DetailActivity 로 이동한다.
        Intent intent=new Intent(this, DetailActivity.class);
        //Intent 객체에 CountryDto 객체를 담는다.
        intent.putExtra("dto", dto);
        startActivity(intent);

        //액티비티 전환 애니메이션 효과 바꾸기
        overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_top);
    }
    //back 버튼을 눌렀을때 호출되는 메소드
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("알림")
                .setMessage("종료 하시겠습니까?")
                .setPositiveButton("네", listener)
                .setNegativeButton("아니요", listener)
                .create()
                .show();
    }
    //맴버필드로 알림 다이얼로그의 리스너 정의하기
    DialogInterface.OnClickListener listener=new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch (which){
                case AlertDialog.BUTTON_POSITIVE:
                    finish();//액티비티 종료하기
                    break;
                case AlertDialog.BUTTON_NEGATIVE:
                    //아무것도 안하기
                    break;
            }
        }
    };
}











