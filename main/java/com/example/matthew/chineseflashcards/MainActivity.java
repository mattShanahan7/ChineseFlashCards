package com.example.matthew.chineseflashcards;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.matthew.TEXT";
    public static final String EXTRA_MESSAGE2 = "com.example.matthew.RESULTS";

    public static final String RETURN_MESSAGE = "com.example.matthew.RET";
    String strEditText = "";
    int totalCorrect = 0;

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
        startActivityForResult(intent, 1);
        //finish();
    }

    public void startEnglish(View view)
    {
        Intent intent = new Intent(this, QuizActivity.class);
        String text = "English";
        intent.putExtra(EXTRA_MESSAGE, text);
        startActivityForResult(intent, 1);

    }

    public void startPinyin(View view)
    {
        Intent intent = new Intent(this, QuizActivity.class);
        String text = "Pinyin";
        intent.putExtra(EXTRA_MESSAGE, text);
        startActivityForResult(intent, 1);


    }

    public void startChinese(View view)
    {
        Intent intent = new Intent(this, QuizActivity.class);
        String text = "Chinese";
        intent.putExtra(EXTRA_MESSAGE, text);
        startActivityForResult(intent, 1);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                strEditText = strEditText + data.getStringExtra("editTextValue");
            }
            String[] getTotalCorrect = strEditText.split(" ");
            totalCorrect += Integer.parseInt(getTotalCorrect[0]);
            strEditText += " " + totalCorrect;
        }

        Intent intent2 = new Intent(this, ResultsActivity.class);
        intent2.putExtra(EXTRA_MESSAGE2, strEditText);
        startActivity(intent2);

        strEditText = "";

    }


}
