package view;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame{

    private DiceContainerView diceContainerView;
    private JLabel scoreLabel;

    public MainView() {
        super("Yahtzee");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Setting window size to size of monitor
        Dimension monitorSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(monitorSize.width, monitorSize.height);


        setLayout(new BorderLayout());

        this.diceContainerView = new DiceContainerView();
        add(diceContainerView, BorderLayout.SOUTH);

        scoreLabel = new JLabel("Welcome to Yahtzee!");
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
