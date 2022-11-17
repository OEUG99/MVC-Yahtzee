
import controller.*;
import model.MainModel;
import view.MainView;

public class Yahtzee {
    public static void main(String[] args) {
        System.out.println("here");

        // Creating the main model and view.
        MainModel model = new MainModel();
        MainView view = new MainView();

        // Creating the main controller. This will house all the sub-controllers as attributes:
        MainController controller = new MainController(view, model);

        // Registering sub-controllers with the main controller, so they can be accessed via main controller getters.
        // We do this so that we can access the sub-controllers from the main controller.
        // The main controller is where the game rules and logic are implemented, so it needs access to sub-controllers.
        controller.registerController(new MouseController(view, model));
        controller.registerController(new KeyboardController(view, model));
        controller.registerController(new ButtonController(view, model));
        controller.registerController(new WindowController(view, model));


        // We can now assign specific sub-controllers to the view of different components.
        // First lets assigning the mouse sub-controller to the DiceContainerView:
        view.getDiceContainer().addMouseListener(controller.getMouseController());

        // Now let's, assigning the mouse sub-controller to the individual dice:
        for (int i = 0; i < 5; i++) {
            // Since the dice are stored in teh dice container, we access it through that, then assign the controller:
            view.getDiceContainer().getDice(i).addMouseListener(controller.getMouseController());
        }

        // Assigning the button sub-controller to the roll dice button:
        view.getDiceContainer().getButton().addActionListener(controller.getButtonController());

        // Assigning the window sub-controller to the main view (the JFrame):
        view.addComponentListener(controller.getWindowController());

        // Notice, we are using god-classes for the controllers. We can make specific controllers for each component,
        // but, since this application is small, we don't need to do that. This is always an option though, if we need
        // to implement more complex logic for a specific component.

    }
}