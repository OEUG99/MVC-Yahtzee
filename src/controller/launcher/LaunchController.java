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

        view.getButton().addActionListener(new ButtonListener(model,view));
    }
}
