package controller.launcher;

import model.MainModel;
import view.launcher.LaunchMenuView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckBoxController implements ActionListener {

    private final MainModel model;
    private final LaunchMenuView view;

    public CheckBoxController(MainModel model, LaunchMenuView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getFancyDiceOption()) {
            model.setFancyDiceMode(view.getFancyDiceOption().isSelected());
        }
    }
}
