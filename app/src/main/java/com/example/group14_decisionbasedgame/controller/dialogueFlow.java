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
        switch (test.getScenenum()) {
            case 0: //scene 1 until 1st question
                switch (test.getDialoguenum()) {
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
                        dialogue.setText(appRelated.getD4_3());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(appRelated.getD4_3());
                        localint = 1;
                        test.setQuestionnum(localint);
                        nextquestion(test, next, A, B, C, D);
                        break;
                    case 14: //question 1 determiner of routes
                        hideAns(A, B, C, D);
                        switch (test.getChoicenum()) {
                            case 1:
                                character.setVisibility(character.VISIBLE);
                                dialogue.setText(stemDialogue.getR1_1());
                                dialogue.setCharacterDelay(50);
                                dialogue.animateText(stemDialogue.getR1_1());
                                test.setScenenum(1);
                                test.setDialoguenum(0);
                                break;
                            case 2:
                                switch (test.getChoicenumbuffer()) {
                                    case 2:
                                        dialogue.setText(appRelated.getQ1_B_1());
                                        dialogue.setCharacterDelay(50);
                                        dialogue.animateText(appRelated.getQ1_B_1());
                                        test.setChoicenumbuffer(1);
                                        test.setDialoguenum(13);
                                        break;
                                    case 1:
                                        dialogue.setText(mcDialogue.getRB_1());
                                        dialogue.setCharacterDelay(50);
                                        dialogue.animateText(mcDialogue.getRB_1());
                                        test.setScenenum(1);
                                        test.setDialoguenum(0);
                                        break;
                                }
                                break;
                            case 3:
                                switch (test.getChoicenumbuffer()) {
                                    case 2:
                                        dialogue.setText(appRelated.getQ1_C_1());
                                        dialogue.setCharacterDelay(50);
                                        dialogue.animateText(appRelated.getQ1_C_1());
                                        test.setChoicenumbuffer(1);
                                        test.setDialoguenum(13);
                                        break;
                                    case 1:
                                        dialogue.setText(appRelated.getQ1_C_2());
                                        dialogue.setCharacterDelay(50);
                                        dialogue.animateText(appRelated.getQ1_C_2());
                                        test.setScenenum(1);
                                        test.setDialoguenum(2);
                                        break;
                                }
                                break;
                            case 4:
                                test.setScenenum(2);
                                test.setDialoguenum(1);
                                break;
                        }
                        break;
                }
                break;
            case 1: //route 1-3
                Log.d(TAG, "Route 1 activated");
                switch (test.getDialoguenum()) {
                    case 1:
                        character.setVisibility(character.INVISIBLE);
                        dialogue.setText(appRelated.getD5_1());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(appRelated.getD5_1());
                        break;
                    case 2:
                        dialogue.setText(appRelated.getD5_2());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(appRelated.getD5_2());
                        break;
                    case 3:
                        dialogue.setText(abmDialogue.getA5_1());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(abmDialogue.getA5_1());
                        break;
                    case 4:
                        dialogue.setText(humssdialogue.getH5_1());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(humssdialogue.getH5_1());
                        break;
                    case 5:
                        dialogue.setText(ictDialogue.getI5_1());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(ictDialogue.getI5_1());
                        break;
                    case 6:
                        dialogue.setText(stemDialogue.getS5_1());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(stemDialogue.getS5_1());
                        break;
                    case 7:
                        dialogue.setText(mcDialogue.getM5_1());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(mcDialogue.getM5_1());
                        break;
                    case 8:
                        dialogue.setText(appRelated.getD5_3());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(appRelated.getD5_3());
                        break;
                    case 9:
                        dialogue.setText(mcDialogue.getM5_2());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(mcDialogue.getM5_2());
                        break;
                    case 10:
                        dialogue.setText(abmDialogue.getA5_2());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(abmDialogue.getA5_2());
                        break;
                    case 11:
                        dialogue.setText(stemDialogue.getS5_2());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(stemDialogue.getS5_2());
                        break;
                    case 12:
                        dialogue.setText(appRelated.getD5_4());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(appRelated.getD5_4());
                        break;
                    case 13:
                        dialogue.setText(humssdialogue.getH5_2());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(humssdialogue.getH5_2());
                        break;
                    case 14:
                        dialogue.setText(appRelated.getD5_5());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(appRelated.getD5_5());
                        break;
                    case 15:
                        dialogue.setText(ictDialogue.getI5_2());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(ictDialogue.getI5_2());
                        break;
                    case 16:
                        dialogue.setText(appRelated.getD5_6());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(appRelated.getD5_6());
                        break;
                    case 17:
                        dialogue.setText(appRelated.getD5_7());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(appRelated.getD5_7());
                        break;
                    case 18:
                        dialogue.setText(abmDialogue.getA5_3());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(abmDialogue.getA5_3());
                        break;
                    case 19:
                        dialogue.setText(appRelated.getD5_8());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(appRelated.getD5_8());
                        break;
                    case 20:
                        dialogue.setText(stemDialogue.getS5_3());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(stemDialogue.getS5_3());
                        break;
                    case 21:
                        dialogue.setText(stemDialogue.getS5_4());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(stemDialogue.getS5_4());
                        break;
                    case 22:
                        dialogue.setText(abmDialogue.getA5_4());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(abmDialogue.getA5_4());
                        break;
                    case 23:
                        dialogue.setText(stemDialogue.getS5_5());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(stemDialogue.getS5_5());
                        break;
                    case 24:
                        dialogue.setText(appRelated.getD5_9());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(appRelated.getD5_9());
                        break;
                    case 25:
                        dialogue.setText(appRelated.getD5_10());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(appRelated.getD5_10());
                        break;
                    case 26:
                        dialogue.setText(appRelated.getD5_11());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(appRelated.getD5_11());
                        break;
                    case 27:
                        dialogue.setText(appRelated.getD5_12());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(appRelated.getD5_12());
                        break;
                    case 28:
                        dialogue.setText(appRelated.getD5_13());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(appRelated.getD5_13());
                        localint = 2;
                        test.setQuestionnum(localint);
                        nextquestion(test, next, A, B, C, D);
                        break;
                    case 29:
                        hideAns(A, B, C, D);
                        switch (test.getChoicenum()) {
                            case 1:
                                dialogue.setText(stemDialogue.getR2_4());
                                dialogue.setCharacterDelay(50);
                                dialogue.animateText(stemDialogue.getR2_4());
                                break;
                            case 2:
                                dialogue.setText(stemDialogue.getR2_2());
                                dialogue.setCharacterDelay(50);
                                dialogue.animateText(stemDialogue.getR2_2());
                                break;
                            case 3:
                                dialogue.setText(stemDialogue.getR2_3());
                                dialogue.setCharacterDelay(50);
                                dialogue.animateText(stemDialogue.getR2_3());
                                break;
                            case 4:
                                dialogue.setText(stemDialogue.getR2_4());
                                dialogue.setCharacterDelay(50);
                                dialogue.animateText(stemDialogue.getR2_4());
                                break;
                        }
                        break;
                    case 30:
                        dialogue.setText(humssdialogue.getH5_3());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(humssdialogue.getH5_3());
                        break;
                    case 31:
                        dialogue.setText(ictDialogue.getI5_3());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(ictDialogue.getI5_3());
                        break;
                    case 32:
                        dialogue.setText(abmDialogue.getA5_5());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(abmDialogue.getA5_5());
                        break;
                    case 33:
                        dialogue.setText(mcDialogue.getM5_3());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(mcDialogue.getM5_3());
                        break;
                    case 34:
                        dialogue.setText(mcDialogue.getM5_4());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(mcDialogue.getM5_4());
                        break;
                    case 35:
                        dialogue.setText(stemDialogue.getS5_7());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(stemDialogue.getS5_7());
                        break;
                    case 36:
                        dialogue.setText(stemDialogue.getS5_8());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(stemDialogue.getS5_8());
                        break;
                    case 37:
                        dialogue.setText(stemDialogue.getS5_9());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(stemDialogue.getS5_9());
                        break;
                    case 38:
                        dialogue.setText(mcDialogue.getM5_5());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(mcDialogue.getM5_5());
                        break;
                    case 39:
                        dialogue.setText(mcDialogue.getM5_6());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(mcDialogue.getM5_6());
                        break;
                    case 40:
                        dialogue.setText(stemDialogue.getS5_10());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(stemDialogue.getS5_10());
                        break;
                    case 41:
                        dialogue.setText(stemDialogue.getS5_11());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(stemDialogue.getS5_11());
                        break;
                    case 42:
                        dialogue.setText(appRelated.getD5_14());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(appRelated.getD5_14());
                        break;
                    case 43:
                        dialogue.setText(appRelated.getD6_2());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(appRelated.getD6_2());
                        break;
                    case 44:
                        dialogue.setText(appRelated.getD6_3());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(appRelated.getD6_3());
                        break;
                    case 45:
                        dialogue.setText(appRelated.getD6_4());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(appRelated.getD6_4());
                        localint = 3;
                        test.setQuestionnum(localint);
                        nextquestion(test, next, A, B, C, D);
                        break;
                    case 46:
                        hideAns(A, B, C, D);
                        dialogue.setText(humssdialogue.getH6_2());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(humssdialogue.getH6_2());
                        break;
                    case 47:
                        dialogue.setText(humssdialogue.getH6_3());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(humssdialogue.getH6_3());
                        break;
                    case 48:
                        dialogue.setText(appRelated.getD6_5());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(appRelated.getD6_5());
                        break;
                    case 49:
                        dialogue.setText(appRelated.getD6_6());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(appRelated.getD6_6());
                        break;
                    case 50:
                        dialogue.setText(stemDialogue.getS6_2());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(stemDialogue.getS6_2());
                        break;
                    case 51:
                        dialogue.setText(stemDialogue.getS6_3());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(stemDialogue.getS6_3());
                        break;
                    case 52:
                        dialogue.setText(appRelated.getD6_7());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(appRelated.getD6_7());
                        break;
                    case 53:
                        switch (test.getChoicenum()) {
                            case 1:
                                dialogue.setText(mcDialogue.getR3_1());
                                dialogue.setCharacterDelay(50);
                                dialogue.animateText(mcDialogue.getR3_1());
                                break;
                            case 2:
                                dialogue.setText(mcDialogue.getR3_2());
                                dialogue.setCharacterDelay(50);
                                dialogue.animateText(mcDialogue.getR3_2());
                                break;
                            case 3:
                                dialogue.setText(mcDialogue.getR3_3());
                                dialogue.setCharacterDelay(50);
                                dialogue.animateText(mcDialogue.getR3_3());
                                break;
                            case 4:
                                dialogue.setText(mcDialogue.getR3_4());
                                dialogue.setCharacterDelay(50);
                                dialogue.animateText(mcDialogue.getR3_4());
                                break;
                        }
                    case 54:
                        dialogue.setText(appRelated.getD6_8());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(appRelated.getD6_8());
                        break;
                    case 55:
                        dialogue.setText(stemDialogue.getS6_4());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(stemDialogue.getS6_4());
                        break;
                    case 56:
                        dialogue.setText(ictDialogue.getI6_2());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(ictDialogue.getI6_2());
                        break;
                    case 57:
                        dialogue.setText(ictDialogue.getI6_3());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(ictDialogue.getI6_3());
                        break;
                    case 58:
                        dialogue.setText(appRelated.getD6_9());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(appRelated.getD6_9());
                        break;
                    case 59:
                        dialogue.setText(stemDialogue.getS6_5());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(stemDialogue.getS6_5());
                        break;
                    case 60:
                        dialogue.setText(stemDialogue.getS6_6());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(stemDialogue.getS6_6());
                        break;
                    case 61:
                        dialogue.setText(appRelated.getD6_10());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(appRelated.getD6_10());
                        break;
                    case 62:
                        dialogue.setText(appRelated.getD6_11());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(appRelated.getD6_11());
                        break;
                    case 63:
                        dialogue.setText(appRelated.getD6_12());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(appRelated.getD6_12());
                        break;
                    case 64:
                        dialogue.setText(stemDialogue.getST_1());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(stemDialogue.getST_1());
                        break;
                    case 65:
                        dialogue.setText(mcDialogue.getMT_1());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(mcDialogue.getMT_1());
                        break;
                    case 66:
                        dialogue.setText(stemDialogue.getST_2());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(stemDialogue.getST_2());
                        break;
                    case 67:
                        dialogue.setText(stemDialogue.getST_3());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(stemDialogue.getST_3());
                        break;
                    case 68:
                        dialogue.setText(mcDialogue.getMT_2());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(mcDialogue.getMT_2());
                        break;
                    case 69:
                        dialogue.setText(mcDialogue.getMT_3());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(mcDialogue.getMT_3());
                        break;
                    case 70:
                        dialogue.setText(stemDialogue.getST_4());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(stemDialogue.getST_4());
                        break;
                    case 71:
                        dialogue.setText(appRelated.getT1_1());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(appRelated.getT1_1());
                        break;
                    case 72:
                        dialogue.setText(appRelated.getD7_1());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(appRelated.getD7_1());
                        break;
                    case 73:
                        dialogue.setText(appRelated.getD7_2());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(appRelated.getD7_2());
                        break;
                    case 74:
                        dialogue.setText(abmDialogue.getA7_1());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(abmDialogue.getA7_1());
                        break;
                    case 75:
                        dialogue.setText(appRelated.getD7_3());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(appRelated.getD7_3());
                        break;
                    case 76:
                        dialogue.setText(abmDialogue.getA7_2());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(abmDialogue.getA7_2());
                        break;
                    case 77:
                        dialogue.setText(appRelated.getD7_4());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(appRelated.getD7_4());
                        break;
                    case 78:
                        dialogue.setText(stemDialogue.getS7_1());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(stemDialogue.getS7_1());
                        break;
                    case 79:
                        dialogue.setText(appRelated.getD7_5());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(appRelated.getD7_5());
                        break;
                }
                break;
            case 2:
                Log.d(TAG, "Route 4 activated");
                switch (test.getDialoguenum()) {
                    case 1:
                        dialogue.setText(appRelated.getRt4Dlg1());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(appRelated.getRt4Dlg1());
                        break;
                    case 2:
                        dialogue.setText(ictDialogue.getRt4Ict1());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(ictDialogue.getRt4Ict1());
                        break;
                    case 3:
                        dialogue.setText(mcDialogue.getRt4mc1());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(mcDialogue.getRt4mc1());
                        break;
                    case 4:
                        dialogue.setText(ictDialogue.getRt4Ict2());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(ictDialogue.getRt4Ict2());
                        break;
                    case 5:
                        dialogue.setText(ictDialogue.getRt4choices());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(ictDialogue.getRt4choices());
                        break;
                    case 6:
                        dialogue.setText(mcDialogue.getRt4mc1_2());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(mcDialogue.getRt4mc1_2());
                        break;
                    case 7:
                        dialogue.setText(ictDialogue.getRt4Ict3());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(ictDialogue.getRt4Ict3());
                        break;
                    case 8:
                        dialogue.setText(mcDialogue.getRt4mc2());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(mcDialogue.getRt4mc2());
                        localint = 4;
                        test.setQuestionnum(localint);
                        nextquestion(test, next, A, B, C, D);
                        break;
                    case 9:
                        hideAns(A, B, C, D);
                        switch (test.getChoicenum()) {
                            case 1:
                                dialogue.setText(mcDialogue.getRt4mc3_A());
                                dialogue.setCharacterDelay(50);
                                dialogue.animateText(mcDialogue.getRt4mc3_A());
                                break;
                            case 2:
                                dialogue.setText(mcDialogue.getRt4mc3_B());
                                dialogue.setCharacterDelay(50);
                                dialogue.animateText(mcDialogue.getRt4mc3_B());
                                test.setDialoguenum(10);
                                break;
                            case 3:
                                dialogue.setText(mcDialogue.getRt4mc3_C());
                                dialogue.setCharacterDelay(50);
                                dialogue.animateText(mcDialogue.getRt4mc3_C());
                                test.setDialoguenum(10);
                                break;
                            case 4:
                                dialogue.setText(mcDialogue.getRt4mc3_D());
                                dialogue.setCharacterDelay(50);
                                dialogue.animateText(mcDialogue.getRt4mc3_D());
                                test.setDialoguenum(10);
                                break;
                        }
                        break;
                    case 10:
                        dialogue.setText(ictDialogue.getRt4Ict4());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(ictDialogue.getRt4Ict4());
                        break;
                    case 11:
                        dialogue.setText(ictDialogue.getRt4Ict5());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(ictDialogue.getRt4Ict5());
                        localint = 5;
                        test.setQuestionnum(localint);
                        nextquestion(test, next, A, B, C, D);
                        break;
                    case 12:
                        hideAns(A, B, C, D);
                        switch (test.getChoicenum()) {
                            case 1:
                                dialogue.setText(mcDialogue.getRt4mc4_A());
                                dialogue.setCharacterDelay(50);
                                dialogue.animateText(mcDialogue.getRt4mc4_A());
                                break;
                            case 2:
                                dialogue.setText(mcDialogue.getRt4mc4_B());
                                dialogue.setCharacterDelay(50);
                                dialogue.animateText(mcDialogue.getRt4mc4_B());
                                break;
                            case 3:
                                dialogue.setText(mcDialogue.getRt4mc4_C());
                                dialogue.setCharacterDelay(50);
                                dialogue.animateText(mcDialogue.getRt4mc4_C());
                                break;
                            case 4:
                                dialogue.setText(mcDialogue.getRt4mc4_D());
                                dialogue.setCharacterDelay(50);
                                dialogue.animateText(mcDialogue.getRt4mc4_D());
                                break;
                        }
                        break;
                    case 13:
                        dialogue.setText(ictDialogue.getRt4Ict6());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(ictDialogue.getRt4Ict6());
                        break;
                    case 14:
                        dialogue.setText(appRelated.getRt4N1());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(appRelated.getRt4N1());
                        break;
                    case 15:
                    dialogue.setText(appRelated.getRt4Dlg2());
                    dialogue.setCharacterDelay(50);
                    dialogue.animateText(appRelated.getRt4Dlg2());
                    break;
                    case 16:
                        dialogue.setText(ictDialogue.getRt4Ict7());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(ictDialogue.getRt4Ict7());
                        break;
                    case 17:


                }
        }
    }
    public void nextquestion(appRelated test,Button next, typewriter_effect A, typewriter_effect B, typewriter_effect C, typewriter_effect D){
        disNxtBut_actQstBut(next, A, B, C, D);
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
                A.setText(appRelated.getQ2_A());
                A.setCharacterDelay(0);
                A.animateText(appRelated.getQ2_A());
                B.setText(appRelated.getQ2_B());
                B.setCharacterDelay(0);
                B.animateText(appRelated.getQ2_B());
                C.setText(appRelated.getQ2_C());
                C.setCharacterDelay(0);
                C.animateText(appRelated.getQ2_C());
                D.setText(appRelated.getQ2_D());
                D.setCharacterDelay(0);
                D.animateText(appRelated.getQ2_D());
                displayAns(A, B, C, D);
                break;
            case 3:
                A.setText(appRelated.getQ3_A());
                A.setCharacterDelay(0);
                A.animateText(appRelated.getQ3_A());
                B.setText(appRelated.getQ3_B());
                B.setCharacterDelay(0);
                B.animateText(appRelated.getQ3_B());
                C.setText(appRelated.getQ3_C());
                C.setCharacterDelay(0);
                C.animateText(appRelated.getQ3_C());
                D.setText(appRelated.getQ3_D());
                D.setCharacterDelay(0);
                D.animateText(appRelated.getQ3_D());
                displayAns(A, B, C, D);
                break;
            case 4:
                A.setText(appRelated.getRt4_Q1_A());
                A.setCharacterDelay(0);
                A.animateText(appRelated.getRt4_Q1_A());
                B.setText(appRelated.getRt4_Q1_B());
                B.setCharacterDelay(0);
                B.animateText(appRelated.getRt4_Q1_B());
                C.setText(appRelated.getRt4_Q1_C());
                C.setCharacterDelay(0);
                C.animateText(appRelated.getRt4_Q1_C());
                D.setText(appRelated.getRt4_Q1_D());
                D.setCharacterDelay(0);
                D.animateText(appRelated.getRt4_Q1_D());
                displayAns(A, B, C, D);
                break;
            case 5:
                A.setText(appRelated.getRt4_Q2_A());
                A.setCharacterDelay(0);
                A.animateText(appRelated.getRt4_Q2_A());
                B.setText(appRelated.getRt4_Q2_B());
                B.setCharacterDelay(0);
                B.animateText(appRelated.getRt4_Q2_B());
                C.setText(appRelated.getRt4_Q2_C());
                C.setCharacterDelay(0);
                C.animateText(appRelated.getRt4_Q2_C());
                D.setText(appRelated.getRt4_Q2_D());
                D.setCharacterDelay(0);
                D.animateText(appRelated.getRt4_Q2_D());
                displayAns(A, B, C, D);
                break;


        }
    }

    public static void nextResp(appRelated test,typewriter_effect dialogue,int qnum, int choicenum, ImageView character){
        switch (qnum){
            case 1:
                character.setVisibility(character.INVISIBLE);
                switch (choicenum){
                    case 1:
                        Log.d(TAG, "question 1 case 1");
                        dialogue.setText(mcDialogue.getR1_1());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(mcDialogue.getR1_1());
                        break;
                    case 2:
                        Log.d(TAG, "question 1 case 2");
                        test.setChoicenumbuffer(2);
                        dialogue.setText(mcDialogue.getR1_2());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(mcDialogue.getR1_2());
                        break;
                    case 3:
                        Log.d(TAG, "question 1 case 3");
                        test.setChoicenumbuffer(2);
                        dialogue.setText(mcDialogue.getR1_3());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(mcDialogue.getR1_3());
                        break;
                    case 4:
                        Log.d(TAG, "question 1 case 4");
                        dialogue.setText(appRelated.getRt4Dlg1());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(appRelated.getRt4Dlg1());
                        break;
                }
                break;
            case 2:
                switch (choicenum){
                    case 1:
                        Log.d(TAG, "question 2 case 1");
                        dialogue.setText(mcDialogue.getR2_1());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(mcDialogue.getR2_1());
                        break;
                    case 2:
                        Log.d(TAG, "question 2 case 2");
                        dialogue.setText(mcDialogue.getR2_2());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(mcDialogue.getR2_2());
                        break;
                    case 3:
                        Log.d(TAG, "question 2 case 3");
                        dialogue.setText(mcDialogue.getR2_3());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(mcDialogue.getR2_3());
                        break;
                    case 4:
                        Log.d(TAG, "question 2 case 4");
                        dialogue.setText(mcDialogue.getR2_4());
                        dialogue.setCharacterDelay(50);
                        dialogue.animateText(mcDialogue.getR2_4());
                        break;
                }
                break;
            case 3:
                dialogue.setText(stemDialogue.getS6_1());
                dialogue.setCharacterDelay(50);
                dialogue.animateText(stemDialogue.getS6_1());
                break;
            case 4:
                break;
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