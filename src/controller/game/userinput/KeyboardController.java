package controller.game.userinput;

import controller.game.BaseController;
import controller.game.MainController;
import model.MainModel;
import view.game.MainView;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardController extends BaseController implements KeyListener {

    public KeyboardController(MainView view, MainModel model, MainController controller) {
        super(view, model);
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
