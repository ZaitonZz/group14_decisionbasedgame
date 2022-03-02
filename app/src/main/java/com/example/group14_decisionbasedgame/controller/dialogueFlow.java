package com.example.group14_decisionbasedgame.controller;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.group14_decisionbasedgame.R;
import com.example.group14_decisionbasedgame.model.abmDialogue;
import com.example.group14_decisionbasedgame.model.appRelated;
import com.example.group14_decisionbasedgame.model.humssdialogue;
import com.example.group14_decisionbasedgame.model.ictDialogue;
import com.example.group14_decisionbasedgame.model.mcDialogue;
import com.example.group14_decisionbasedgame.model.stemDialogue;

public class dialogueFlow {
    static int localint;
    public dialogueFlow(){
        new mcDialogue();
        new stemDialogue();
        new humssdialogue();
        new abmDialogue();
        new ictDialogue();
        new appRelated();
    }

    public static void sceneone(ImageView character, typewriter_effect dialogue, Button auto, Button skip_next, Context context){
        //TODO: test out how this single command should wait for input before moving on to the next dialogue
        //TODO: should map to scenetwo after this one is done
        //TODO: animation for characters when they fade in and fade out
        musicRelated.strtstem_main(context);
        dialogue.setText(appRelated.getD1_1());
        dialogue.setCharacterDelay(50);
        dialogue.animateText(appRelated.getD1_1());
    }
    public void nextscene(appRelated test, ImageView character, ImageView background, typewriter_effect dialogue, Button next, Context context, typewriter_effect A, typewriter_effect B, typewriter_effect C, typewriter_effect D) {
      switch(test.getScenenum()){
          case 1:
              actNxtBut_disQstBut(next, A, B, C, D);
              dialogue.setText(appRelated.getD1_2());
              dialogue.setCharacterDelay(50);
              dialogue.animateText(appRelated.getD1_2());
              break;
          case 2:
              dialogue.setText(appRelated.getD1_3());
              dialogue.setCharacterDelay(50);
              dialogue.animateText(appRelated.getD1_3());
              break;
          case 3:
              background.setImageResource(R.drawable.hallway);
              dialogue.setText(appRelated.getD2_1());
              dialogue.setCharacterDelay(50);
              dialogue.animateText(appRelated.getD2_1());
              break;
          case 4:
              character.setImageResource(R.drawable.abmtwo);
              character.setVisibility(character.VISIBLE);
              musicRelated.stop_gScreen_music();
              musicRelated.strtabm_main(context);
              dialogue.setText(abmDialogue.getA2_1());
              dialogue.setCharacterDelay(50);
              dialogue.animateText(abmDialogue.getA2_1());
              break;
          case 5:
              dialogue.setText(mcDialogue.getM2_1());
              dialogue.setCharacterDelay(50);
              dialogue.animateText(mcDialogue.getM2_1());
              break;
          case 6:
              dialogue.setText(abmDialogue.getA2_2());
              dialogue.setCharacterDelay(50);
              dialogue.animateText(abmDialogue.getA2_2());
              break;
          case 7:
              background.setImageResource(R.drawable.classroom);
              character.setVisibility(character.INVISIBLE);
              dialogue.setText(appRelated.getD3_1());
              dialogue.setCharacterDelay(50);
              dialogue.animateText(appRelated.getD3_1());
              break;
          case 8:
              dialogue.setText(appRelated.getD3_2());
              dialogue.setCharacterDelay(50);
              dialogue.animateText(appRelated.getD3_2());
              break;
          case 9:
              background.setImageResource(R.drawable.hallway);
              dialogue.setText(appRelated.getD4_1());
              dialogue.setCharacterDelay(50);
              dialogue.animateText(appRelated.getD4_1());
              break;
          case 10:
              dialogue.setText(appRelated.getD4_2());
              dialogue.setCharacterDelay(50);
              dialogue.animateText(appRelated.getD4_2());
              break;
          case 11:
              character.setImageResource(R.drawable.stemtwo);
              character.setVisibility(character.VISIBLE);
              musicRelated.stop_gScreen_music();
              musicRelated.strtstem_secondary(context);
              dialogue.setText(stemDialogue.getS4_1());
              dialogue.setCharacterDelay(50);
              dialogue.animateText(stemDialogue.getS4_1());
              break;
          case 12:
              dialogue.setText(mcDialogue.getM4_1());
              dialogue.setCharacterDelay(50);
              dialogue.animateText(mcDialogue.getM4_1());
              break;
          case 13:
              disNxtBut_actQstBut(next, A, B, C, D);
              dialogue.setText(appRelated.getD4_3());
              dialogue.setCharacterDelay(50);
              dialogue.animateText(appRelated.getD4_3());
              localint = 1;
              test.setQuestionnum(localint);
              nextquestion(test, A, B, C, D);
              break;
          case 14:
              switch (test.getChoicenum()){
                  case 1:
                      dialogue.setText(stemDialogue.getR1_1());
                      dialogue.setCharacterDelay(50);
                      dialogue.animateText(stemDialogue.getR1_1());
                      break;
                  case 2:
                      switch(test.getChoicenumbuffer()){
                          case 2:
                              dialogue.setText(appRelated.getQ1_B_1());
                              dialogue.setCharacterDelay(50);
                              dialogue.animateText(appRelated.getQ1_B_1());
                              test.setChoicenumbuffer(1);
                              test.setScenenum(13);
                              break;
                          case 1:
                              dialogue.setText(mcDialogue.getRB_1());
                              dialogue.setCharacterDelay(50);
                              dialogue.animateText(mcDialogue.getRB_1());
                      }

                      break;
                  case 3:
                      dialogue.setText(appRelated.getQ1_C_1());
                      dialogue.setCharacterDelay(50);
                      dialogue.animateText(appRelated.getQ1_C_1());
                      break;
                  case 4:
                      dialogue.setText(stemDialogue.getR1_1());
                      dialogue.setCharacterDelay(50);
                      dialogue.animateText(stemDialogue.getR1_1()); //TODO:
                      break;
              }
              break;
          case 15:
              break;
          case 16:
              break;
          case 17:
              break;
          case 18:
              break;
          case 19:
              break;
          case 20:
              break;
      }
    }
    public void nextquestion(appRelated test, typewriter_effect A, typewriter_effect B, typewriter_effect C, typewriter_effect D){
        switch (test.getQuestionnum()){
            case 1:
                A.setText(appRelated.getQ1_A());
                A.setCharacterDelay(0);
                A.animateText(appRelated.getQ1_A());
                B.setText(appRelated.getQ1_B());
                B.setCharacterDelay(0);
                B.animateText(appRelated.getQ1_B());
                C.setText(appRelated.getQ1_C());
                C.setCharacterDelay(0);
                C.animateText(appRelated.getQ1_C());
                D.setText(appRelated.getQ1_D());
                D.setCharacterDelay(0);
                D.animateText(appRelated.getQ1_D());
                displayAns(A, B, C, D);
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
        }
    }

    public static void nextResp(typewriter_effect dialogue,int qnum, int choicenum){
        switch (qnum){
            case 1:
                switch (choicenum){
                    case 1:
                        dialogue.setText(mcDialogue.getR1_1());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(mcDialogue.getR1_1());
                    case 2:
                        dialogue.setText(mcDialogue.getR1_2());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(mcDialogue.getR1_2());
                    case 3:
                        dialogue.setText(mcDialogue.getR1_3());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(mcDialogue.getR1_3());
                    case 4:
                        dialogue.setText(mcDialogue.getR1_1()); //TODO: route 4 shenanigans
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(mcDialogue.getR1_1());
                }
            case 2:
        }
    }
    public static void disNxtBut_actQstBut(Button next, TextView a, TextView b, TextView c, TextView d) {
        next.setEnabled(false);
        a.setEnabled(true);
        b.setEnabled(true);
        c.setEnabled(true);
        d.setEnabled(true);
    }
    public static void actNxtBut_disQstBut(Button next, TextView a, TextView b, TextView c, TextView d) {
        next.setEnabled(true);
        a.setEnabled(false);
        b.setEnabled(false);
        c.setEnabled(false);
        d.setEnabled(false);
    }
    public static void displayAns(typewriter_effect A, typewriter_effect B, typewriter_effect C, typewriter_effect D){
        A.setVisibility(A.VISIBLE);
        B.setVisibility(B.VISIBLE);
        C.setVisibility(C.VISIBLE);
        D.setVisibility(D.VISIBLE);
    }
    public static void hideAns(typewriter_effect A, typewriter_effect B, typewriter_effect C, typewriter_effect D){
        A.setVisibility(A.INVISIBLE);
        B.setVisibility(B.INVISIBLE);
        C.setVisibility(C.INVISIBLE);
        D.setVisibility(D.INVISIBLE);
    }
}