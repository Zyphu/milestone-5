package model;

public class Portal extends Tile {
    private Portal exit;

    private Portal (Coordinate c, Portal exit){
        super(c);
        this.exit = exit;
    }

    public Portal (Coordinate mine, Coordinate exit){
        super(mine);
        this.exit = new Portal(exit, this);
    }

    public Portal getExitPortal(){
        return exit;
    }

    public boolean accept (Movable visitor){
        return visitor.visit(this);
    }
}
