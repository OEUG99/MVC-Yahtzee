package model;

public class ScoreModel {
    private int[] scoreArray;

    public ScoreModel() {
        this.scoreArray = new int[17];
    }

    public int getScoreArray(int i) {
        return scoreArray[i];
    }

    public void setArrayValue(int x, int y) {
        scoreArray[x] = y;
    }

    public void defaultScore() {
        for (int i = 0; i < 17; i++) {
            scoreArray[i] = -1;
        }
    }

}
