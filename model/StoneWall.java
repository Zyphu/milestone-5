package model;

public class StoneWall extends Tile{
    public StoneWall(Coordinate coordinate){
        super(coordinate);
    }
    
    public boolean accept (Movable visitor){
        return visitor.visit(this);
    }
}
