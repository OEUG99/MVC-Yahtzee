package controller;

import model.MainModel;
import view.MainView;

import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

/**
 * A class that handles the users resizing of the window.
 */
public class WindowController extends AbstractController implements ComponentListener {

    public WindowController(MainView mainView, MainModel mainModel) {
        super(mainView, mainModel);
    }


    @Override
    public void componentResized(ComponentEvent e) {
        scaleView(e);
    }

    @Override
    public void componentMoved(ComponentEvent e) {
    }

    @Override
    public void componentShown(ComponentEvent e) {
    }

    @Override
    public void componentHidden(ComponentEvent e) {
    }

    public void scaleView(ComponentEvent e) {
        Dimension diceSize = new Dimension(e.getComponent().getWidth()/10,
                e.getComponent().getWidth()/10);

        // setting the preferred size on all the dice components
        view.getDiceContainer().updateSize(diceSize);
    }
}
