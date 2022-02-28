package com.example.group14_decisionbasedgame.controller;


import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class typewriter_effect extends androidx.appcompat.widget.AppCompatTextView {
    public TextView animateText;
    private CharSequence myText;
    private int myIndex;
    private long myDelay = 50;
    public typewriter_effect(Context context) {
        super(context);
    }


    public typewriter_effect(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    private Handler myHandler = new Handler();

    private  Runnable characterAdder = new Runnable() {
        @Override
        public void run() {
            setText(myText.subSequence(0,myIndex++));
            if (myIndex<=myText.length()){
                myHandler.postDelayed(characterAdder, myDelay);
            }
        }
    };
    public void animateText(CharSequence myTxt){
        myText = myTxt;
        myIndex = 0;
        setText("");
        myHandler.removeCallbacks(characterAdder);
        myHandler.postDelayed(characterAdder, myDelay);
    }

    public void setCharacterDelay(long m){
        myDelay = m;
    }

}
