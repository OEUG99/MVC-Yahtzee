package controller;

import model.DiceModel;
import model.MainModel;
import view.DiceView;
import view.MainView;

import java.awt.event.*;


public class MouseController extends AbstractController implements MouseMotionListener, MouseListener {


    public MouseController(MainView view, MainModel model) {
        super(view, model);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // mouse events switch statement
        String ctx = e.getActionCommand();
        switch (ctx) {}
        }

    @Override
    public void mouseClicked(MouseEvent e) {

        System.out.println(e.getSource().toString());

        // if dice in the dice container
        if (e.getSource() instanceof DiceView) {
            DiceView diceViewInstance = (DiceView) e.getSource();

            // getting the Model instance of the dice
            DiceModel diceModelInstance = model.getDice(diceViewInstance.getId());

            // rolling dice if it is not locked
            if (!diceModelInstance.isLocked()) {
                // locking the dice
                diceModelInstance.setLocked(true);
                diceViewInstance.setLocked(diceModelInstance.isLocked());
            } else {
                // unlocking the dice
                diceModelInstance.setLocked(false);
                diceViewInstance.setLocked(diceModelInstance.isLocked());
            }

            // updating the dice image:
            //diceViewInstance.setDiceText(model.getDice(diceViewInstance.getId()).getValue());

        }


    }

    @Override
    public void mousePressed(MouseEvent e) {
          // todo implement mousePressed (we pass ActionEvents in case we need to get info like mouse position)
    }

    @Override
    public void mouseReleased(MouseEvent e) {
          // todo implement mouseReleased (we pass ActionEvents in case we need to get info like mouse position)
    }

    @Override
    public void mouseEntered(MouseEvent e) {
          // todo implement mouseEntered (we pass ActionEvents in case we need to get info like mouse position)
    }

    @Override
    public void mouseExited(MouseEvent e) {
          // todo implement mouseExited (we pass ActionEvents in case we need to get info like mouse position)
    }

    @Override
    public void mouseDragged(MouseEvent e) {
          // todo implement mouseDragged (we pass ActionEvents in case we need to get info like mouse position)
    }

    @Override
    public void mouseMoved(MouseEvent e) {
          // todo implement mouseMoved (we pass ActionEvents in case we need to get info like mouse position)
    }

}