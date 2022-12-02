package view.game;

import javax.swing.*;
import java.awt.*;

/** <p>This class is the view for the dice container. This class is a container for the dice views.
 * It also contains the viewing code for the roll button.</p>
 */
public class DiceContainerView extends JPanel {

   private DiceView[] dice;
    public JButton button;

    public DiceContainerView() {
        super();
        setBackground(new Color(0x5fb061));

        dice = new DiceView[5];
        for (int i = 0; i < 5; i++) {
            dice[i] = new DiceView(i);
            add(dice[i]);
        }


        button = new JButton("Roll the Dice");
        button.setBackground(new Color(0x5F8D4E));
        add(button);
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);}

    public DiceView getDice(int n) {
        return dice[n];
    }

    public JButton getButton() {
        return button;
    }

    // called by windowController when the window is resized
    public void updateSize(Dimension size) {
        for (int i = 0; i < 5; i++) {
            dice[i].updateSize(size);
        }
        button.setPreferredSize(size);
    }


}