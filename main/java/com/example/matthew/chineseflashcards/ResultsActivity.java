package com.example.matthew.chineseflashcards;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);


        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        String[] messageParts = message.split(" ");

        TextView text1 = (TextView) findViewById(R.id.textView4);
        TextView text2 = (TextView) findViewById(R.id.textView7);
        TextView text3 = (TextView) findViewById(R.id.textView6);

        text1.setText("Number Correct: " + messageParts[0]);
        text2.setText("Number Incorrect: " + messageParts[1]);
        text3.setText("Miliseconds to Complete" + messageParts[3]);

    }

    public void backToStart(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
