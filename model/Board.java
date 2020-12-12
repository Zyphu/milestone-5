package model;

public interface Board {
    public Tile getTileAt(Coordinate coordinate); 
    public boolean inBounds(Coordinate coordinate);
    public void remove(Tile tile);
}
