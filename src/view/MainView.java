package view;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame{

    private DiceContainerView diceContainerView;
    private JLabel scoreLabel;
    private ScoreboardContainerView scoreboardContainerView;


    public MainView() {
        super("Yahtzee");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Setting window size to size of monitor:
        // TODO fix the bug caused by screen size != usable screen size (taskbar, etc.).
        Dimension monitorSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(monitorSize.width, monitorSize.height);


        // setting a minium size for the application, so we cant scale it below that point
        setMinimumSize(new Dimension(300, 300));



        setLayout(new BorderLayout());

        this.diceContainerView = new DiceContainerView();
        add(diceContainerView, BorderLayout.SOUTH);

        /*
        scoreLabel = new JLabel("Welcome to Yahtzee!");
        scoreLabel.setHorizontalAlignment(JLabel.CENTER);
        scoreLabel.setVerticalAlignment(JLabel.CENTER);
        scoreLabel.setFont(new Font("Arial", Font.PLAIN, 50));
        add(scoreLabel, BorderLayout.NORTH);

         */

        this.scoreboardContainerView = new ScoreboardContainerView();
        add(scoreboardContainerView, BorderLayout.CENTER);

    }

    public DiceContainerView getDiceContainer() {
        return diceContainerView;
    }

    public JLabel getScoreLabel() {
        return scoreLabel;
    }

    public ScoreboardContainerView getScoreboardContainer() {
        return scoreboardContainerView;
    }
}
