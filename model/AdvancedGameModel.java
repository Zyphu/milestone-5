package model;

import java.util.ArrayDeque;

public class AdvancedGameModel implements GameModel, Board {

    private int dimensions = 8;
    private boolean finished = false;
    private ArrayDeque<Jewel> jewels;
    private ArrayDeque<Turtle> players;
    private ArrayDeque<Tile> otherTiles;


    // private char [][] map = {
    //     {'.','.','.','.','.','.','.','.',},
    //     {'.','.','.','.','.','.','.','.',},
    //     {'.','.','.','.','.','.','.','.',},
    //     {'.','.','.','.','.','.','.','.',},
    //     {'.','.','.','.','.','.','.','.',},
    //     {'.','.','.','.','.','.','.','.',},
    //     {'.','.','.','.','.','.','.','.',},
    //     {'.','.','.','.','.','.','.','.',},
    // };

    
    public AdvancedGameModel(int numPlayers){
        jewels  = new ArrayDeque<>();
        players = new ArrayDeque<>();
        otherTiles = new ArrayDeque<>();

        if (numPlayers < 1 && numPlayers > 4) finished = true;
        else{

            Colour [] colours = Colour.values();
            Coordinate [] jCoord = {new Coordinate(3, 3), new Coordinate(3, 4), new Coordinate(4, 4), new Coordinate(4, 3)}; 
            Coordinate [] tCoord = {new Coordinate(0, 0), new Coordinate(0, 7), new Coordinate(7, 7), new Coordinate(7, 0)};
            Direction [] tDir = {Direction.SOUTH, Direction.EAST, Direction.NORTH, Direction.WEST};
            for (int i = 0; i < numPlayers; i++){
                jewels.add(new Jewel(jCoord[i], colours[i]));
                players.add(new PlayerTurtle (this, tCoord[i], tDir[i], colours[i]));
            }
            otherTiles.add( new IceWall(new Coordinate(0, 2)));
            otherTiles.add( new IceWall(new Coordinate(5, 2)));
            otherTiles.add( new StoneWall(new Coordinate(6,2)));
            otherTiles.add( new StoneWall(new Coordinate(0,3)));
            otherTiles.add( new Crate(this, new Coordinate(2, 5)));
            otherTiles.add( new Crate(this, new Coordinate(2, 6)));
            otherTiles.add( new Portal(new Coordinate(4, 2), new Coordinate(2, 6)));

        }        
    }

    @Override
    public boolean gameOver (){
        return finished;
    }

    @Override
    public void playTurn (Card[] program, Card[] frog){
        if (finished || program == null) return;
        AdvancedDeck deck = new AdvancedDeck();
        ArrayDeque<Move> moves = new ArrayDeque<>();
        for (int i = 0; i < program.length; i++){
            if (program[i].equals(Card.FROG) && frog != null){
                for (int j = 0; j < frog.length; j++)
                    if (deck.use(frog[j])){
                        try {
                            moves.add(getMove(frog[j]));
                        } catch (NullPointerException e) { }
                    }
                        
            }
            if (deck.use(program[i])){
                try {
                    moves.add(getMove(program[i]));
                } catch (NullPointerException e) { }
            }
        }

        if(!players.isEmpty()){
            Turtle curr = players.remove();
            curr.setTurn(moves);
            curr.executeTurn();
            if(!curr.hasWon())
                players.add(curr);
        }
        if (players.isEmpty()) finished = true;

    }

    private Move getMove (Card card){
        switch(card){
            case FORWARD: return new Forward();
            case RIGHT:   return new Right();
            case LEFT:    return new Left();
            case LASER:   return new Laser();
            default:;
        }
        return null;
    }

    @Override
    public Tile getTileAt(Coordinate coordinate) {
        for (Jewel jewel : jewels) if (jewel.getCoordinate().equals(coordinate)) return jewel;
        for (Turtle turtle: players) if (turtle.getCoordinate().equals(coordinate)) return turtle;
        for (Tile other : otherTiles) if (other.getCoordinate().equals(coordinate)) return other;
        return null;
    }

    @Override
    public boolean inBounds(Coordinate coordinate) {
        if (coordinate == null) return false;
        return coordinate.x() > 0 || coordinate.x() < dimensions || coordinate.y() > 0 || coordinate.y() < dimensions;
    }

    @Override
    public void remove(Tile tile){
        for (Jewel jewel : jewels) if (jewel.equals(tile)) jewels.remove(jewel);
        for (Turtle turtle: players) if (turtle.equals(tile)) players.remove(turtle);
        for (Tile other : otherTiles) if (other.equals(tile)) otherTiles.remove(other);
    }


    @Override
    public String toString(){
        if (finished) return "Game Over";
        char [][] cBoard = new char [dimensions][dimensions];
        for (int y = 0; y < dimensions; y++)
            for (int x = 0; x < dimensions; x++) cBoard[y][x] = '.';

        
        for (Tile t : otherTiles)   cBoard[t.getCoordinate().y()][t.getCoordinate().x()] = t.textIcon();
        for (Jewel t : jewels)      cBoard[t.getCoordinate().y()][t.getCoordinate().x()] = t.textIcon();
        for (Turtle t : players)    cBoard[t.getCoordinate().y()][t.getCoordinate().x()] = t.textIcon();
        
        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < dimensions; y++){
            for (int x = 0; x < dimensions; x++)
                sb.append(cBoard[y][x]+"  ");
            sb.append('\n');
        }

        sb.append(String.format("\n\nTurn: Player %c - facing %s\n", players.peek().textIcon(), players.peek().getDir()));
        return sb.toString();
    }
}
