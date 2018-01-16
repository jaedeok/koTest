package com.koreanair.samplemobilequiz;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Quiz4LaunchAppActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView image_1;
    ImageView image_2;
    ImageView image_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz4_launch_app);
    }

    @Override
    public void onClick(View view) {
        if(view==image_1){
            if(ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)== PackageManager.PERMISSION_GRANTED){
                // TODO: Quiz4. callNumberString을 사용해 전화걸기
                String callNumberString = "tel:15772600";
            }else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 100);
            }
        }else if(view==image_2){
            // TODO: Quiz4. geoString을 사용해 구글 맵 열기
            String geoString = "geo:37.465075,126.439663";

        }else if(view==image_3){
            // TODO: Quiz4. webString을 사용해 웹브라우저 열기
            String webString = "http://www.airport.kr";
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==100 && grantResults.length>0){
            if(grantResults[0]== PackageManager.PERMISSION_GRANTED){
                // TODO: Quiz4. callNumberString을 사용해 전화걸기
            }
        }
    }

}
