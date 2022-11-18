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
        Dimension diceSize = new Dimension(getSmallestDimension()/7, getSmallestDimension()/7);
        Dimension ScoreBoardContainerSize = new Dimension(view.getWidth()/2,  view.getHeight()/2);
        Dimension scoreboxesSize = new Dimension();
        scoreboxesSize.setSize(view.getWidth()/1.05, view.getHeight()/1.55);

        // setting the preferred size on all the dice components
        view.getDiceContainer().updateSize(diceSize);
        view.getScoreboardContainer().updateSize(ScoreBoardContainerSize);
        view.getScoreboardContainer().updateChildPanelSize(scoreboxesSize);
    }

    // find the smallest of the width or height:
    private int getSmallestDimension() {
        return Math.min(view.getWidth(), view.getHeight());
    }
}
