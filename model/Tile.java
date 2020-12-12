package model;

public interface Tile {
    public Coordinate getCoordinate ();
    public boolean accept(Movable visitor);
}
