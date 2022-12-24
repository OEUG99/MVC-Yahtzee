package controller.launcher;

import model.MainModel;
import view.launcher.LaunchMenuView;

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
