package com.koreanair.samplemobilequiz;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

        image_1 = (ImageView) findViewById(R.id.callImage);
        image_2 = (ImageView) findViewById(R.id.mapImage);
        image_3 = (ImageView) findViewById(R.id.webImage);

        image_1.setOnClickListener(this);
        image_2.setOnClickListener(this);
        image_3.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view == image_1) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                // TODO: Quiz4. callNumberString을 사용해 전화걸기
                String callNumberString = "tel:15772600";
//                startActivity(new Intent("android.intent.action.CALL", Uri.parse(callNumberString)));
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(callNumberString)));

            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 100);
            }
        } else if (view == image_2) {
            // TODO: Quiz4. geoString을 사용해 구글 맵 열기

            String geoString = "geo:37.465075,126.439663";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(geoString));
            intent.setPackage("com.google.android.apps.maps");
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
                Log.d("click", "non");
            }

        } else if (view == image_3) {
            // TODO: Quiz4. webString을 사용해 웹브라우저 열기
            String webString = "http://www.airport.kr";
            Log.d("click", "non1");
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(webString));
            startActivity(intent);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 100 && grantResults.length > 0) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // TODO: Quiz4. callNumberString을 사용해 전화걸기
//                String callNumberString = "tel:15772600";
//                startActivity(new Intent("android.intent.action.CALL", Uri.parse(callNumberString)));
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                    // TODO: Quiz4. callNumberString을 사용해 전화걸기
                    String callNumberString = "tel:15772600";
//                startActivity(new Intent("android.intent.action.CALL", Uri.parse(callNumberString)));
                    startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(callNumberString)));

                } else {
                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 100);
                }
            }
        }
    }

}
