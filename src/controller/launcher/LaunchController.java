package controller.launcher;

import model.MainModel;
import view.launcher.LaunchMenuView;
import java.awt.event.ActionListener;

public class LaunchController {
    private ActionListener actionListener;

    LaunchMenuView view;
    MainModel model;
    public LaunchController(LaunchMenuView launchMenuView, MainModel model) {
        this.model = model;
        this.view = launchMenuView;

        view.getStartButton().addActionListener(new StartButtonListener(model, view));
        view.getFancyDiceOption().addActionListener(new CheckBoxListener(model, view));
    }

    public void updateViability(boolean b){
        view.setVisible(b);
    }
}
