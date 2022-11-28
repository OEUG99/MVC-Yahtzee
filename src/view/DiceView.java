package view;

import javax.swing.*;
import java.awt.*;

/**
 * This class is the view for the dice portion of the gui.
 * It contains a button that can be clicked to roll the dice
 * It also displays the value of the dice
 */
public class DiceView extends JPanel {

    JLabel diceLabel;
    int id;

    public DiceView(int id) {
        super();

        // get the height and width of frame

        this.id = id;

        // set the size of the DiceView panel
        setOpaque(true);
        setBackground(new Color(0xE7D39B));
        //setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // create a dice label that is in the direct center of this dice object:
        diceLabel = new JLabel("Roll Me!");
        diceLabel.setHorizontalAlignment(JLabel.CENTER);
        diceLabel.setVerticalAlignment(JLabel.CENTER);
        //diceLabel.setFont(new Font("Arial", Font.PLAIN, 50));

        add(diceLabel);
    }


    public void setDiceText(String text){
        diceLabel.setText(text);
    }


    public int getId() {
        return id;
    }

    public void updateSize(Dimension size) {
        // updates dice label size and dice size
        diceLabel.setPreferredSize(size);
        setPreferredSize(size);
    }

    public void setLocked(boolean state) {
        if (state) {
            setBackground(new Color(0xFF6C603B, true));
        } else {
            setBackground(new Color(0xE7D39B));
        }
    }
}
