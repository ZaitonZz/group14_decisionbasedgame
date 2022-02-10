package com.example.group14_decisionbasedgame.view;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.group14_decisionbasedgame.R;


public class loading_screen extends AppCompatActivity {

    ProgressBar progressBar;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading_screen);

        progressBar = findViewById(R.id.pro);
        textView = findViewById(R.id.txt);

        progressBar.setMax(100);
        progressBar.setScaleY(2f);

        progressAnimation();

    }

    private void progressAnimation() {

        ProgressAnimation animation =  new ProgressAnimation(this,textView,progressBar,0f,100f);
        animation.setDuration(8000);
        progressBar.setAnimation(animation);
    }
}



