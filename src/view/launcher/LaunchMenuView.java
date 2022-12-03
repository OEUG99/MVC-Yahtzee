package view.launcher;

import javax.swing.*;
import java.awt.*;

public class LaunchMenuView extends JFrame {

    private boolean status = false;
    private JPanel panel;

    private JLabel numPlayersText, fancyDiceText, fancyDiceWarningText;
    private JButton button;

    private JCheckBox fancyDiceOption;

    public LaunchMenuView() {
        super("Yahtzee Launch Options");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Dimension monitorSize = Toolkit.getDefaultToolkit().getScreenSize();

        panel = new JPanel(new GridLayout(6, 1));
        add(panel);

        // Components to handle numPlayer colleciton
        this.numPlayersText = new JLabel("Welcome to Yahtzee, click the start button to play!");
        this.numPlayersText.setHorizontalTextPosition(JLabel.CENTER);
        this.button = new JButton("Start Game");
        panel.add(numPlayersText);
        panel.add(button);

        // fancy dice components
        this.fancyDiceText = new JLabel("Enable Fancy Dice?");
        this.fancyDiceOption = new JCheckBox();
        this.fancyDiceWarningText = new JLabel("Warning: Fancy dice may not supported on systems that do not support unicode texts due to lack of font support");
        panel.add(fancyDiceText);
        panel.add(fancyDiceOption);
        panel.add(fancyDiceWarningText);

        pack();
        setVisible( true );
    }

    public JButton getStartButton() {
        return this.button;
    }

    public JCheckBox getFancyDiceOption() {
        return fancyDiceOption;
    }
}
