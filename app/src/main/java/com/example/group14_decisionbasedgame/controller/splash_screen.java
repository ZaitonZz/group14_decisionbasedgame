package com.example.group14_decisionbasedgame.controller;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.group14_decisionbasedgame.R;
import com.example.group14_decisionbasedgame.view.main_menu;
//TODO: Fix the design


public class splash_screen extends AppCompatActivity {

    private static int SPLASH_SCREEN = 5000;



    Animation splashScreen;
    TextView appTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Log.d(TAG, "onCreate: working");
        new musicRelated();
        setContentView(R.layout.splash_screen);
        musicRelated.strtintro_music(this);

        splashScreen = AnimationUtils.loadAnimation(this,R.anim.splash_screen_animation);

        appTitle = findViewById(R.id.splashTitle);
        appTitle.setAnimation(splashScreen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent (splash_screen.this, main_menu.class );
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);
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

