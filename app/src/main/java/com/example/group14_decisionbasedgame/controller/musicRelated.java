package com.example.group14_decisionbasedgame.controller;

import static java.security.AccessController.getContext;

import android.content.Context;
import android.media.MediaPlayer;

import com.example.group14_decisionbasedgame.R;

public class musicRelated {
    MediaPlayer intronstart_music;

    public musicRelated() {
    }

    public void strtintro_music(Context context) {
        intronstart_music = MediaPlayer.create(context, R.raw.main_menu_loop);
        intronstart_music.setLooping(true);
        intronstart_music.setVolume(100, 100);
        intronstart_music.start();
    }
}
