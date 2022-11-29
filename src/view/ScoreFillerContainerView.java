package view;

import javax.swing.*;
import java.awt.*;

/**
 * This class is what the user will fill in to score their dice.
 * this is more of a temp class until we figure out multiple players etc.
 */
public class ScoreFillerContainerView extends JPanel {

        private ScoreFillerView[] scoreFillerArray;
public ScoreFillerContainerView() {
        super();
        this.setBackground(new Color(0xE5D9B6));

        // generate 17 TextFields for the user to fill in
        // each text field also has a tag associated with it
        // allign them in a grid layout
        setLayout(new GridLayout(17, 2));

        //instanciate array
        scoreFillerArray = new ScoreFillerView[17];

        // Aces score filler
        scoreFillerArray[0] = new ScoreFillerView("1. Aces");
        add(scoreFillerArray[0]);
        // Twos score filler
        scoreFillerArray[1] = new ScoreFillerView("2. Twos");
        add(scoreFillerArray[1]);
        // Threes score filler
        scoreFillerArray[2] = new ScoreFillerView("3. Threes");
        add(scoreFillerArray[2]);
        // Fours score filler
        scoreFillerArray[3] = new ScoreFillerView("4. Fours");
        add(scoreFillerArray[3]);
        scoreFillerArray[4] = new ScoreFillerView("5. Fives");
        add(scoreFillerArray[4]);
        scoreFillerArray[5] = new ScoreFillerView("6. Sixes");
        add(scoreFillerArray[5]);
        scoreFillerArray[6] = new ScoreFillerView("Top Bonus");
        add(scoreFillerArray[6]);
        scoreFillerArray[7] = new ScoreFillerView("Top Total");
        add(scoreFillerArray[7]);
        scoreFillerArray[8] = new ScoreFillerView("7. Three of a Kind");
        add(scoreFillerArray[8]);
        scoreFillerArray[9] = new ScoreFillerView("8. Four of a Kind");
        add(scoreFillerArray[9]);
        scoreFillerArray[10] = new ScoreFillerView("9. Full House");
        add(scoreFillerArray[10]);
        scoreFillerArray[11] = new ScoreFillerView("10. Small Straight");
        add(scoreFillerArray[11]);
        scoreFillerArray[12] = new ScoreFillerView("11. Large Straight");
        add(scoreFillerArray[12]);
        scoreFillerArray[13] = new ScoreFillerView("12. Yahtzee");
        add(scoreFillerArray[13]);
        scoreFillerArray[14] = new ScoreFillerView("13. Chance");
        add(scoreFillerArray[14]);
        scoreFillerArray[15] = new ScoreFillerView("Bottom Total");
        add(scoreFillerArray[15]);
        scoreFillerArray[16] = new ScoreFillerView("Grand Total");
        add(scoreFillerArray[16]);

    }
}
