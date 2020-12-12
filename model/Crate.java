package model;

public class Crate extends Movable{

    public Crate (Board board, Coordinate coordinate){
        super(board,coordinate);
    }

    @Override
    public boolean accept(Movable visitor) {
        return (visitor == null)? true : visitor.visit(this);
    }

    @Override
    public char textIcon() {
        return 'C';
    }

    
}
