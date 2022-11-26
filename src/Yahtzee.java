
import controller.*;
import model.MainModel;
import view.MainView;

public class Yahtzee {
    public static void main(String[] args) {
        // print pwd
        MainModel model = new MainModel();
        MainView view = new MainView();
        MainController controller = new MainController(view, model);
        view.validate();

    }
}