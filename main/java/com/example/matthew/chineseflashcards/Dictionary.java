package com.example.matthew.chineseflashcards;

/**
 * Created by Matthew on 4/21/17.
 */

public final class Dictionary
{
    public int size = 28;

    public static final String[] characters = {
            "⼸", "⼳", "⼯", "⽇", "⼼", "⼽", "⼿", "⽉", "⽊", "⽬",
            "⽼", "⼈", "⼀", "⼆", "⼋", "⼗", "⼉", "⻔", "⼑",
            "⼒", "⻢", "⼟", "⼣", "⼤", "⼥", "⼦", "⼨", "⼩"
    };

    public static final String[] pinyin = {
            "gōng", "yāo", "gōng", "rì", "xīn", "gē", "shǒu", "yuè",
            "mù", "mù", "lǎo", "rén", "yī", "èr", "bā", "shí", "ér",
            "mén", "dāo", "lì", "mǎ", "tǔ", "xī", "dà", "nǔ", "zǐ",
            "cùn", "xiào"
    };

    public static final String[] english = {
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


}
