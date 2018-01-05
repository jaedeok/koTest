package com.testapp.www.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListViewActivity extends AppCompatActivity {


    String[] list = {"첫 번째 리스트 입니다.","두 번째 리스트 입니다.","세 번째 리스트 입니다.","네 번째 리스트 입니다.",
            "다섯 번째 리스트 입니다.","여섯 번째 리스트 입니다.","일곱 번째 리스트 입니다.","여덟 번째 리스트 입니다.",
            "아홉 번째 리스트 입니다.","열 번째 리스트 입니다."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);



        ListView listView = findViewById(R.id.listview);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,list);

        listView.setAdapter(adapter);

    }
}
