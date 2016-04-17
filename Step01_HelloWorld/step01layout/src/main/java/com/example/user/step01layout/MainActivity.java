package com.example.user.step01layout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear07);
    }
    public void button1Clicked(View v){
        Toast.makeText(this,"버튼1", Toast.LENGTH_SHORT).show();
    }
    public void button2Clicked(View v){
        Toast.makeText(this,"버튼2", Toast.LENGTH_SHORT).show();
    }
    public void button3Clicked(View v){
        Toast.makeText(this,"버튼3", Toast.LENGTH_SHORT).show();
    }
    public void button4Clicked(View v){
        Toast.makeText(this,"버튼4", Toast.LENGTH_SHORT).show();
    }
}
