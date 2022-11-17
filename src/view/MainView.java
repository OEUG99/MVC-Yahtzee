package view;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame{

    private DiceContainerView diceContainerView;
    public MainView() {
        super("Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setLayout(new BorderLayout());

        this.diceContainerView = new DiceContainerView();
        add(diceContainerView, BorderLayout.SOUTH);

        // temp text that says Hello Yahtzee!
        JLabel label = new JLabel("Hello Yahtzee!");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setFont(new Font("Arial", Font.PLAIN, 50));
        add(label, BorderLayout.CENTER);

        setVisible(true);
    }

    public DiceContainerView getDiceContainer() {
        return diceContainerView;
    }
}
