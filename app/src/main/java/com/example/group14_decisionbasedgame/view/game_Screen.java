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

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.group14_decisionbasedgame.R;
import com.example.group14_decisionbasedgame.controller.dialogueFlow;
import com.example.group14_decisionbasedgame.controller.typewriter_effect;
import com.example.group14_decisionbasedgame.model.appRelated;

public class game_Screen extends AppCompatActivity implements View.OnClickListener {
    //TODO: remove music when exit

    private androidx.constraintlayout.widget.ConstraintLayout myLayout = null;

    private Button btnAuto, btnPause, btnHist, btnNext;
    private Boolean allowedback;
    ImageView background, img_char;
    typewriter_effect txt_dlg,txt_A,txt_B,txt_C,txt_D;
    appRelated test;
    dialogueFlow crazy;
    int localvar;


    public game_Screen(){}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_screen);
        enableFullscreen();
        new dialogueFlow();
        Log.d(TAG, "scene one activated");
        allowedback = false;
        test= new appRelated();
        crazy = new dialogueFlow();
        localvar = 0;


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
        btnNext = findViewById(R.id.btn_next);

        txt_dlg = findViewById(R.id.txt_dlg);
        txt_A = findViewById(R.id.txt_A);
        txt_B = findViewById(R.id.txt_B);
        txt_C = findViewById(R.id.txt_C);
        txt_D = findViewById(R.id.txt_D);

        //im finding a way to input string in animate text

        background = findViewById(R.id.bg_image);
        img_char = findViewById(R.id.img_char);

        btnPause.setOnClickListener(this);
        btnAuto.setOnClickListener(this);
        btnNext.setOnClickListener(this);
        txt_A.setOnClickListener(this);
        txt_B.setOnClickListener(this);
        txt_C.setOnClickListener(this);
        txt_D.setOnClickListener(this);

    }
    @Override
    protected void onStart() {
        super.onStart();
        dialogueFlow.sceneone(img_char, txt_dlg, btnAuto, btnNext, this);
    }

    @Override
    public void onBackPressed() {
        if (allowedback) { super.onBackPressed(); }
        else { startActivity(new Intent(this, pause_screen.class)); } }

    public void onClick(View v) {
    switch (v.getId()) {
        case R.id.btn_Pause:
            startActivity(new Intent(game_Screen.this, pause_screen.class));
            break;
        case R.id.btn_auto:
            break;
        case R.id.btn_next:
            if (test.getDialoguenum()==0){
                test.setDialoguenum(1); Log.d(TAG, "new scene activated");
            }else {
            test.setDialoguenum(test.getDialoguenum()+1);}
            crazy.nextscene(test, img_char, background, txt_dlg, btnNext, this, txt_A, txt_B,txt_C,txt_D);
            break;
        case R.id.txt_A:
            crazy.actNxtBut_disQstBut(btnNext,txt_A,txt_B,txt_C,txt_D);
            Log.d(TAG, "btnA pressed");
            test.setChoicenum(1);
            crazy.nextResp(test,txt_dlg, test.getQuestionnum(),test.getChoicenum(),img_char);
            break;
        case R.id.txt_B:
            crazy.actNxtBut_disQstBut(btnNext,txt_A,txt_B,txt_C,txt_D);
            Log.d(TAG, "btnB pressed");
            test.setChoicenum(2);
            crazy.nextResp(test,txt_dlg, test.getQuestionnum(),test.getChoicenum(),img_char);
            break;
        case R.id.txt_C:
            crazy.actNxtBut_disQstBut(btnNext,txt_A,txt_B,txt_C,txt_D);
            Log.d(TAG, "btnC pressed");
            test.setChoicenum(3);
            crazy.nextResp(test,txt_dlg, test.getQuestionnum(),test.getChoicenum(),img_char);
            break;
        case R.id.txt_D:
            crazy.actNxtBut_disQstBut(btnNext,txt_A,txt_B,txt_C,txt_D);
            Log.d(TAG, "btnD pressed");
            test.setChoicenum(4);
            crazy.nextResp(test,txt_dlg, test.getQuestionnum(),test.getChoicenum(),img_char);
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
