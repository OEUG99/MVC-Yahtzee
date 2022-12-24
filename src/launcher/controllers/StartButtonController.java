package launcher.controllers;

import main.model.MainModel;
import launcher.views.LaunchMenuView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartButtonController implements ActionListener {
    private MainModel model;
    private LaunchMenuView view;

    public StartButtonController(MainModel model, LaunchMenuView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {;

        if (e.getSource() == view.getStartButton()) {
            model.gameStarted = true;
        }
    }
}
