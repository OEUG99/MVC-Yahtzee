package launcher.controllers;

import main.model.MainModel;
import launcher.views.LaunchMenuView;
import java.awt.event.ActionListener;

public class LaunchController {
    private ActionListener actionListener;

    LaunchMenuView view;
    MainModel model;
    public LaunchController(LaunchMenuView launchMenuView, MainModel model) {
        this.model = model;
        this.view = launchMenuView;

        view.getStartButton().addActionListener(new StartButtonController(model, view));
        view.getFancyDiceOption().addActionListener(new CheckBoxController(model, view));
    }

    public void updateViability(boolean b){
        view.setVisible(b);
    }
}
