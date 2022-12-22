import controller.game.MainController;
import controller.launcher.LaunchController;
import model.MainModel;
import view.game.MainView;
import view.launcher.LaunchMenuView;

public class Yahtzee {
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