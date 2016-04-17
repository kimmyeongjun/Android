package com.example.user.step04_fragment2;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SubActivity extends AppCompatActivity
                implements InputFragment.InputFragmentListener{
    ListViewFragment lFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        FragmentManager fm=getSupportFragmentManager();
        lFragment=(ListViewFragment)fm.findFragmentById(R.id.listViewFragment);
    }

    @Override
    public void sendMessage(String msg) {
        lFragment.appendMessage(msg);
    }
}
