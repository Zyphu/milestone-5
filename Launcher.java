import controller.AdvancedGameController;
import view.AdvancedGameView;

// import model.Colour;

public class Launcher {
    public static void main(String[] args) {
        new AdvancedGameController(new AdvancedGameView()).loadMenu();
        // System.out.println(Colour.GREEN.ordinal());
    }
}
