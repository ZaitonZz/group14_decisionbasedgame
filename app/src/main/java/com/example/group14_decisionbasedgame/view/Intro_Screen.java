package com.example.group14_decisionbasedgame.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.group14_decisionbasedgame.R;
import com.example.group14_decisionbasedgame.controller.getProgressBar;

public class Intro_Screen extends AppCompatActivity {
    // MediaPlayer player;
    android.widget.ProgressBar progressBar;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        enableFullscreen();
        setContentView(R.layout.intro_screen);
        // player = MediaPlayer.create(this, R.raw.intromusic);

        //player.setLooping(true);
        //player.setVolume(100, 100);
        //player.start();

        setContentView(R.layout.loading_screen);

        progressBar = findViewById(R.id.pro);
       textView = findViewById(R.id.txt);

        progressBar.setMax(100);
        progressBar.setScaleY(2f);

        progressAnimation();


        // player.stop();
        //     startActivity(intent);
    }


    private void progressAnimation() {

        getProgressBar animation =  new getProgressBar(this,textView,progressBar,0f,100f, main_menu.class);
        animation.setDuration(8000);
        progressBar.setAnimation(animation);
    }
    private void enableFullscreen() {
        View decorView = getWindow().getDecorView();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                            View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                            View.SYSTEM_UI_FLAG_FULLSCREEN |
                            View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        }
    }
}