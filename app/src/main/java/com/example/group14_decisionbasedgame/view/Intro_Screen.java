package com.example.group14_decisionbasedgame.view;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.group14_decisionbasedgame.R;
import com.example.group14_decisionbasedgame.controller.bgRelated;
import com.example.group14_decisionbasedgame.controller.getProgressBar;
import com.example.group14_decisionbasedgame.controller.musicRelated;

public class Intro_Screen extends AppCompatActivity {

    //TODO: Change to activity to splash screen
    android.widget.ProgressBar progressBar;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: working");
        super.onCreate(savedInstanceState);
        enableFullscreen();
        new musicRelated();
        new bgRelated();
        setContentView(R.layout.intro_screen);

        musicRelated.strtintro_music(this);
        progressBar = findViewById(R.id.pro);
        textView = findViewById(R.id.txt);

        progressBar.setMax(100);
        progressBar.setScaleY(2f);

        progressAnimation();
    }

    public Intro_Screen(){};

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
    @Override
    protected void onPause(){
        super.onPause();
        musicRelated.pintro_music();
        Log.d(TAG, "Intro onPause: working");
    }
    @Override
    protected void onResume(){
        super.onResume();
        musicRelated.conintro_music();
        Log.d(TAG, "Intro onResume: working");
    }
}