package yahtzee.model;

public class DiceModel {
    private int value;
    boolean isLocked = false;

    public DiceModel() {
        roll();
    }

    public String getValue() {
        return Integer.toString(value);
    }

    public void roll() {
        if (!isLocked) {
            value = (int) (Math.random() * 6) + 1;
        }
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean isLocked) {
        this.isLocked = isLocked;
    }
}
