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


public final class Dictionary
{

    public int size = 28;


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
