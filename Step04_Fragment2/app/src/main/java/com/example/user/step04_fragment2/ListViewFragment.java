package com.example.user.step04_fragment2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lee on 2016-04-16.
 */
public class ListViewFragment extends Fragment{
    ListView listView;
    ArrayAdapter<String> adapter;
    List<String> msgList;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //fragment_listview.xml 을 전개해서 View 객체를 만든다.
        View view=inflater.inflate(R.layout.fragment_listview, container);
        //전개한 View 객체에서 ListView 객체의 참조값을 얻어와서 맴버필드에 저장한다.
        listView=(ListView)view.findViewById(R.id.listView);
        //Adapter 객체에 연결할 모델 객체 생성
        msgList=new ArrayList<String>();
        //Adapter 객체 생성하기
        adapter=new ArrayAdapter<String>( getActivity(),
                android.R.layout.simple_list_item_1,
                msgList);
        //ListView 에 아답타 객체 연결하기
        listView.setAdapter(adapter);
        //전개한 View 객체 리턴해주기
        return view;
    }

    //액티비티로 부터 문자열을 전달받을 메소드
    public void appendMessage(String msg){
        //전달받은 문자열을 모델객체에 추가하고
        msgList.add(msg);
        //아답타에 모델이 바뀌었다고 알려서 ListView 를 업데이트 하게 한다.
        adapter.notifyDataSetChanged();
    }
}
