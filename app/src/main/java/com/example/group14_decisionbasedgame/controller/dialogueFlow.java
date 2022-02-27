package com.example.group14_decisionbasedgame.controller;

import android.content.Context;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.group14_decisionbasedgame.model.abmDialogue;
import com.example.group14_decisionbasedgame.model.appDialogue;
import com.example.group14_decisionbasedgame.model.humssdialogue;
import com.example.group14_decisionbasedgame.model.ictDialogue;
import com.example.group14_decisionbasedgame.model.mcDialogue;
import com.example.group14_decisionbasedgame.model.stemDialogue;

public class dialogueFlow {
    public dialogueFlow(){
        new mcDialogue();
        new stemDialogue();
        new humssdialogue();
        new abmDialogue();
        new ictDialogue();
        new appDialogue();
    }

    public static void sceneone(ImageView character, TextView dialogue, Button next){
        //TODO: test out how this single command should wait for input before moving on to the next dialogue
        //TODO: should map to scenetwo after this one is done
        //TODO: animation for characters when they fade in and fade out
        dialogue.setText(appDialogue.getD1_1());

    }
}
