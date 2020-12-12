package model;

public interface Board {
    public Tile getTileAt(Coordinate coordinate); // TODO returns players first, jewels, then anything else
    public boolean inBounds(Coordinate coordinate);
}
