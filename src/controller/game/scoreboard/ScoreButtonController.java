package controller.game.scoreboard;

import controller.game.BaseController;
import controller.game.MainController;
import controller.game.MusicController;
import model.MainModel;
import view.game.MainView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ScoreButtonController extends BaseController implements ActionListener {

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