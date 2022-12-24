package controller.game;

import model.MainModel;
import view.game.MainView;


public abstract class BaseController {

    MainView view;
    MainModel model;

    public BaseController(MainView view, MainModel model) {
        this.view = view;
        this.model = model;

        System.out.println("Controller Created: " + this.toString());

    }
}

