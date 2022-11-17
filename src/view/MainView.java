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

        scoreLabel = new JLabel(); // this will be updated by the main controller to put the dice total sum
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
