package controller.game;

import model.DiceModel;
import model.MainModel;
import view.game.DiceView;
import view.game.MainView;

import java.awt.event.*;


public class MouseController extends AbstractController implements MouseMotionListener, MouseListener {


    public MouseController(MainView view, MainModel model, MainController controller) {
        super(view, model);
    }


    @Override
    public void mouseClicked(MouseEvent e) {

        // if dice in the dice container
        if (e.getSource() instanceof DiceView diceViewInstance) {

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


        }


    }

    @Override
    public void mousePressed(MouseEvent e) {
          // todo implement mousePressed
    }

    @Override
    public void mouseReleased(MouseEvent e) {
          // todo implement mouseReleased
    }

    @Override
    public void mouseEntered(MouseEvent e) {
          // todo implement mouseEntered
    }

    @Override
    public void mouseExited(MouseEvent e) {
          // todo implement mouseExited
    }

    @Override
    public void mouseDragged(MouseEvent e) {
          // todo implement mouseDragged
    }

    @Override
    public void mouseMoved(MouseEvent e) {
          // todo implement mouseMoved )
    }

}