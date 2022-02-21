package com.example.group14_decisionbasedgame.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.group14_decisionbasedgame.R;

public class scene_one extends AppCompatActivity {
//TODO: UI + clock


    private Button btnBack;
    private Boolean allowedback = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scene_one);

        btnBack = (Button) findViewById(R.id.btn_back);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(scene_one.this, main_menu.class)); }});
    }
    @Override
    public void onBackPressed() {
        if (allowedback) {
            super.onBackPressed();
        } else {
            startActivity(new Intent(this, main_menu.class));
        }
    }
}
