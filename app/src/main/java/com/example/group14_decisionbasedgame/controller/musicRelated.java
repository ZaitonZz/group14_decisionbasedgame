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
            case 0: Lscreen_music = MediaPlayer.create(context, R.raw.stem_main); break;
            case 1: Lscreen_music = MediaPlayer.create(context, R.raw.stem_secondary); break;
            case 2: Lscreen_music = MediaPlayer.create(context, R.raw.abm_main); break;
            case 3: Lscreen_music = MediaPlayer.create(context, R.raw.abm_secondary); break;
            case 4: Lscreen_music = MediaPlayer.create(context, R.raw.ict_main); break;
            case 5: Lscreen_music = MediaPlayer.create(context, R.raw.ict_secondary); break;
            case 6: Lscreen_music = MediaPlayer.create(context, R.raw.humss_main); break;
            case 7: Lscreen_music = MediaPlayer.create(context, R.raw.humss_secondary); break; }
        Lscreen_music.start();
    }
    public static void stopLscreen_music() {
        Lscreen_music.release();
        Lscreen_music = null;
        Log.d(TAG, "stopLscreen_music: working"); }

    //game screen controls
    public static void strtstem_main(Context context) {
        gScreen = MediaPlayer.create(context, R.raw.stem_main);
        gScreen.setLooping(true);
        gScreen.start();
        Log.d(TAG, "girl one activated");
    }

    public static void strtstem_secondary(Context context) {
        gScreen = MediaPlayer.create(context, R.raw.stem_secondary);
        gScreen.setLooping(true);
        gScreen.start();
        Log.d(TAG, "girl one activated");
    }

    public static void strtabm_main(Context context) {
        gScreen = MediaPlayer.create(context, R.raw.abm_main);
        gScreen.setLooping(true);
        gScreen.start();
        Log.d(TAG, "girl one activated");
    }

    public static void strtabm_secondary(Context context) {
        gScreen = MediaPlayer.create(context, R.raw.abm_secondary);
        gScreen.setLooping(true);
        gScreen.start();
        Log.d(TAG, "girl one activated");
    }

    public static void strtict_main(Context context) {
        gScreen = MediaPlayer.create(context, R.raw.ict_main);
        gScreen.setLooping(true);
        gScreen.start();
        Log.d(TAG, "girl one activated");
    }
    public static void strtict_secondary(Context context) {
        gScreen = MediaPlayer.create(context, R.raw.ict_secondary);
        gScreen.setLooping(true);
        gScreen.start();
        Log.d(TAG, "girl one activated");
    }
    public static void strthumss_main(Context context) {
        gScreen = MediaPlayer.create(context, R.raw.humss_main);
        gScreen.setLooping(true);
        gScreen.start();
        Log.d(TAG, "girl one activated");
    }
    public static void strthumss_secondary(Context context) {
        gScreen = MediaPlayer.create(context, R.raw.humss_secondary);
        gScreen.setLooping(true);
        gScreen.start();
        Log.d(TAG, "girl one activated");
    }
    public static void strtgood_ending(Context context) {
        gScreen = MediaPlayer.create(context, R.raw.good_ending);
        gScreen.setLooping(true);
        gScreen.start();
        Log.d(TAG, "actibaited");
    }
    public static void strtcorrupt(Context context) {
        gScreen = MediaPlayer.create(context, R.raw.ict_corrupted);
        gScreen.setLooping(true);
        gScreen.start();
        Log.d(TAG, "actibaited");
    }
    public static void strtcredits(Context context) {
        gScreen = MediaPlayer.create(context, R.raw.credits);
        gScreen.setLooping(true);
        gScreen.start();
        Log.d(TAG, "actibaited");
    }
    public static void stop_gScreen_music() {
        gScreen.release();
        gScreen = null;
        Log.d(TAG, "stopgScreen_music: working"); }
    public static void con_gScreen_music() { gScreen.start();}
    public static void p_gScreen_music() { gScreen.pause();}
}
