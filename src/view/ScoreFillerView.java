package view;

import javax.swing.*;

/**
 * How the game gets scored.
 * this is more of a temp class until we figure out multiple players etc.
 */
public class ScoreFillerView extends JPanel {
    private JTextField scoreFiller;
    private JLabel scoreFillerTag;

    public ScoreFillerView(String tag) {
        super();
        setOpaque(false);
        scoreFiller = new JTextField("    ");
        scoreFiller.setEditable(false);
        scoreFillerTag = new JLabel(tag);
        add(scoreFillerTag);
        add(scoreFiller);
    }

    public JTextField getScoreFiller() {
        return scoreFiller;
    }

    public JLabel getScoreFillerTag() {
        return scoreFillerTag;
    }
}
