package view.launcher;

import javax.swing.*;
import java.awt.*;

public class LaunchMenuView extends JFrame {

    private boolean status = false;
    private JPanel panel;

    private JLabel numPlayersText;
    private JButton button;
    private JTextField textField;

    public LaunchMenuView() {
        super("Yahtzee Launch Options");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Dimension monitorSize = Toolkit.getDefaultToolkit().getScreenSize();
        //setSize(monitorSize.width /3, monitorSize.height/3); // we offset height by 1/8 due to taskbar

        this.panel = new JPanel();
        this.numPlayersText = new JLabel("Type the number of player, then click the start button.");
        this.textField = new JTextField(4);
        this.button = new JButton("Start");

        add(panel);
        panel.add(numPlayersText);
        panel.add(textField);
        panel.add(button);
        pack();
        setVisible( true );
    }

    public JButton getButton() {
        return this.button;
    }

    public String getTextField() {
        return textField.getText();
    }
}
