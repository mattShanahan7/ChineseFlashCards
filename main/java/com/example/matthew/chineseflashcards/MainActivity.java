package com.example.matthew.chineseflashcards;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.matthew.TEXT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openActivity(View view)
    {
        Intent intent = new Intent(this, QuizActivity.class);
        String text = "Message";
        intent.putExtra(EXTRA_MESSAGE, text);
        startActivity(intent);
    }

    public void startEnglish(View view)
    {
        Intent intent = new Intent(this, QuizActivity.class);
        String text = "English";
        intent.putExtra(EXTRA_MESSAGE, text);
        startActivity(intent);
    }

    public void startPinyin(View view)
    {
        Intent intent = new Intent(this, QuizActivity.class);
        String text = "Pinyin";
        intent.putExtra(EXTRA_MESSAGE, text);
        startActivity(intent);
    }

    public void startChinese(View view)
    {
        Intent intent = new Intent(this, QuizActivity.class);
        String text = "Chinese";
        intent.putExtra(EXTRA_MESSAGE, text);
        startActivity(intent);

    }

}
