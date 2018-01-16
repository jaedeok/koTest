package com.koreanair.samplemobilequiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Quiz3ReceiveIntentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz3_receive_intent);


        TextView textView1 = (TextView)findViewById(R.id.tv_username);
        TextView textView2 = (TextView)findViewById(R.id.tv_pwd);

        Intent intent = getIntent();
        String userName = intent.getStringExtra("userName");
        String password = intent.getStringExtra("password");

        textView1.setText(userName);
        textView2.setText(password);


    }
}
