package model;

public class IceWall implements Tile, Meltable{
    private Coordinate coordinate;
    private boolean frozen = true;

    public IceWall (Coordinate coordinate){
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
    public boolean melted (){
        return !frozen;
    }

    @Override
    public void melt (){ 
        frozen = false;
    }    
}
