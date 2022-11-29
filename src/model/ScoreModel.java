package model;

public class ScoreModel {
    private int scoreValue;
    private int scoreId;
    private int playerNum;

    public ScoreModel(int scoreId, int playerNum) {
        calcScore();
        this.scoreId = scoreId;
        this.playerNum = playerNum;
    }

    public String getScoreValue() {
        return Integer.toString(scoreValue);
    }

    public int getScoreValueAsInt() {
        return scoreValue;
    }


    public void setValue(int scoreValue) {
        this.scoreValue = scoreValue;
    }

    public int getScoreId() {
        return scoreId;
    }

    public int getPlayerNum() {
        return playerNum;
    }

    // Temporary til I can figue out what 
    // exactly were putting here
    public void calcScore() {
        scoreValue = 0 ;
    }
}
