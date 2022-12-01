import controller.game.MainController;
import controller.launcher.LaunchController;
import model.MainModel;
import view.game.MainView;
import view.launcher.LaunchMenuView;

public class Yahtzee {
    public static void main(String[] args) {


        MainModel model = new MainModel();

        // create launch menu
        LaunchMenuView launchMenuView = new LaunchMenuView();
        LaunchController launchMenuController = new LaunchController(launchMenuView, model);




        MainView view = new MainView();
        MainController controller = new MainController(view, model);
        view.setVisible(false);

    }
}