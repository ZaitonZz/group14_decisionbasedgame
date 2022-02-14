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
import com.example.group14_decisionbasedgame.controller.getProgressBar;

public class Intro_Screen extends AppCompatActivity {

    //TODO: Change to activity to splash screen
    //TODO: Cannot go back to a loading screen
    android.widget.ProgressBar progressBar;
    TextView textView;
    static MediaPlayer intronstart_music;
    public static boolean went = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        enableFullscreen();
        setContentView(R.layout.intro_screen);

        intronstart_music = MediaPlayer.create(this, R.raw.main_menu_loop);
        intronstart_music.setLooping(true);
        intronstart_music.setVolume(100, 100);
        intronstart_music.start();

        progressBar = findViewById(R.id.pro);
        textView = findViewById(R.id.txt);

        progressBar.setMax(100);
        progressBar.setScaleY(2f);

        progressAnimation();


        // player.stop();
        //     startActivity(intent);
    }

    public Intro_Screen(){};

    private void progressAnimation() {

        getProgressBar animation =  new getProgressBar(this,textView,progressBar,0f,100f, main_menu.class);
        animation.setDuration(8000);
        progressBar.setAnimation(animation);
    }
    public static void stopMusic() {
        intronstart_music.release();
        intronstart_music = null;
        Log.d(TAG, "stopMusic: working");
    }
    public static void conMusic() { intronstart_music.start();}
    public static void pMusic() { intronstart_music.pause();}
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
        intronstart_music.pause();
        Log.d(TAG, "onPause: working");
    }
    @Override
    protected void onResume(){
        super.onResume();
        intronstart_music.start();
        Log.d(TAG, "onResume: working");
        went = true;
    }
    public static boolean isWent() {
        return went;
    }
}