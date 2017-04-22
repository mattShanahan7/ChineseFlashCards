package com.example.matthew.chineseflashcards;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class QuizActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.matthew.passMessage";

    Dictionary dict = new Dictionary();

    Button[] topButtons;
    Button[] bottomButtons;
    boolean englishOnly;
    boolean pinyinOnly;
    boolean chineseOnly;
    int index;
    int counter; //to count how many questions have been asked
    int numCorrect;
    //int numIncorrect;
    int totalCorrect;
    int totalIncorrect;
    int numClicks = 0; //number of picks per round
    long startTime;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        for (int i = 0; i < dict.used.length; i++)
        {
            dict.used[i] = false;
        }

        totalCorrect = 0;
        totalIncorrect = 0;

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        startTime = System.currentTimeMillis();

        if (message.equals("English"))
        {
            englishOnly = true;
            dict.lastEnglishTest = System.currentTimeMillis();
        }

        else if (message.equals("Pinyin"))
        {
            pinyinOnly = true;
            dict.lastPinyinTest = System.currentTimeMillis();
        }

        else if (message.equals("Chinese"))
        {
            chineseOnly = true;
            dict.lastChineseTest = System.currentTimeMillis();
        }

        setQuiz();


    }


    public void setQuiz()
    {
        if (counter == dict.size)
        {
            goToResults(findViewById(R.id.all));
            /*
            //code to jump to the end screen activity
            long totalTime = System.currentTimeMillis() - startTime;


            Intent intent = new Intent(this, ResultsActivity.class);
            String passMessage = "";
            passMessage += (totalCorrect + " ");
            passMessage += (totalIncorrect + " ");
            passMessage += (totalTime);

            intent.putExtra(EXTRA_MESSAGE, passMessage);
            startActivity(intent);
            */
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
            textView.setText(dict.english[index]);

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

    public void goToResults(View view)
    {
        //code to jump to the end screen activity
        long totalTime = System.currentTimeMillis() - startTime;


        Intent intent = new Intent(this, ResultsActivity.class);
        String passMessage = "";
        passMessage += (totalCorrect + " ");
        passMessage += (totalIncorrect + " ");
        passMessage += (totalTime);

        intent.putExtra(EXTRA_MESSAGE, passMessage);
        startActivity(intent);

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
            numCorrect++;

        }
        else
        {
            b.setBackgroundColor(Color.RED);
            //numIncorrect++;
        }
        numClicks++;
        //checkCorrect();


        if (numClicks == 2)
        {
            numClicks = 0;
            counter++;

            if (numCorrect == 2)
            {
                totalCorrect++;

                if (englishOnly)
                    dict.englishCorrectLast[index] = true;
                else if (pinyinOnly)
                    dict.pinyinCorrectLast[index] = true;
                else if (chineseOnly)
                    dict.charCorrectLast[index] = true;
            }
            else
            {
                totalIncorrect++;

                if (englishOnly)
                    dict.englishCorrectLast[index] = false;
                else if (pinyinOnly)
                    dict.pinyinCorrectLast[index] = false;
                else if (chineseOnly)
                    dict.charCorrectLast[index] = false;
            }


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

        }



        /*
        if (numClicks == 2)
        {
            if (numCorrect == 2)
            {
                numClicks = 0;
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

            }
        }
        */


    }



}//END CLASS
