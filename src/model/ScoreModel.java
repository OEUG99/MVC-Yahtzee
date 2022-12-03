package model;

public class ScoreModel {
    private int[] scoreArray;

    public ScoreModel() {
        this.scoreArray = new int[17];
    }

    public void setArrayValue(int x, int y) {
        scoreArray[x] = y;
    }
}
