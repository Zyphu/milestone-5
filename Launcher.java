import controller.AdvancedGameController;
import view.AdvancedGameView;

public class Launcher {
    public static void main(String[] args) {
        new AdvancedGameController(new AdvancedGameView()).loadMenu();
    }
}
