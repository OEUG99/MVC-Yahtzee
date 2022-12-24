package yahtzee.controllers.userinput;

import main.controllers.bases.BaseController;
import main.controllers.MainController;
import main.model.MainModel;
import yahtzee.views.MainView;

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
