package controller;

import model.MainModel;
import view.MainView;

import java.awt.event.ActionEvent;

public class ButtonController extends AbstractController {

    public ButtonController(MainView view, MainModel model) {
        super(view, model);
    }

    // what listener in jswing handles buttons?

    public void actionPerformed(ActionEvent e) {
        System.out.println("Button pressed");

        // if the button is the one in the DiceRowContainer
        if (e.getSource() == view.getDiceContainer().getButton()) {
            // roll every dice
            for (int i = 0; i < 5; i++) {
                model.getDice(i).roll();
                view.getDiceContainer().getDice(i).setDiceText(model.getDice(i).getValue());
                view.validate();
            }
        }

    }
}
