package com.koreanair.samplemobilequiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Quiz2ListViewActivity extends AppCompatActivity {

    String[] values = new String[] {
            "첫 번째 리스트 입니다.",
            "두 번째 리스트 입니다.",
            "세 번째 리스트 입니다.",
            "네 번째 리스트 입니다.",
            "다섯 번째 리스트 입니다.",
            "여섯 번째 리스트 입니다.",
            "일곱 번째 리스트 입니다.",
            "여덟 번째 리스트 입니다.",
            "아홉 번째 리스트 입니다.",
            "열 번째 리스트 입니다."
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz2_list_view);

        //TODO: Quiz2. ListView로 위 array값(values) 출력
        ListView listView = (ListView)findViewById(R.id.list_view_1);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,values);
        listView.setAdapter(adapter);
    }
}
