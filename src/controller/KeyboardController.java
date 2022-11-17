package controller;

import model.MainModel;
import view.MainView;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardController extends AbstractController implements KeyListener {

    public KeyboardController(MainView view, MainModel model) {
        super(view, model);
    }


    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println(e.getKeyCode());
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
