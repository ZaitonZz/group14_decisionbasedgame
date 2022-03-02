package com.example.group14_decisionbasedgame.controller;

import java.util.TimerTask;

public class RemindTask extends TimerTask {
    public void run() {
        dialogueFlow.checkingdone(dialogueFlow.getWhy(),dialogueFlow.getLocalvar(),dialogueFlow.getDude(),dialogueFlow.getHelp(), dialogueFlow.getI(),dialogueFlow.getCant());

    }

}
