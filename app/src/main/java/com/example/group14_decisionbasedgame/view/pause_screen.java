package com.example.group14_decisionbasedgame.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.example.group14_decisionbasedgame.R;

public class pause_screen extends AppCompatActivity {
    //TODO: Ui for the pause screen such as Exit game/Settings/Resume and functions(Need adjustment,Functions Added)
    //TODO: make the pause screen transparent/translucent


    private Button btnResume;
    private Button btnSettings;
    private Button btnMainMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pause_screen);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * .6), (int) (height * .5));

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x = 0;
        params.y = -20;

        getWindow().setAttributes(params);
        btnResume = (Button) findViewById(R.id.btn_Resume);
        btnResume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { onBackPressed(); }});
        getWindow().setAttributes(params);
        btnSettings = (Button) findViewById(R.id.btn_Settings);
        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(pause_screen.this, settings_screen.class)); }});
        getWindow().setAttributes(params);
        btnMainMenu = (Button) findViewById(R.id.btn_MainMenu);
        btnMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(pause_screen.this, main_menu_confirmation.class));
            }
        });
    }
}
