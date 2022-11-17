package controller;

import model.MainModel;
import view.MainView;

import java.awt.event.ActionEvent;

public class ButtonController extends AbstractControllerListener {

    public ButtonController(MainView view, MainModel model) {
        super(view, model);
    }


    public void actionPerformed(ActionEvent e) {

        // if the button is the one in the DiceRowContainer
        if (e.getSource() == view.getDiceContainer().getButton()) {
            // roll every dice
            for (int i = 0; i < 5; i++) {
                model.getDice(i).roll();
                view.getDiceContainer().getDice(i).setDiceText(model.getDice(i).getValue());
            }
        }

    }
}
