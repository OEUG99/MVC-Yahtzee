package main.controllers.bases;

import main.model.MainModel;
import yahtzee.views.MainView;


public abstract class BaseController {

    public MainView view;
    public MainModel model;

    public BaseController(MainView view, MainModel model) {
        this.view = view;
        this.model = model;

        System.out.println("Controller Created: " + this.toString());

    }
}

