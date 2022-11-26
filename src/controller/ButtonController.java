package controller;

import model.MainModel;
import view.MainView;

import java.awt.event.ActionEvent;

public class ButtonController extends AbstractControllerListener {

    private int rollsLeft = 3;

    private MusicController musicController;

    public ButtonController(MainView view, MainModel model, MainController controller) {
        super(view, model);
        musicController = controller.getMusicController();


    }

    /**
     * Called from the main view, whenever a turn is over.
     */
    public void resetRollButton() {
        rollsLeft = 3;
        view.getDiceContainer().getButton().setEnabled(true);

    }


    public void actionPerformed(ActionEvent e) {

        // if the button is the one in the DiceRowContainer
        if (e.getSource() == view.getDiceContainer().getButton()) {

            // play sound effect from music controller
            musicController.playRollSound();


            rollsLeft--;
            view.getDiceContainer().getButton().setText("rolls Left: " + rollsLeft);

            if (rollsLeft == 0) {
                view.getDiceContainer().getButton().setEnabled(false);
            }

            model.gameStarted = true; // if we roll all teh dice, we know the game started.

            // roll every dice
            for (int i = 0; i < 5; i++) {
                model.getDice(i).roll();
                view.getDiceContainer().getDice(i).setDiceText(model.getDice(i).getValue());
            }
        }

    }
}
