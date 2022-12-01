package view.game;

import javax.swing.*;
import java.awt.*;

/**
 * How the game gets scored.
 * this is more of a temp class until we figure out multiple players etc.
 */
public class ScoreView extends JPanel {
    private JButton scoreButton;
    private JLabel scoreButtonTag;

    public ScoreView(String tag) {
        super();
        setOpaque(false);
        setBackground(new Color(0xE5D9B6));
        setPreferredSize(new Dimension(150, 150));
        scoreButton = new JButton("Score here.");
        scoreButton.setEnabled(true);
        scoreButtonTag = new JLabel(tag);
        add(scoreButtonTag);
        add(scoreButton);
    }

    public void updateSize(Dimension scoreboxesSize) {
        setPreferredSize(scoreboxesSize);
    }

    public void updateFontSize(Dimension scoreButtonSize) {
        scoreButtonTag.setFont(new Font("Arial", Font.PLAIN, (int) (scoreButtonSize.height / 2.5)));
        // scale vertically and horizontally
        scoreButton.setPreferredSize(new Dimension(scoreButtonSize.width / 3, scoreButtonSize.height / 3));
    }

    public JButton getScoreButton() {
        return scoreButton;
    }
}
