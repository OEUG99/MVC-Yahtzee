package view;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame{

    private DiceContainerView diceContainerView;
    private JLabel scoreLabel;
    private ScoreboardView scoreboardView;


    public MainView() {
        super("Yahtzee");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Setting window size to size of monitor:
        // TODO fix the bug caused by screen size != usable screen size (taskbar, etc.).
        Dimension monitorSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(monitorSize.width, monitorSize.height);


        // setting a min size for the application, so we cant scale it below that point
        setMinimumSize(new Dimension(300, 300));



        setLayout(new BorderLayout());

        this.diceContainerView = new DiceContainerView();
        add(diceContainerView, BorderLayout.SOUTH);

        this.scoreboardView = new ScoreboardView();
        add(scoreboardView, BorderLayout.CENTER);

    }

    public DiceContainerView getDiceContainer() {
        return diceContainerView;
    }

    public JLabel getScoreLabel() {
        return scoreLabel;
    }

    public ScoreboardView getScoreboardView() {
        return scoreboardView;
    }
}
