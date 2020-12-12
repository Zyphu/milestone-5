package model;

public class Portal implements Tile, Teleport {
    private Portal exit;
    private Coordinate coordinate;

    private Portal (Coordinate c, Portal exit){
        this.coordinate = c;
        this.exit = exit;
    }

    public Portal (Coordinate mine, Coordinate exitCoordinate){
        this.coordinate = mine;
        this.exit = new Portal(exitCoordinate, this);
    }

    public Portal getExitPortal(){
        return exit;
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
    public Coordinate getExiCoordinate() {
        return (exit == null)? null: exit.getCoordinate();
    }

    
}
