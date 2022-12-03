package view.game;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame{

    private DiceContainerView diceContainerView;
    private ScoreboardView scoreboardView;


    public MainView() {
        super("Yahtzee");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Dimension monitorSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(monitorSize.width, monitorSize.height-(monitorSize.height/8)); // we offset height by 1/8 due to taskbar (thanks Dr. Myers for the advice)

        setMinimumSize(new Dimension(400, 400));

        setLayout(new BorderLayout());

        this.diceContainerView = new DiceContainerView();
        add(diceContainerView, BorderLayout.SOUTH);

        this.scoreboardView = new ScoreboardView();
        add(scoreboardView, BorderLayout.CENTER);
        setVisible(false);
    }

    public DiceContainerView getDiceContainer() {
        return diceContainerView;
    }

    public ScoreboardView getScoreboardView() {
        return scoreboardView;
    }
}
