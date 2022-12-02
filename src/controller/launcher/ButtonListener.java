package controller.launcher;

import model.MainModel;
import view.launcher.LaunchMenuView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {
    private MainModel model;
    private LaunchMenuView view;

    public ButtonListener(MainModel model, LaunchMenuView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {;

        if(e.getSource() == view.getButton()) {
            // if the user inputted an integer
            if (view.getTextField().matches("^[0-9]+$")) {
                model.setNumPlayers(Integer.parseInt(view.getTextField()));
                model.setCurPlayer(0);
                System.out.println(model.getNumPlayers());

                // starting the main game, hiding the launch options
                model.gameStarted = true;
                view.setVisible(false);
            }

        }
    }
}
