package view;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame{

    private DiceContainerView diceContainerView;
    private JLabel scoreLabel;

    public MainView() {
        super("Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setLayout(new BorderLayout());

        this.diceContainerView = new DiceContainerView();
        add(diceContainerView, BorderLayout.SOUTH);

        // temp text that says Hello Yahtzee!
        scoreLabel = new JLabel("Hello Yahtzee!");
        scoreLabel.setHorizontalAlignment(JLabel.CENTER);
        scoreLabel.setVerticalAlignment(JLabel.CENTER);
        scoreLabel.setFont(new Font("Arial", Font.PLAIN, 50));
        add(scoreLabel, BorderLayout.CENTER);

    }

    public DiceContainerView getDiceContainer() {
        return diceContainerView;
    }

    public JLabel getScoreLabel() {
        return scoreLabel;
    }
}
