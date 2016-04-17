package com.example.user.step06intent;

import android.app.SearchManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity
                                implements View.OnClickListener{
    //필요한 맴버필드 정의
    EditText inputText, inputKeyword;
    ImageView imageView;
    static final int SELECT_PHOTO=0;
    static final int CAPTURE_PHOTO=1;
    static final int CAPTURE_PHOTO2=2;
    Uri photoUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputText=(EditText)findViewById(R.id.inputText);
        inputKeyword=(EditText)findViewById(R.id.inputKeyword);
        imageView=(ImageView)findViewById(R.id.imageView);
        //전화 걸기 버튼
        Button callBtn=(Button)findViewById(R.id.callBtn);
        callBtn.setOnClickListener(this); //리스너 등록
        //검색 버튼
        Button searchBtn=(Button)findViewById(R.id.searchBtn);
        searchBtn.setOnClickListener(this);

        //갤러리 버튼 리스너 등록
        Button galleryBtn=(Button)findViewById(R.id.galleryBtn);
        galleryBtn.setOnClickListener(this);

        //사진 찍기 버튼 리스너 등록
        Button captureBtn=(Button)findViewById(R.id.captureBtn);
        captureBtn.setOnClickListener(this);

        //사진찍기 버튼2 리스너 등록
        Button captureBtn2=(Button)findViewById(R.id.captureBtn2);
        captureBtn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.callBtn){ //전화 걸기 버튼을 눌렀을때
            //입력한 전화번호를 읽어온다.
            String phoneNumber=inputText.getText().toString();
            //Intent 객체를 생성해서
            Intent intent=new Intent();
            //전화를 걸겠다는 의도를 표시하고
            intent.setAction(Intent.ACTION_DIAL);
            //인텐트에 전화번호 정보를 담고
            Uri uri=Uri.parse("tel:"+phoneNumber);
            intent.setData(uri);
            //액티비티를 실행시킨다.
            startActivity(intent);
        }else if(v.getId()==R.id.searchBtn){
            String keyword=inputKeyword.getText().toString();
            Intent searchIntent=new Intent();
            searchIntent.setAction(Intent.ACTION_WEB_SEARCH);
            searchIntent.putExtra(SearchManager.QUERY, keyword);
            startActivity(searchIntent);
        }else if(v.getId()==R.id.galleryBtn){
            //겔러리에서 사진을 가지고 올수 있도록 Intent 객체를 작성
            Intent intent=new Intent();
            intent.setAction(Intent.ACTION_PICK);
            intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
            //결과값을 받아올수 있도록 액티비티 시작 시키기
            startActivityForResult(intent, SELECT_PHOTO);
        }else if(v.getId()==R.id.captureBtn){
            Intent intent=new Intent();
            intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, CAPTURE_PHOTO);
        }else if(v.getId()==R.id.captureBtn2){
            Intent captureIntent2=new Intent();
            captureIntent2.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
            File photoFile=null;
            try{
                String timeStamp=new SimpleDateFormat("yyyyMMdd_HHmmss")
                        .format(new Date());
                String imageFileName="JPEG_"+timeStamp+"_";
                File storageDir= Environment
                        .getExternalStoragePublicDirectory
                                (Environment.DIRECTORY_PICTURES);
                photoFile=File.createTempFile(imageFileName, ".jpg", storageDir);
            }catch(IOException e){
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
            if(photoFile!=null){
                //찍은 사진 이미지를 저장할 경로의 uri 객체
                photoUri=Uri.fromFile(photoFile);
                //인텐트에 uri 객체도 같이 전달한다.
                captureIntent2.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
                startActivityForResult(captureIntent2, CAPTURE_PHOTO2);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode != RESULT_OK){
            Toast.makeText(this, "작업 실패!", Toast.LENGTH_SHORT).show();
            return; //메소드 종료
        }

        switch (requestCode){
            case SELECT_PHOTO: //사진 선택에 대한 결과 일때
                //선택한 이미지의 Uri 정보를 얻어온다.
                Uri imageUri=data.getData();
                //이미지 뷰에 출력하기
                imageView.setImageURI(imageUri);
                break;
            case CAPTURE_PHOTO:
                //찍은 사진의 섬네일 이미지 정보가 intent 객체에 들어있다.
                Bundle extra=data.getExtras();
                Bitmap image=(Bitmap)extra.get("data");
                //이미지 뷰에 출력하기
                imageView.setImageBitmap(image);
                break;
            case CAPTURE_PHOTO2:
                // photoUri 에 있는 사진을 출력하기
                imageView.setImageURI(photoUri);
                break;
        }
    }
}






