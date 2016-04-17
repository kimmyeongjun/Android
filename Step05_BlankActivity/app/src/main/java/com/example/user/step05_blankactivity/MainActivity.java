package com.example.user.step05_blankactivity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //res/menu/menu_main.xml 문서를 전개해서 옵션 메뉴 구성하기
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    //메뉴 아이템을 클릭했을때 호출되는 메소드
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //클릭한 아이템 아이디 얻어오기
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }else if( id == R.id.one ){
            Toast.makeText(this, "one !", Toast.LENGTH_SHORT).show();
        }else if( id == R.id.two ){
            Toast.makeText(this, "two !", Toast.LENGTH_SHORT).show();
        }else if( id == R.id.three){
            Toast.makeText(this, "three !", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }
}
