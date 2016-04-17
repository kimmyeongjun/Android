package com.example.user.step04_fragment2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * Created by lee on 2016-04-16.
 */
public class ConsoleFragment extends Fragment{
    EditText consoleEdit;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_console, container);
        consoleEdit=(EditText)view.findViewById(R.id.consoleEdit);
        return view;
    }
    //액티비티가 전달하는 문자열을 받을 메소드
    public void appendMessage(String msg){
        //출력하기
        consoleEdit.append(msg+"\n");
    }
}







