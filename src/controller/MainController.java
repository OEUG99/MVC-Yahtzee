package controller;

import model.MainModel;
import view.MainView;

import java.awt.event.ActionEvent;


public class MainController extends AbstractController {

    MouseController mouseController;
    KeyboardController keyboardController;
    ButtonController buttonController;
    WindowController windowController;


    public MainController(MainView view, MainModel model) {
        super(view, model);


    }

    // generic method for registering controllers:
    public void registerController(AbstractController controller) {
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

    @Override
    public void actionPerformed(ActionEvent e) {}

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
