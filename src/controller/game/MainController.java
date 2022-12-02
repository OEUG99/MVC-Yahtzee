package controller.game;

import model.MainModel;
import view.game.MainView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;


public class MainController extends AbstractController implements ActionListener {

    MouseController mouseController;
    KeyboardController keyboardController;
    ButtonController buttonController;
    WindowController windowController;
    MusicController musicController;


    public MainController(MainView view, MainModel model) {
        super(view, model);
        initSubControllers();
        startGame();
    }

    /**
     * <p>The main function that controls the flow of the applications.</p>
     */
    private void startGame() {
        // auto-sizing the game based on screen size:
        getWindowController().scaleView(new ComponentEvent(view, ComponentEvent.COMPONENT_RESIZED));
        view.setVisible(true);

        // creating timer, think of this as an alternative to a traditional game loop. We will set delay to '1' not '0'
        // to avoid hogging CPU. This delay should be fast enough for our purposes.
        Timer timer = new Timer(1, this);
        timer.start();
    }

    public void changeTurn() {

        model.nextPlayer();

        getButtonController().resetRollButton();

        view.getDiceContainer().getButton().setText("Roll the Dice");
        for (int i = 0; i < 5; i++) {

            //view.getDiceContainer().getDice(i).setFont();
            view.getDiceContainer().getDice(i).getDiceLabel().setFont(new Font("Arial", Font.BOLD, 13));
            view.getDiceContainer().getDice(i).setDiceText("Roll Me!");
            view.getDiceContainer().getDice(i).setLocked(false);
            model.getDice(i).setLocked(false);

            getButtonController().changeScoreBoardPressed();
            for (int j = 0; j < 17; j++) {
                    view.getScoreboardView().getScoreContainerView().getScoreArray()[j].getScoreButton().setEnabled(false);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // update the score label
        if (model.gameStarted) {
            view.setTitle("Yahtzee - Current Player: " + model.getCurPlayer());
            view.setVisible(true);
        }

        // Temporary implement for restarting turns
        int returnedRolls = getButtonController().returnRolls();

        if (returnedRolls == 0) {
            if (getButtonController().getScoreBoardPressed()){
                changeTurn();
            }
        }

    }

    private void initSubControllers() {
        // registering the sub-controllers to the main controller:
        registerController(new MusicController(view, model, this));
        registerController(new MouseController(view, model, this));
        registerController(new KeyboardController(view, model, this));
        registerController(new ButtonController(view, model, this));
        registerController(new WindowController(view, model, this));

        // We can now assign specific sub-controllers to the view of different components.
        // First lets assigning the mouse sub-controller to the DiceContainerView:
        // notice how we get the DiceContainerView from the MainView using getter.
        view.getDiceContainer().addMouseListener(getMouseController());

        // Assigning the button sub-controller to the roll dice button:
        // Notice how from mainView we get the container again, but then we get the button.
        // this allows us the button controller to update the model whenever that single button is pressed.
        view.getDiceContainer().getButton().addActionListener(getButtonController());

        // Assigning the window sub-controller to the main view (the JFrame):
        // this is used to handle scaling of the window.
        view.addComponentListener(getWindowController());

        // Now let's, assigning the mouse sub-controller to the individual dice:
        for (int i = 0; i < 5; i++) {
            // Since the dice are stored in the dice container, we access it through that, then assign the controller:
            view.getDiceContainer().getDice(i).addMouseListener(getMouseController());
        }

        for (int i = 0; i < 17; i++){
            JButton button = view.getScoreboardView().getScoreContainerView().getScoreArray()[i].getScoreButton();
            button.addActionListener(getButtonController());
        }
    }

    private void registerController(AbstractController controller) {

        if (controller instanceof MusicController) { // music has to go first since other controllers talk to it.
            musicController = (MusicController) controller;
        }
        else if (controller instanceof MouseController) {
            mouseController = (MouseController) controller;
        } else if (controller instanceof KeyboardController) {
            keyboardController = (KeyboardController) controller;
        } else if (controller instanceof ButtonController) {
            buttonController = (ButtonController) controller;
        } else if (controller instanceof WindowController) {
            windowController = (WindowController) controller;
        }
    }

    // getters for sub-controllers
    public MouseController getMouseController() {
        return mouseController;
    }

    public KeyboardController getKeyboardController() {
        return keyboardController;
    }

    public ButtonController getButtonController() {
        return buttonController;
    }

    public WindowController getWindowController() {
        return windowController;
    }

    public MusicController getMusicController() {
        return musicController;
    }
}
