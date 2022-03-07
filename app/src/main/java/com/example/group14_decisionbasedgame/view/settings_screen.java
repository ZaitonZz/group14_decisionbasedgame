package com.example.group14_decisionbasedgame.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import com.example.group14_decisionbasedgame.R;
import com.example.group14_decisionbasedgame.controller.musicRelated;





public class settings_screen extends AppCompatActivity{

    private Button btnUpdate, btnRestart;
    private TextView btnBack;
    private SwitchCompat audioSwitch;


    // TODO: Need button design for Back(X) ,Update restart, and Switch design for Audio
    // TODO: Background
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_screen);
        new musicRelated();
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;


        getWindow().setLayout((int) (width * .4), (int) (height * .7));
        AudioManager amanager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        SharedPreferences sharedPreferences = getSharedPreferences("save",MODE_PRIVATE);
        audioSwitch = (SwitchCompat) findViewById(R.id.switch1);
        audioSwitch.setChecked(sharedPreferences.getBoolean("value",true));


        audioSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (audioSwitch.isChecked()) {
                    SharedPreferences.Editor editor = getSharedPreferences("save",MODE_PRIVATE).edit();
                    editor.putBoolean("value",true);
                    editor.apply();
                    audioSwitch.setChecked(true);
                    amanager.adjustVolume(AudioManager.ADJUST_UNMUTE, AudioManager.FLAG_SHOW_UI);
                } else {
                    SharedPreferences.Editor editor = getSharedPreferences("save",MODE_PRIVATE).edit();
                    editor.putBoolean("value",false);
                    editor.apply();
                    audioSwitch.setChecked(false);
                    amanager.adjustVolume(AudioManager.ADJUST_MUTE, AudioManager.FLAG_SHOW_UI);
                }
            }
        });
        btnBack = (TextView) findViewById(R.id.btn_X);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        btnRestart = (Button) findViewById(R.id.btn_Restart);
        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(new Intent(settings_screen.this, Intro_Screen.class));

            }
        });
        btnUpdate = (Button) findViewById(R.id.btn_Update);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(settings_screen.this, R.string.update, Toast.LENGTH_LONG).show();
            }
        });
    }
}