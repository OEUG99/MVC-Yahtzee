package model;

import java.util.Random;

public class MainModel {

    // some data structure that stores yahtzee scores. An array of x arrays
    // where x is the number of players. Each array contains 13 elements
    // representing the 13 possible scores, etc.
    private int[][] scores;

    public DiceModel [] dice = new DiceModel[5];


    public MainModel() {

        // Instantiate the dice
        for (int i = 0; i < 5; i++) {
            dice[i] = new DiceModel(i);
        }

    }

    public void setScore(int player, int score) {
        // set the score for the player and score
    }

    public int getScore(int player, int score) {
        // get the score for the player and score
        return 0;
    }

    public int getScore(int player) {
        // get the total score for the player
        return 0;
    }

    public int getScore() {
        // get the total score for all players
        return 0;
    }

    public void setPlayerName(int player, String name) {
        // set the name of the player
    }

    public String getPlayerName(int player) {
        // get the name of the player
        return "";
    }

    public void setPlayerCount(int count) {
        // set the number of players
    }

    public int getPlayerCount() {
        // get the number of players
        return 0;
    }

    public void setDice(int[] dice) {
        // set the dice values
    }

    public DiceModel getDice(int diceId) {
        // get the dice values
        return dice[diceId];
    }

    public void setDiceCount(int count) {
        // set the number of dice
    }

    public int getDiceCount() {
        // get the number of dice
        return 0;
    }

    public void setRollCount(int count) {
        // set the number of rolls
    }

    public int getRollCount() {
        // get the number of rolls
        return 0;
    }

    public void setRoll(int roll) {
        // set the current roll
    }

    public int getRoll() {
        // get the current roll
        return 0;
    }

    public void setPlayer(int player) {
        // set the current player
    }

    public int getPlayer() {
        // get the current player
        return 0;
    }
    public String getRandomNumber() {
        // return a random number between 1 and 6
        int ran = new Random().nextInt(6) + 1;
        return Integer.toString(ran);
    }
}
