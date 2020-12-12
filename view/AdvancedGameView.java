package view;

public class AdvancedGameView implements GameView {
    public void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void mainMenu() {
        clear();
        System.out.print(
                "Welcome to Robot Turtles!\n" +
                "=============================\n"+
                "1) PLAY\n" +
                "2) EXIT\n\n"+
                "Enter choice (1-2): ");
    }

    public void gameOver() {
        clear();
        System.out.print(
            "GAME OVER\n"+
            "=============================\n"+
            "Congratulations you have won!\n\n"+
            "Press [ENTER] to exit ");
    }

    public void playerSelection (){
        clear ();
        System.out.print("Enter number of players (1-4): ");
    }

    public void displayGame(String game, String turnProgram, String frog, boolean buildingFrog, String[] deck){
        clear ();
        StringBuilder sb = new StringBuilder(game);
        sb.append("\n==============================================================\n");
        if (!buildingFrog){
            sb.append("[S] PROGRAM       "+turnProgram+'\n');
            sb.append("    FROG FUNCTION "+frog+'\n');
        }
        else{
            sb.append("    PROGRAM       "+turnProgram+'\n');
            sb.append("[S] FROG FUNCTION "+frog+'\n');
        }
        sb.append("==============================================================\n");
        for (int i = 0; i < deck.length; i++)
            sb.append(String.format("%d) %s", i+1, deck[i]));
        sb.append(String.format("%d) BUG\n", deck.length+1));
        sb.append("-------------------\n");
        sb.append(String.format("%d) CHANGE SELECTION\n", deck.length+2));
        sb.append(String.format("%d) END TURN\n", deck.length+3));
        sb.append(String.format("%d) EXIT GAME\n\n", deck.length+4));
        sb.append(String.format("Enter choice (1-%d): ", deck.length+4));
        System.out.print(sb.toString());
    }
}
