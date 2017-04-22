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
    boolean englishOnly;
    boolean pinyinOnly;
    boolean chineseOnly;
    int index;
    int counter; //to count how many questions have been asked
    int numCorrect;
    int numIncorrect;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        //Dictionary dict = new Dictionary()

        for (int i = 0; i < dict.used.length; i++)
        {
            dict.used[i] = false;
        }


        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        //TextView textView = (TextView) findViewById(R.id.t);

        if (message.equals("English"))
            englishOnly = true;
            //englishQuiz();

        else if (message.equals("Pinyin"))
            pinyinOnly = true;


        else if (message.equals("Chinese"))
            chineseOnly = true;

        setQuiz();


    }


    public void setQuiz()
    {
        if (counter == dict.size)
        {
            //code to jump to the end screen activity
        }

        topButtons = new Button[]{
                (Button) findViewById(R.id.button2), (Button) findViewById(R.id.button5),
                (Button) findViewById(R.id.button6), (Button) findViewById(R.id.button7)
        };

        bottomButtons = new Button[]{
                (Button)findViewById(R.id.button8), (Button)findViewById(R.id.button9),
                (Button)findViewById(R.id.button10), (Button)findViewById(R.id.button11)
        };

        for (int i = 0; i < topButtons.length; i++)
        {
            topButtons[i].setBackgroundColor(Color.WHITE);
            bottomButtons[i].setBackgroundColor(Color.WHITE);
        }

        index = (int)(dict.size * Math.random());
        while (dict.used[index] == true)
            index = (int)(dict.size * Math.random());

        dict.used[index] = true;

        TextView textView = (TextView) findViewById(R.id.textView2);

        int topIndex = (int)(Math.random() * 4);
        int bottomIndex = (int)(Math.random() * 4);



        //if the quiz is in english, check the flag and set up the board
        if (englishOnly)
        {
            //index = (int)(dict.size * Math.random());
            //while (dict.used[index] == true)
            //    index = (int)(dict.size * Math.random());

            //dict.used[index] = true;

            //TextView textView = (TextView) findViewById(R.id.textView2);
            textView.setText(dict.english[index]);

            //int topIndex = (int)(Math.random() * 4);
            //int bottomIndex = (int)(Math.random() * 4);

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
        }//if (englishOnly)
        else if (pinyinOnly)
        {
            textView.setText(dict.pinyin[index]);

            topButtons[topIndex].setText(dict.english[index]);
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
                    topButtons[j].setText(dict.english[filler]);

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
        }//end pinyin

        else if (chineseOnly)
        {
            textView.setText(dict.characters[index]);

            topButtons[topIndex].setText(dict.english[index]);
            bottomButtons[bottomIndex].setText(dict.pinyin[index]);

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
                    topButtons[j].setText(dict.english[filler]);

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
                    bottomButtons[j].setText(dict.pinyin[filler]);

                }
            }

        }//end chinese


    }






    public void CheckButton(View view)
    {
        //find button that called this function
        final Button b = (Button) findViewById(view.getId());

        if (b.getText().equals(dict.characters[index]) ||
                b.getText().equals(dict.pinyin[index]) ||
                b.getText().equals(dict.english[index]))
        {
            b.setBackgroundColor(Color.GREEN);
            //view.invalidate();
            numCorrect++;

            b.post(new Runnable() {
                @Override
                public void run() {
                    b.setBackgroundColor(Color.GREEN);

                }
            });
            view.postInvalidate();
            /*
            if (numCorrect == 2)
            {
                numCorrect = 0;
                counter++;
                b.setBackgroundColor(Color.GREEN);
                android.os.SystemClock.sleep(1000);

                setQuiz();
            }
            */

        }
        else
        {
            b.setBackgroundColor(Color.RED);
            numIncorrect++;
        }
        //checkCorrect();


        if (numCorrect == 2)
        {
            if (numCorrect == 2)
            {
                numCorrect = 0;
                counter++;
                b.post(new Runnable() {
                    @Override
                    public void run() {
                        b.setBackgroundColor(Color.GREEN);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        setQuiz();
                    }
                });
                //b.setBackgroundColor(Color.GREEN);
                //android.os.SystemClock.sleep(1000);

                //setQuiz();
            }
        }



    }

    /*
    public void checkCorrect()
    {
        if (numCorrect == 2)
        {
            if (numCorrect == 2)
            {
                numCorrect = 0;
                counter++;
                //b.setBackgroundColor(Color.GREEN);
                //android.os.SystemClock.sleep(1000);

                setQuiz();
            }
        }
    }
    */








}//END CLASS
