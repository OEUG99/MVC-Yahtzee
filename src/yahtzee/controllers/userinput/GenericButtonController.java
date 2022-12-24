package yahtzee.controllers.userinput;

import main.controllers.MainController;
import main.controllers.MusicController;
import main.controllers.bases.BaseController;
import main.model.MainModel;
import yahtzee.views.MainView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GenericButtonController extends BaseController implements ActionListener {

    private int rollsLeft = 3;

    private MusicController musicController;

    private MainController controller;

    public GenericButtonController(MainView view, MainModel model, MainController controller) {
        super(view, model);
        this.controller = controller;
        musicController = controller.getMusicController();
    }


    boolean scoreBoardPressed = false;

    public boolean getScoreBoardPressed() {
        return scoreBoardPressed;
    }

    public void changeScoreBoardPressed(){
        scoreBoardPressed = false;
    }


    public void actionPerformed(ActionEvent e) {

        // if the button is the one in the DiceRowContainer
        if (e.getSource() == view.getDiceContainer().getButton()) {

            // play sound effect from music controller
            musicController.playRollSound();

            rollsLeft--;
            view.getDiceContainer().getButton().setText("rolls Left: " + rollsLeft);

            if (rollsLeft == 0) { // todo make it show the scorebuttons are always usable but change turns
                view.getDiceContainer().getButton().setEnabled(false);

            }


            model.gameStarted = true; // if we roll all the dice, we know the game started.

            // roll every dice
            for (int i = 0; i < 5; i++) {


                model.getDice(i).roll();
                // fancy large arial font
                view.getDiceContainer().getDice(i).getDiceLabel().setFont(new Font("Arial", Font.BOLD, 32));

                if (model.getFancyDiceMode()) {
                    view.getDiceContainer().getDice(i).setFancyDice(Integer.parseInt(model.getDice(i).getValue()));
                } else {
                    view.getDiceContainer().getDice(i).setDiceText(model.getDice(i).getValue());
                }

            }
        }
    }


    public int returnRolls() {
        return rollsLeft;
    }

    /**
     * Called from the Main controller, whenever a turn is over.
     */
    public void resetRollButton() {
        rollsLeft = 3;
        view.getDiceContainer().getButton().setEnabled(true);
        view.getDiceContainer().getButton().setText("Roll Me!");
        musicController.playSound("sounds/voicelines/next_turn.wav", false, true);

    }

    public void disableScoreButtons(){
        for (int i = 0; i < 15; i++) {
            if (i != 6 && i != 7) { // we ignore 6 and 7th
                if (view.getScoreboardView().getScoreContainerView().getScoreArray()[i].getScoreHere() == "Score here."){
                    view.getScoreboardView().getScoreContainerView().getScoreArray()[i].getScoreButton().setEnabled(false);
                }
            }
        }

       controller.changeTurn();

    }
}
