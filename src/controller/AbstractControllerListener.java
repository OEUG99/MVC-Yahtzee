package controller;

import model.MainModel;
import view.MainView;

import java.awt.event.ActionListener;

public abstract class AbstractControllerListener extends AbstractController implements ActionListener {
    public AbstractControllerListener(MainView view, MainModel model) {
        super(view, model);
    }
}
