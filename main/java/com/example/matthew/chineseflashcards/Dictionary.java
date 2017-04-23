package com.example.matthew.chineseflashcards;

import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Matthew on 4/21/17.
 */

public final class Dictionary
{

    public int size = 28;



    /*
    public Dictionary()
    {
        String _url = "http://people.cs.georgetown.edu/~bk620/chidi.txt";

        URL url;
        //BufferedOutputStream out;
        //InputStream in;
        //BufferedInputStream buf;
        BufferedReader reader;

        try
        {
            url = new URL(_url);
            //reader = new BufferedReader(new InputStreamReader(url.openStream()));
            reader = new BufferedReader(new FileReader("/Users/Matthew/Desktop/input.txt"));

            //reader = url.openStream();

            // Read the inputstream
            //buf = new BufferedInputStream(in);


            String line = "";
            int counter = 0;
            while ((line = reader.readLine()) != null)
            {
                String[] lineSplit = line.split(",");
                characters[counter] = lineSplit[0];
                pinyin[counter] = lineSplit[1];
                english[counter] = lineSplit[2];
                counter++;
                //lineOut = "In loop";
            }

           // Log.d("Output", line);

          //  lineOut = ""+ counter;

            reader.close();
            size = counter;

        }
        catch (Exception e)
        {
            Log.e("Error reading file", e.toString());
        }

    }
    */





    public String[] characters = {
            "⼸", "⼳", "⼯", "⽇", "⼼", "⼽", "⼿", "⽉", "⽊", "⽬",
            "⽼", "⼈", "⼀", "⼆", "⼋", "⼗", "⼉", "⻔", "⼑",
            "⼒", "⻢", "⼟", "⼣", "⼤", "⼥", "⼦", "⼨", "⼩"
    };

    public String[] pinyin = {
            "gōng", "yāo", "gōng", "rì", "xīn", "gē", "shǒu", "yuè",
            "mù", "mù", "lǎo", "rén", "yī", "èr", "bā", "shí", "ér",
            "mén", "dāo", "lì", "mǎ", "tǔ", "xī", "dà", "nǔ", "zǐ",
            "cùn", "xiào"
    };

    public String[] english = {
            "bow", "tiny", "work", "sun", "heart", "dagger-axe", "hand",
            "moon", "wood", "eye", "old", "person", "one", "two", "eight",
            "ten", "child", "door", "knife", "power", "horse", "earth",
            "sunset", "big", "female", "son", "inch", "small"
    };


    public boolean[] used = {
            false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false
    };

    public boolean[] charCorrectLast = {
            false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false
    };

    public boolean[] pinyinCorrectLast = {
            false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false
    };

    public boolean[] englishCorrectLast = {
            false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false
    };

    public long lastChineseTest = 0;
    public long lastPinyinTest = 0;
    public long lastEnglishTest = 0;


}
