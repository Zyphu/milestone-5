package model;

import java.util.ArrayDeque;

public abstract class Turtle extends Movable implements Player, Orientable, Teleportable, Pusher {
    
    private Direction direction;
    private Colour colour;
    private ArrayDeque<Move> moves;
    private boolean winner = false;

    public Turtle(Board board, Coordinate coordinate, Direction direction, Colour colour) {
        super(board, coordinate);
        this.direction = direction;
        this.colour = colour;
        moves = null;
    }

    @Override
    public boolean accept(Movable visitor) {
        return (visitor == null)? true : visitor.visit(this);
    }

    @Override
    public void setTurn(ArrayDeque<Move> moves) {
        this.moves = moves;
    }

    @Override
    public void executeTurn() {
        if (moves != null)
            for (Move move : moves) 
                move.execute(this);
        moves = null;
    }

    @Override
    public boolean hasWon (){
        return winner;
    }

    @Override
    public void won (){
        winner = true;
    }

    @Override
    public Direction getDir() {
        return direction;
    }

    @Override
    public void setDir(Direction direction) {
        this.direction = direction;
    }

    @Override
    public Colour getColour() {
        return colour;
    }

    @Override
    public char textIcon() {
        return (char)('1'+colour.ordinal());
    }

}
    
    
