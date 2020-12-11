package controller;

import java.util.ArrayDeque;
import java.util.Scanner;

import model.AdvancedDeck;
import model.AdvancedGameModel;
import view.GameView;

public class AdvancedGameController implements GameController {
    private Scanner input;
    private GameView view;
    private AdvancedGameModel model;

    public AdvancedGameController(GameView view){
        input = new Scanner (System.in);
        this.view = view;
        this.model = null;
    }

	public void loadMenu() {
        while (true){
            view.mainMenu();
            try { 
                int choice = Integer.valueOf(input.nextLine());
                if      (choice == 1)   playGame();
                else if (choice == 2)   System.exit(0);
            } catch (NumberFormatException e) { }                                 
        }
    }

    public void playGame (){
        initGame();
        while (!model.gameOver())
            playTurn();
        view.gameOver();
        input.nextLine();
    }

    private void initGame() {
        while (true){
            view.playerSelection();
            try { 
                int choice = Integer.valueOf(input.nextLine());
                if (choice >= 1 && choice <= 4) {
                    model = new AdvancedGameModel(choice);
                    return;
                }
            } catch (NumberFormatException e) { }
        }
    }

    private void playTurn () {
        ArrayDeque<Integer> editing, program, frog;
        boolean buildingFrog = false;
        AdvancedDeck deck = new AdvancedDeck();

        program = new ArrayDeque<>();
        frog = new ArrayDeque<>();
        editing = (!buildingFrog)? program : frog;

        while(true){ 
            view.displayGame(model.toString(), program.toString(), frog.toString(), buildingFrog, deck.getDeck());
            try{
                int choice = Integer.valueOf(input.nextLine());
                if (choice >= 1 && choice < deck.numOfTypes()){
                    if (deck.use(choice-1))
                        editing.add(choice);
                }
                else if (choice == deck.numOfTypes() && !buildingFrog){ // FROG
                    if (deck.use(choice-1))
                        editing.add(choice);
                }
                else if (choice == deck.numOfTypes()+1){ // BUG
                    if (!editing.isEmpty())
                        deck.putBack(deck.getCard(editing.removeLast()-1));
                }   
                else if (choice == deck.numOfTypes()+2){ // CHANGE SELECTION
                    buildingFrog = !buildingFrog;
                    editing = (!buildingFrog)? program : frog;
                } 
                else if (choice == deck.numOfTypes()+3 && !program.isEmpty()){ // END TURN
                    model.turn(deck.getCards(convertToIndex(program)), deck.getCards(convertToIndex(frog)));
                    return;
                }
            } catch (NumberFormatException e) { }   
        }
    }

    // Helper
    private int [] convertToIndex (ArrayDeque<Integer> list){
        if (list == null || list.isEmpty()) return null;
        int [] index = list.stream().mapToInt(i->i).toArray();
        for (int i = 0; i < index.length; i++) index[i]--;
        return index;
    }
}
