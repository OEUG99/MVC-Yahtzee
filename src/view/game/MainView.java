package view.game;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame{

    private DiceContainerView diceContainerView;
    private JLabel scoreLabel;
    private ScoreboardView scoreboardView;


    public MainView() {
        super("Yahtzee");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // TODO fix the bug caused by screen size != usable screen size (taskbar, etc.).
        Dimension monitorSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(monitorSize.width, monitorSize.height-(monitorSize.height/8)); // we offset height by 1/8 due to taskbar


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
