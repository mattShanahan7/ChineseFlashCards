package com.example.matthew.chineseflashcards;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class QuizActivity extends AppCompatActivity {

    Dictionary dict = new Dictionary();

    Button[] topButtons;
    Button[] bottomButtons;
    int index;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        //Dictionary dict = new Dictionary()




        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        //TextView textView = (TextView) findViewById(R.id.t);

        if (message.equals("English"))
        {
            englishQuiz();
        }
        //Button b1 = (Button) findViewById(R.id.button2);
        //b1.setText(dict.characters[0]);

    }

    public void englishQuiz()
    {

        topButtons = new Button[]{
                (Button) findViewById(R.id.button2), (Button) findViewById(R.id.button5),
                (Button) findViewById(R.id.button6), (Button) findViewById(R.id.button7)
        };

        bottomButtons = new Button[]{
            (Button)findViewById(R.id.button8), (Button)findViewById(R.id.button9),
                    (Button)findViewById(R.id.button10), (Button)findViewById(R.id.button11)
        };


        //for (int i = 0; i < dict.size; i++)
        //{
            index = (int)(dict.size * Math.random());
            System.out.println(index);
            //while (dict.used[index] == true)
            //    index = (int)(dict.size * Math.random());

            TextView textView = (TextView) findViewById(R.id.textView2);
            textView.setText(dict.english[index]);

            int topIndex = (int)(Math.random() * 4);
            int bottomIndex = (int)(Math.random() * 4);

            topButtons[topIndex].setText(dict.pinyin[index]);
            bottomButtons[bottomIndex].setText(dict.characters[index]);

            for (int j = 0; j<4; j++)
            {
                if (j == topIndex)
                {

                }
                else
                {
                    int filler = (int)(dict.size * Math.random());
                    while (filler == topIndex)
                            filler = (int)(dict.size * Math.random());
                    topButtons[j].setText(dict.pinyin[filler]);

                }
            }

             for (int j = 0; j<4; j++)
             {
                  if (j == bottomIndex)
                  {

                  }
                  else
                  {
                        int filler = (int)(dict.size * Math.random());
                        while (filler == bottomIndex)
                            filler = (int)(dict.size * Math.random());
                        bottomButtons[j].setText(dict.characters[filler]);

                  }
              }



        //}
    }

    public void CheckButton(View view)
    {
        Button b = (Button) findViewById(view.getId());

        if (b.getText().equals(dict.characters[index]) ||
                b.getText().equals(dict.pinyin[index]) ||
                b.getText().equals(dict.english[index]))
        {
            b.setBackgroundColor(Color.GREEN);


        }
        else
        {
            b.setBackgroundColor(Color.RED);
        }




    }
}
