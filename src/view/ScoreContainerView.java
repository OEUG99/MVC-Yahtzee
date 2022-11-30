package view;

import javax.swing.*;
import java.awt.*;

/**
 * This class is what the user will fill in to score their dice.
 * this is more of a temp class until we figure out multiple players etc.
 */
public class ScoreContainerView extends JPanel {

        private ScoreView[] scoreArray;

public ScoreContainerView() {
        super();
        this.setBackground(new Color(0xE5D9B6));
        setLayout(new GridLayout(17, 2));

        scoreArray = new ScoreView[17];
        scoreArray[0] = new ScoreView("1. Aces");
        add(scoreArray[0]);
        scoreArray[1] = new ScoreView("2. Twos");
        add(scoreArray[1]);
        scoreArray[2] = new ScoreView("3. Threes");
        add(scoreArray[2]);
        scoreArray[3] = new ScoreView("4. Fours");
        add(scoreArray[3]);
        scoreArray[4] = new ScoreView("5. Fives");
        add(scoreArray[4]);
        scoreArray[5] = new ScoreView("6. Sixes");
        add(scoreArray[5]);
        scoreArray[6] = new ScoreView("Top Bonus");
        add(scoreArray[6]);
        scoreArray[7] = new ScoreView("Top Total");
        add(scoreArray[7]);
        scoreArray[8] = new ScoreView("7. Three of a Kind");
        add(scoreArray[8]);
        scoreArray[9] = new ScoreView("8. Four of a Kind");
        add(scoreArray[9]);
        scoreArray[10] = new ScoreView("9. Full House");
        add(scoreArray[10]);
        scoreArray[11] = new ScoreView("10. Small Straight");
        add(scoreArray[11]);
        scoreArray[12] = new ScoreView("11. Large Straight");
        add(scoreArray[12]);
        scoreArray[13] = new ScoreView("12. Yahtzee");
        add(scoreArray[13]);
        scoreArray[14] = new ScoreView("13. Chance");
        add(scoreArray[14]);
        scoreArray[15] = new ScoreView("Bottom Total");
        add(scoreArray[15]);
        scoreArray[16] = new ScoreView("Grand Total");
        add(scoreArray[16]);

    }

    public ScoreView[] getScoreArray() {
        return scoreArray;
    }


}
