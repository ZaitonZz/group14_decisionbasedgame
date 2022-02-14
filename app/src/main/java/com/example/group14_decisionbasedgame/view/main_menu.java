package com.example.group14_decisionbasedgame.view;

import static android.content.ContentValues.TAG;
import static com.example.group14_decisionbasedgame.view.Intro_Screen.went;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.net.Uri;

import com.example.group14_decisionbasedgame.R;
import com.example.group14_decisionbasedgame.controller.musicRelated;

public class main_menu extends AppCompatActivity {
    //TODO: add stop music, remove chkWent Method and replace with a call to musicRelated to check if intronstart_music isPlaying = false then call method strtintro_music()
    private Button btnStart;
    private Button btnSettings;
    private Button btnExit;
    private boolean allowedback = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        enableFullscreen();
        setContentView(R.layout.main_menu);
        chkWent();

        // Calling Buttons
        btnStart = (Button) findViewById(R.id.btn_start);
        btnSettings = (Button) findViewById((R.id.btn_settings));
        btnExit = (Button) findViewById((R.id.btn_exit));

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(main_menu.this, loading_screen_toStart.class));
                musicRelated.pMusic();
            }
        });
        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { startActivity(new Intent(main_menu.this, settings_screen.class)); }});
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { startActivity(new Intent(main_menu.this, exit_confirmation.class)); }});
    }

    public void chkWent() {
        Intro_Screen.isWent();
        if (went){musicRelated.conMusic();
            Log.d(TAG, "chkWent: working");} }
    @Override
    public void onBackPressed() {
        if (allowedback) {
            super.onBackPressed();
        } else {
            startActivity(new Intent(main_menu.this, exit_confirmation.class));
        }
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