package model;

import java.util.Random;

public class MainModel {

    // Planned to be an array of x arrays where x is the
    // number of players, just one for now
    private ScoreModel [][] scores = new ScoreModel[17][1];

    public DiceModel [] dice = new DiceModel[5];


    public Boolean gameStarted = false;

    private int numPlayers;


    public MainModel() {

        // Instantiate the dice
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
    public String getRandomNumber() {
        // return a random number between 1 and 6
        int ran = new Random().nextInt(6) + 1;
        return Integer.toString(ran);
    }

    public String getSumOfAllDice() {
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += dice[i].getValueAsInt();
        }
        return Integer.toString(sum);
    }

    public int getNumPlayers() {
        return numPlayers;
    }
}
