package yahtzee.controllers.scoreboard;

import main.controllers.bases.BaseController;
import main.controllers.MainController;
import main.controllers.MusicController;
import main.model.MainModel;
import yahtzee.views.MainView;

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

        System.out.println(e.getSource());
    }
}