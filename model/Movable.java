package model;

// If make abstract, must make tiles an interface...
public interface Movable {
    public boolean visit (Portal tile);
    public boolean visit (StoneWall tile);
    public boolean visit (IceWall tile);
    // public boolean visit (Crate tile);
    public boolean visit (Jewel tile);
    public boolean visit (Turtle tile);
    public void setCoordinate(Coordinate coordinate);
}
