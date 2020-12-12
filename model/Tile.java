package model;

public abstract class Tile {

    protected Coordinate coordinate;
    
    public Tile (Coordinate coordinate){
        this.coordinate = coordinate;
    }

    public Coordinate getCoordinate (){
        return coordinate;
    }

    // public void setCoordinate(Coordinate coordinate){
    //     coord = coordinate;
    // } // TODO might need to add back

    public abstract boolean accept(Movable visitor);
}
