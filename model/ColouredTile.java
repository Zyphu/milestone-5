package model;

public abstract class ColouredTile extends Tile {
    private Colour colour;
    
    public ColouredTile(Coordinate coordinate, Colour colour){
        super(coordinate);
        this.colour = colour;
    }

    public Colour getColour (){
        return colour;
    }

}
