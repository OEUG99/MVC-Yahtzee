package model;

import java.util.Random;

public class MainModel {

    public boolean fancyDiceMode = false;
    // Planned to be an array of x arrays where x is the
    // number of players, just one for now
    private ScoreModel [][] scores = new ScoreModel[17][1];


    public DiceModel [] dice = new DiceModel[5];


    public Boolean gameStarted = false;

    private int numPlayers;
    private int curPlayer;


    public MainModel() {

        for (int i = 0; i < 5; i++) {
            dice[i] = new DiceModel(i);
        }

    }

    public void setNumPlayers(int i) {
        this.numPlayers = i;
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
