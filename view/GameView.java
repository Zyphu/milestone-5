package view;

public interface GameView {
    public void clear ();   
    public void mainMenu();
    public void gameOver();
    public void playerSelection();
    public void displayGame(String game, String turnProgram, String frog, boolean buildingFrog, String[] deck);
    
}
