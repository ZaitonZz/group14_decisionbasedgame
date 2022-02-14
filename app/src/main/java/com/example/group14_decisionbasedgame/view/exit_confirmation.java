package com.example.group14_decisionbasedgame.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.group14_decisionbasedgame.R;

public class exit_confirmation extends AppCompatActivity {

    private Button btnAgree;
    private Button btnDismiss;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exit_confirmation);

        btnAgree = (Button) findViewById(R.id.btn_Agree);
        btnAgree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
                ;
            }
        });
        btnDismiss = (Button) findViewById(R.id.btn_Dismiss);
        btnDismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(exit_confirmation.this, main_menu.class));
                ;
            }
        });
    }
}
