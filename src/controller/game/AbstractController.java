package controller.game;

import model.MainModel;
import view.game.MainView;


public abstract class AbstractController {

    MainView view;
    MainModel model;


    public AbstractController(MainView view, MainModel model) {
        this.view = view;
        this.model = model;

    }
}

