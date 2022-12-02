package model;

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

    public void setNumPlayers(int val) {
        this.numPlayers = val;
        this.scoreModels = new ScoreModel[val];

        // initializing the arrays to -1 in each element
        for (int i = 0; i < val; i++) {
            scoreModels[i] = new ScoreModel();
            scoreModels[i].defaultScore();
        }
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

    public int getCurPlayer() {
        return curPlayer;
    }

    public ScoreModel getScoreModel(int index) {
        return scoreModels[index];
    }
}
