package controller;

import model.MainModel;
import view.MainView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;


public class MainController extends AbstractController implements ActionListener {

    MouseController mouseController;
    KeyboardController keyboardController;
    ButtonController buttonController;
    WindowController windowController;


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

        // creating timer, think of this as an alternative to a traditional game loop
        Timer timer = new Timer(0, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // update the score label
        if (model.gameStarted) {
            view.setTitle("Sum of all dice: " + model.getSumOfAllDice());
        }
    }

    private void initSubControllers() {
        // registering the sub-controllers to the main controller:
        registerController(new MouseController(view, model));
        registerController(new KeyboardController(view, model));
        registerController(new ButtonController(view, model));
        registerController(new WindowController(view, model));

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
            // Since the dice are stored in teh dice container, we access it through that, then assign the controller:
            view.getDiceContainer().getDice(i).addMouseListener(getMouseController());
        }
    }

    private void registerController(AbstractController controller) {
        if (controller instanceof MouseController) {
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

}
