package com.example.group14_decisionbasedgame.controller;

import android.widget.ImageView;
import com.example.group14_decisionbasedgame.R;
import java.util.Random;

public class bgRelated {

    public bgRelated(){}

    public static void nxtBgClsRoom(ImageView background) { background.setImageResource(R.drawable.classroom); }
    public static void nxtBgOut(ImageView background) { background.setImageResource(R.drawable.outside); }
    public static void nxtBgHall(ImageView background) { background.setImageResource(R.drawable.hallway); }
    public static void nxtBgClbRoom(ImageView background) { background.setImageResource(R.drawable.clubroom); }

    //background randomizer for loading screens
    public static void Lscreen_bgRandom(ImageView background) {
        Random randomizer = new Random();
        byte seed = (byte) randomizer.nextInt(3);

        switch (seed) {
            case 0: nxtBgClsRoom(background); break;
            case 1: nxtBgOut(background); break;
            case 2: nxtBgHall(background); break;
            case 3: nxtBgClbRoom(background); break;
        }
    }
}
