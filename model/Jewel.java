package model;

public class Jewel extends ColouredTile {
    public Jewel (Coordinate coordinate, Colour colour){
        super(coordinate, colour);
    }
    
    public boolean accept (Movable visitor){
        return visitor.visit(this);
    }
}
