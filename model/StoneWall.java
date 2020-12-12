package model;

public class StoneWall implements Tile{
    private Coordinate coordinate;

    public StoneWall(Coordinate coordinate){
        this.coordinate = coordinate;
    }
    
    @Override
    public Coordinate getCoordinate(){
        return coordinate;
    }

    @Override
    public boolean accept (Movable visitor){
        return (visitor == null)? true : visitor.visit(this);
    }
}
