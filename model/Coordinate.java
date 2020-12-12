package model;

public class Coordinate {
    private int xPos, yPos;

    public Coordinate (int x, int y){
        this.xPos = x;
        this.yPos = y;
    }

    public int x () {return xPos;}
    public int y () {return yPos;}

    public Coordinate toward (Direction dir){
        switch(dir){
            case NORTH: return new Coordinate(xPos, yPos-1); 
            case SOUTH: return new Coordinate(xPos , yPos+1);
            case WEST:  return new Coordinate(xPos-1, yPos );
            case EAST:  return new Coordinate(xPos+1, yPos );
        }
        return null;
    }

    @Override
    public boolean equals(Object other){
        if (this == other) return true;
        if (!(other instanceof Coordinate)) return false;
        
        Coordinate tmp = (Coordinate) other;
        return this.xPos == tmp.xPos && this.yPos == tmp.yPos;
    }
}
