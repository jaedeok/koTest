package com.testapp.www.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button webViewBtn = (Button)findViewById(R.id.webViewBtn);
        Button listbtn = findViewById(R.id.listBtn);

        webViewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
                startActivity(intent);
            }
        });

        listbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //위 방식을 한줄로도 요약 가능합니다.
                startActivity(new Intent(MainActivity.this, ListViewActivity.class));
            }
        });

    }
}
