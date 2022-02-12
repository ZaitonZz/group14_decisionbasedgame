package com.example.group14_decisionbasedgame.model;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.group14_decisionbasedgame.R;
import com.example.group14_decisionbasedgame.view.main_menu;
import com.example.group14_decisionbasedgame.view.settings_screen;

public class start_game extends AppCompatActivity {

    private Button btnBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_game);

        btnBack = (Button) findViewById(R.id.btn_back);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(start_game.this, main_menu.class));
            }
        });

    }
}
