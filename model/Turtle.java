package model;

import java.util.ArrayDeque;

public class Turtle extends Movable implements Player, Orientable, Coloured, Teleportable, Pusher {
    
    private Direction direction;
    private Colour colour;
    private ArrayDeque<Move> moves;

    public Turtle(Board board, Coordinate coordinate, Direction direction, Colour colour) {
        super(board, coordinate);
        moves = null;
    }

    @Override
    public boolean accept(Movable visitor) {
        return (visitor == null)? true : visitor.visit(this);
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
    public void setTurn(ArrayDeque<Move> moves) {
        this.moves = moves;
    }

    @Override
    public void executeTurn() {
        if (moves != null)
            while(!moves.isEmpty()){
                moves.remove().execute(this);
            }
    }
}
    
    
