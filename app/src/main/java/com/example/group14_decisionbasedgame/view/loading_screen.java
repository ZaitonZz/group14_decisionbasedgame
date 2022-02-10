package com.example.group14_decisionbasedgame.view;

import android.os.Bundle;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.group14_decisionbasedgame.R;


public class loading_screen extends AppCompatActivity {

    private int CurrentProgress = 0;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading_screen);

        CurrentProgress = CurrentProgress + 10;
        progressBar.setProgress(CurrentProgress);
        progressBar.setMax(100);
    }

}



