package com.example.group14_decisionbasedgame.view;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.group14_decisionbasedgame.R;
import com.example.group14_decisionbasedgame.controller.musicRelated;

public class main_menu extends AppCompatActivity {
//TODO: Add the background
//TODO: Button designs

    private Button btnStart;
    private Button btnSettings;
    private Button btnExit;
    private boolean allowedback = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        enableFullscreen();
        setContentView(R.layout.main_menu);

        // checking for null and isPlaying
        musicRelated.introisNorP(this);

        // Calling Buttons
        btnStart = (Button) findViewById(R.id.btn_start);
        btnSettings = (Button) findViewById((R.id.btn_settings));
        btnExit = (Button) findViewById((R.id.btn_exit));

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(main_menu.this, loading_screen_toStart.class));
                musicRelated.stopintro_music();
            }
        });
        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { startActivity(new Intent(main_menu.this, settings_screen.class)); }});
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), exit_confirmation.class);
                startActivity(i);
            }
        });
    }
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