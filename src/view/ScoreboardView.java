package view;

import javax.swing.*;
import java.awt.*;

/**
 * This class contains all components used in the scoreboard section of the GUI.
 */
public class ScoreboardView extends JPanel {

    ScoreContainerView scoreContainer;


    public ScoreboardView() {
        super();
        this.setLayout(new GridBagLayout());
        setBackground(new Color(0xA4BE7B));
        setOpaque(true);
        GridBagConstraints ct = new GridBagConstraints();
        ct.gridx = 0;
        ct.gridy = 0;

        scoreContainer = new ScoreContainerView();
        scoreContainer.setBackground(new Color(0xE5D9B6));

        this.add(scoreContainer, ct);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public void updateSize(Dimension size) {
        setPreferredSize(size);
    }

    public void updateChildPanelSize(Dimension size) {
        scoreContainer.setPreferredSize(size);
        setPreferredSize(size);
    }

    public ScoreContainerView getScoreContainerView() {
        return scoreContainer;
    }

}
