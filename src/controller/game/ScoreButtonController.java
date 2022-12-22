package controller.game;

import model.MainModel;
import view.game.MainView;
import view.game.ScoreView;

import java.awt.event.ActionEvent;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class ScoreButtonController extends AbstractControllerListener {

    private MusicController musicController;

    private MainController controller;

    public ScoreButtonController(MainView view, MainModel model, MainController controller) {
        super(view, model);
        this.controller = controller;
        musicController = controller.getMusicController();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("test");
    }
}