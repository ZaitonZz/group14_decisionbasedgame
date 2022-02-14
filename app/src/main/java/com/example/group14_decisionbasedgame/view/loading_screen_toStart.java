package com.example.group14_decisionbasedgame.view;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.group14_decisionbasedgame.R;
import com.example.group14_decisionbasedgame.controller.getProgressBar;


public class loading_screen_toStart extends AppCompatActivity {
    //TODO: make an array playlist with randomizer either here or most probably in a controller class, exclude all the corrupted music.
    //TODO: make a corrupted version of the music for loading screen and main menu as the plot twist is reached. Probably will have a boolean that is checked everytime the game is started? to change the music and bg picture
    ProgressBar progressBar;
    TextView textView;
    //static MediaPlayer load_rdm_music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        enableFullscreen();
        setContentView(R.layout.loading_screen_tostart);

        progressBar = findViewById(R.id.pro);
        textView = findViewById(R.id.txt);
        progressBar.setMax(100);
        progressBar.setScaleY(2f);
        progressAnimation();

        // load_rdm_music= MediaPlayer.create(this, Array(R.raw.girl_one_main, R.raw.girl_two_main));
    }

    private void progressAnimation() {

        getProgressBar animation =  new getProgressBar(this,textView,progressBar,0f,100f, start_game.class);
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




