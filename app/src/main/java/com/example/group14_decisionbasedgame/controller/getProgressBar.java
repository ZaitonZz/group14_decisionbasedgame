package com.example.group14_decisionbasedgame.controller;

import android.content.Context;
import android.content.Intent;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ProgressBar;
import android.widget.TextView;

public class getProgressBar extends Animation {
    private Context context;
    private TextView textView;
    private android.widget.ProgressBar progressBar;
    private float from;
    private float to;
    private Class nextActivity;

    public getProgressBar(Context context, TextView textView, android.widget.ProgressBar progressBar, float from, float to, Class nextActivity) {
        this.context = context;
        this.textView = textView;
        this.progressBar = progressBar;
        this.from = from;
        this.to = to;
        this.nextActivity = nextActivity;
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);
        float value = from + (to - from) * interpolatedTime;

        progressBar.setProgress((int)value);
        textView.setText((int)value+"%");

        if (value == to) {
            context.startActivity(new Intent(context, this.nextActivity));
        }
    }
}
