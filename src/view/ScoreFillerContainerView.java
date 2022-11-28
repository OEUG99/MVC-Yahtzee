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

        // generate 15 TextFields for the user to fill in
        // each text field also has a tag associated with it, allign them
        // in a grid layout
        setLayout(new GridLayout(15, 2));

        //instanciate array
        scoreFillerArray = new ScoreFillerView[15];

        // Aces score filler
        scoreFillerArray[0] = new ScoreFillerView("Aces");
        add(scoreFillerArray[0]);
        // Twos score filler
        scoreFillerArray[1] = new ScoreFillerView("Twos");
        add(scoreFillerArray[1]);
        // Threes score filler
        scoreFillerArray[2] = new ScoreFillerView("Threes");
        add(scoreFillerArray[2]);
        // Fours score filler
        scoreFillerArray[3] = new ScoreFillerView("Fours");





    }
}
