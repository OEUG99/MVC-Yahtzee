package controller.game;

import model.MainModel;
import view.game.MainView;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardController extends AbstractController implements KeyListener {

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
