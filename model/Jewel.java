package model;

public class Jewel implements Tile, Coloured {
    private Colour colour;
    private Coordinate coordinate;

    public Jewel (Coordinate coordinate, Colour colour){
        this.colour = colour;
        this.coordinate = coordinate;
    }

    @Override
    public Coordinate getCoordinate() {
        return coordinate;
    }

    @Override
    public boolean accept (Movable visitor){
        return (visitor == null)? true : visitor.visit(this);
    }

    @Override
    public Colour getColour() {
        return colour;
    }

    @Override
    public char textIcon() {
        return 'J';
    }
}
