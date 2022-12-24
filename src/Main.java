import main.controllers.MainController;
import launcher.controllers.LaunchController;
import main.model.MainModel;
import yahtzee.views.MainView;
import launcher.views.LaunchMenuView;

public class Main {
    public static void main(String[] args) {

        // Main Model used by both the game and launcher:
        MainModel model = new MainModel();

        // Launcher
        LaunchMenuView launchMenuView = new LaunchMenuView();
        LaunchController launchMenuController = new LaunchController(launchMenuView, model);

        // Main Game:
        MainView view = new MainView();
        MainController controller = new MainController(view, model, launchMenuController);
        view.setVisible(false);
    }
}