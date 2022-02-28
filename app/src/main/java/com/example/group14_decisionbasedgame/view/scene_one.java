package com.example.group14_decisionbasedgame.view;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.group14_decisionbasedgame.R;
import com.example.group14_decisionbasedgame.controller.dialogueFlow;
import com.example.group14_decisionbasedgame.controller.typewriter_effect;
import com.example.group14_decisionbasedgame.model.appDialogue;

public class scene_one extends AppCompatActivity implements View.OnClickListener {
    //TODO: UI + clock
    // TODO: button design for Pause, auto, skip and back
    private androidx.constraintlayout.widget.ConstraintLayout myLayout = null;

    private Button btnAuto, btnPause, btnHist, btnSkip;
    private Boolean allowedback;
    ImageView background, img_char;
    typewriter_effect txt_dlg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scene_one);
        enableFullscreen();
        new dialogueFlow();
        Log.d(TAG, "scene one activated");
        allowedback = false;

        myLayout = (ConstraintLayout) findViewById(R.id.scene_one);
        myLayout.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event){
                txt_dlg.setCharacterDelay(0);
                return true;

            }
        });
        btnPause = (Button) findViewById(R.id.btn_Pause);
        btnAuto = findViewById(R.id.btn_auto);
        btnSkip = findViewById(R.id.btn_skip);

        txt_dlg = findViewById(R.id.txt_dlg);

        //im finding a way to input string in animate text

        background = findViewById(R.id.bg_image);
        img_char = findViewById(R.id.img_char);

        btnPause.setOnClickListener(this);
        btnAuto.setOnClickListener(this);
        btnSkip.setOnClickListener(this);



    }
    @Override
    protected void onStart() {
        super.onStart();
        dialogueFlow.sceneone(img_char, txt_dlg, btnAuto, this);
    }

    @Override
    public void onBackPressed() {
        if (allowedback) { super.onBackPressed(); }
        else { startActivity(new Intent(this, pause_screen.class)); } }

    public void onClick(View v) {
    switch (v.getId()) {
        case R.id.btn_Pause:
            startActivity(new Intent(scene_one.this, pause_screen.class));
            break;
        case R.id.btn_auto:
            break;
        case R.id.btn_skip:
            break;
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
