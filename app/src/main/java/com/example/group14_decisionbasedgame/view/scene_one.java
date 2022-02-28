package com.example.group14_decisionbasedgame.view;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.group14_decisionbasedgame.R;
import com.example.group14_decisionbasedgame.controller.dialogueFlow;
import com.example.group14_decisionbasedgame.controller.typewriter_effect;

public class scene_one extends AppCompatActivity implements View.OnClickListener {
    //TODO: UI + clock
    // TODO: button design for Pause, auto, skip and back




    private Button btnAuto, btnPause, btnHist, btnSkip;
    private Boolean allowedback = false;
    ImageView background, img_char;
    TextView txt_dlg;
    int clicked = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scene_one);
        enableFullscreen();
        new dialogueFlow();



        btnPause = (Button) findViewById(R.id.btn_Pause);
        btnAuto = findViewById(R.id.btn_auto);
        btnSkip = findViewById(R.id.btn_skip);

        typewriter_effect txt_dlg = findViewById(R.id.txt_dlg);

        txt_dlg.setText("");
        txt_dlg.setCharacterDelay(50);
        txt_dlg.animateText("");
        //im finding a way to input string in animate text

        background = findViewById(R.id.bg_image);
        img_char = findViewById(R.id.img_char);

        btnPause.setOnClickListener(this);
        btnAuto.setOnClickListener(this);
        btnSkip.setOnClickListener(this);

        dialogueFlow.sceneone(img_char,txt_dlg, btnAuto);
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
            clicked++;
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
