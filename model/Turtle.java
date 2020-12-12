package model;

public class Turtle extends Movable implements Player, Orientable, Coloured {
    
    private Direction direction;
    private Colour colour;
    private Move[] moves = null;

    public Turtle(Board board, Coordinate coordinate, Direction direction, Colour colour) {
        super(board, coordinate);
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
    public void setTurn(Move[] moves) {
        this.moves = moves;
    }

    @Override
    public void executeTurn() {
        if (moves != null)
            for (Move move : moves)
                move.execute(this);
    }
}
    
    
