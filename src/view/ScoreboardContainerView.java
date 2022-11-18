package view;

import javax.swing.*;
import java.awt.*;

public class ScoreboardContainerView extends JPanel {

    JPanel childPanel;
    // inner class for JPanel


    public ScoreboardContainerView() {
        super();
        this.setLayout(new GridBagLayout());
        setBackground(new Color(0xA4BE7B));
        setOpaque(true);
        GridBagConstraints ct = new GridBagConstraints();
        ct.gridx = 0;
        ct.gridy = 0;
        childPanel = new JPanel();
        childPanel.setBackground(new Color(0xE5D9B6));

        this.add(childPanel, ct);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public void updateSize(Dimension size) {
        setPreferredSize(size);
    }

    public void updateChildPanelSize(Dimension size) {
        childPanel.setPreferredSize(size);
        setPreferredSize(size);
    }
}
