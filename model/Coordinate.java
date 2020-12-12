package model;

public class Coordinate {
    private int xPos, yPos;

    public Coordinate (int x, int y){
        this.xPos = x;
        this.yPos = y;
    }

    public Coordinate (Coordinate c){
        this.xPos = c.xPos;
        this.yPos = c.yPos;
    }

    public int x () {return xPos;}
    public int y () {return yPos;}

    @Override
    public boolean equals(Object other){
        if (this == other) return true;
        if (!(other instanceof Coordinate)) return false;
        
        Coordinate tmp = (Coordinate) other;
        return this.xPos == tmp.xPos && this.yPos == tmp.yPos;
    }
}
