package controller;

import model.MainModel;
import view.MainView;


public abstract class AbstractController {

    MainView view;
    MainModel model;

    public AbstractController(MainView view, MainModel model) {
        this.view = view;
        this.model = model;
    }
}

