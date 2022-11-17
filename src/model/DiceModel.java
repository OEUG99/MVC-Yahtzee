package model;

public class DiceModel {
    private int value;
    private int id;

    boolean isLocked = false;

    public DiceModel(int id) {
        roll(); // new dice are created with a random number.
        this.id = id;
    }

    public String getValue() {
        return Integer.toString(value);
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getId() {
        return id;
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
