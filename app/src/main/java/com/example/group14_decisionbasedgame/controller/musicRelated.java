package com.example.group14_decisionbasedgame.controller;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;

import com.example.group14_decisionbasedgame.R;

import java.util.Random;

public class musicRelated {
    private static MediaPlayer intronstart_music;
    private static MediaPlayer Lscreen_music;
    private static MediaPlayer gScreen;

    public musicRelated() { }

    //intro music
    public static void strtintro_music(Context context) {
        intronstart_music = MediaPlayer.create(context, R.raw.main_menu_loop);
        intronstart_music.setLooping(true);
        intronstart_music.setVolume(100, 100);
        intronstart_music.start(); }
    public static void stopintro_music() {
        intronstart_music.release();
        intronstart_music = null;
        Log.d(TAG, "stopintro_music: working"); }
    public static void conintro_music() { intronstart_music.start();}
    public static void pintro_music() { intronstart_music.pause();}
    public static void introisNorP(Context context){
        if (intronstart_music==null){ strtintro_music(context); }
        else if (!intronstart_music.isPlaying()){ conintro_music(); } }

    //loading screen music randomizer
    public static void strtLscreen(Context context){
        Random randomizer = new Random();
        byte seed= (byte) randomizer.nextInt(7);

        switch(seed){
            case 0: Lscreen_music = MediaPlayer.create(context, R.raw.girl_one_main); break;
            case 1: Lscreen_music = MediaPlayer.create(context, R.raw.girl_one_secondary); break;
            case 2: Lscreen_music = MediaPlayer.create(context, R.raw.girl_two_main); break;
            case 3: Lscreen_music = MediaPlayer.create(context, R.raw.girl_two_secondary); break;
            case 4: Lscreen_music = MediaPlayer.create(context, R.raw.girl_three_main); break;
            case 5: Lscreen_music = MediaPlayer.create(context, R.raw.girl_three_secondary); break;
            case 6: Lscreen_music = MediaPlayer.create(context, R.raw.girl_four_main); break;
            case 7: Lscreen_music = MediaPlayer.create(context, R.raw.girl_four_secondary); break; }
        Lscreen_music.start();
    }
    public static void stopLscreen_music() {
        Lscreen_music.release();
        Lscreen_music = null;
        Log.d(TAG, "stopLscreen_music: working"); }

    //game screen controls
    public static void strtg1_main(Context context) {
        gScreen = MediaPlayer.create(context, R.raw.girl_one_main);
        gScreen.setLooping(true);
        gScreen.start();
        Log.d(TAG, "girl one activated");
    }
    public static void stop_g1_main() {
        gScreen.release();
        gScreen = null;
        Log.d(TAG, "stopg1_main: working"); }
    public static void con_g1_main() { gScreen.start();}
    public static void p_g1_main() { gScreen.pause();}
}
