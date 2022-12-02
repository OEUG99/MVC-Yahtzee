package model;

import java.util.Random;

public class MainModel {

    public boolean fancyDiceMode = false;
    public ScoreModel[] scoreModels;


    public DiceModel [] dice = new DiceModel[5];


    public Boolean gameStarted = false;

    private int numPlayers;
    private int curPlayer;


    public MainModel() {

        for (int i = 0; i < 5; i++) {
            dice[i] = new DiceModel();
        }

    }

    public void setNumPlayers(int i) {
        this.numPlayers = i;
        this.scoreModels = new ScoreModel[i];
    }

    public DiceModel getDice(int diceId) {
        // get the dice values
        return dice[diceId];
    }

    public int getNumPlayers() {
        return numPlayers;
    }

    public boolean getFancyDiceMode(){
        return fancyDiceMode;
    }

    public void setFancyDiceMode(Boolean value){
        this.fancyDiceMode = value;
    }

    public void setCurPlayer(int i) {
        curPlayer = i;
    }

    public void nextPlayer(){
        curPlayer = (curPlayer + 1) % numPlayers;
    }

    public String getCurPlayer() {
        return Integer.toString(curPlayer);
    }
}
