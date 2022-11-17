package model;

import java.util.Random;

public class MainModel {

    // some data structure that stores yahtzee scores. An array of x arrays
    // where x is the number of players. Each array contains 13 elements
    // representing the 13 possible scores, etc.
    private int[][] scores;

    public DiceModel [] dice = new DiceModel[5];


    public Boolean gameStarted = false;


    public MainModel() {

        // Instantiate the dice
        for (int i = 0; i < 5; i++) {
            dice[i] = new DiceModel(i);
        }

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
}
