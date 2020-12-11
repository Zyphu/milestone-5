package model;

// TODO - potentially add map filename
// TODO - rename AdvanceGameModel and extend GameModel interface (toString abstract + override)
public class AdvancedGameModel {

    private boolean finished = false;

    public AdvancedGameModel(int numPlayers){ 

    }

    public boolean gameOver (){
        return finished;
    }

    public void turn (Card[] program, Card[] frog){
        
    }


    @Override
    public String toString(){

        return "Turn: Player 1 - facing NORTH";
    }
}
