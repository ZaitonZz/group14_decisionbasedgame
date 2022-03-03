package com.example.group14_decisionbasedgame.view;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.group14_decisionbasedgame.R;
import com.example.group14_decisionbasedgame.controller.bgRelated;
import com.example.group14_decisionbasedgame.controller.musicRelated;

public class Intro_Screen extends AppCompatActivity {

    private static int SPLASH_SCREEN = 5000;


    Animation splashScreen,  splashScreen2, splashScreen3, splashScreen4, splashScreen5;
    ImageView station, station14;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: working");
        super.onCreate(savedInstanceState);
        enableFullscreen();
        new musicRelated();
        new bgRelated();
        setContentView(R.layout.splash_screen);

        musicRelated.strtintro_music(this);

        splashScreen = AnimationUtils.loadAnimation(this,R.anim.gasstation_anim);
        splashScreen2 = AnimationUtils.loadAnimation(this,R.anim.station14_anim);
        splashScreen3 = AnimationUtils.loadAnimation(this,R.anim.station14bounceback_animation);
        splashScreen4= AnimationUtils.loadAnimation(this,R.anim.gasstationbounceaway_animation);
        splashScreen5= AnimationUtils.loadAnimation(this,R.anim.gasstationbounceback_animation);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                station14.setAnimation(splashScreen2);
            }
        }, 1000);;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                station14.setAnimation(splashScreen3);
            }
        }, 2000);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                station.setAnimation(splashScreen4);
            }
        }, 2900);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                station.setAnimation(splashScreen5);
            }
        }, 4000);

        station = findViewById(R.id.gasStation);
        station.setAnimation(splashScreen);

        station14 = findViewById(R.id.station14);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent (Intro_Screen.this, main_menu.class );
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);
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