package com.example.user.step04_fragment2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by lee on 2016-04-16.
 */
public class InputFragment extends Fragment implements View.OnClickListener{
    //필요한 맴버 필드 정의하기
    EditText inputText;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_input, container);

        inputText=(EditText)view.findViewById(R.id.inputText);
        //Button 참조값
        Button sendBtn=(Button)view.findViewById(R.id.sendBtn);
        //Button 리스너 등록
        sendBtn.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        //입력한 문자열
        String msg=inputText.getText().toString();
        //InputFragment 를 제어하고 있는 Activity 에 전달한다.
        InputFragmentListener activity=(InputFragmentListener)getActivity();
        activity.sendMessage(msg);
    }
    //InputFragment 를 사용하는 액티비티가 구현할 리스너 인터페이스 정의하기
    public interface InputFragmentListener{
        public void sendMessage(String msg);
    }
}









