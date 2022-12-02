package view.launcher;

import javax.swing.*;
import java.awt.*;

public class LaunchMenuView extends JFrame {

    private boolean status = false;
    private JPanel panel;

    private JLabel numPlayersText, fancyDiceText, fancyDiceWarningText;
    private JButton button;
    private JTextField textField;

    private JCheckBox fancyDiceOption;

    public LaunchMenuView() {
        super("Yahtzee Launch Options");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Dimension monitorSize = Toolkit.getDefaultToolkit().getScreenSize();

        panel = new JPanel(new GridLayout(6, 1));
        add(panel);

        // Components to handle numPlayer colleciton
        this.numPlayersText = new JLabel("Type the number of player, then click the start button.");
        this.numPlayersText.setHorizontalTextPosition(JLabel.CENTER);
        this.textField = new JTextField(4);
        this.button = new JButton("Start Game");
        panel.add(numPlayersText);
        panel.add(textField);
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

    public String getTextField() {
        return textField.getText();
    }

    public JCheckBox getFancyDiceOption() {
        return fancyDiceOption;
    }
}
