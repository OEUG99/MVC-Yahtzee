package controller;

import model.MainModel;
import view.MainView;

import java.awt.event.ActionListener;

public abstract class AbstractController implements ActionListener {

    MainView view;
    MainModel model;

    public AbstractController(MainView view, MainModel model) {
        this.view = view;
        this.model = model;
    }
}
