package com.example.group14_decisionbasedgame.controller;

import static android.content.ContentValues.TAG;
import static java.security.AccessController.getContext;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;

import com.example.group14_decisionbasedgame.R;
import com.example.group14_decisionbasedgame.view.main_menu;

public class musicRelated {
    static MediaPlayer intronstart_music;

    public musicRelated() {
    }

    public static void strtintro_music(Context context) {
        intronstart_music = MediaPlayer.create(context, R.raw.main_menu_loop);
        intronstart_music.setLooping(true);
        intronstart_music.setVolume(100, 100);
        intronstart_music.start();
    }
    public static void stopMusic() {
        intronstart_music.release();
        intronstart_music = null;
        Log.d(TAG, "stopMusic: working");
    }
    public static void conMusic() { intronstart_music.start();}
    public static void pMusic() { intronstart_music.pause();}
    public static void introisNorP(Context context){
        if (intronstart_music==null){ strtintro_music(context); }
        else if (!intronstart_music.isPlaying()){ conMusic(); } }
}
