package com.example.group14_decisionbasedgame.controller;

import android.media.MediaPlayer;

import com.example.group14_decisionbasedgame.R;

public class Music_Related {
    MediaPlayer intronstart_music;

    public void strtintro_music() {
       // intronstart_music = MediaPlayer.create(thi  intronstart_music = MediaPlayer.create(this, R.raw.main_menu_loop);
        intronstart_music.setLooping(true);
        intronstart_music.setVolume(100, 100);
       // intronstart_music.start();s, R.raw.credits);
        intronstart_music.setLooping(true);
        intronstart_music.setVolume(100, 100);
        intronstart_music.start();
    }
}
