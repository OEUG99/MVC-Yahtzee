package main.model;

import yahtzee.model.DiceModel;
import yahtzee.model.ScoreModel;

public class MainModel {

    public boolean fancyDiceMode = false;
    
    public ScoreModel[] scoreModels;

    public DiceModel[] dice = new DiceModel[5];

    public Boolean gameStarted = false;

    private int curPlayer;


    public MainModel() {

        for (int i = 0; i < 5; i++) {
            dice[i] = new DiceModel();
        }

    }

    public DiceModel getDice(int diceId) {
        // get the dice values
        return dice[diceId];
    }

    public boolean getFancyDiceMode(){
        return fancyDiceMode;
    }

    public void setFancyDiceMode(Boolean value){
        this.fancyDiceMode = value;
    }

    public int getCurPlayer() {
        return curPlayer;
    }

    public ScoreModel getScoreModel(int index) {
        return scoreModels[index];
    }
}
