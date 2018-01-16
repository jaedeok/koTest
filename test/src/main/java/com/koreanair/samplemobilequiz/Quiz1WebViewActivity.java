package com.koreanair.samplemobilequiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class Quiz1WebViewActivity extends AppCompatActivity {

    String urlForLoading = "https://www.koreanair.com/content/koreanair-mobile/korea/ko.html/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz1_web_view);

        // TODO: Quiz1. 위 urlForLoading 주소를 사용하여 Web View 구현하기
    }
}
