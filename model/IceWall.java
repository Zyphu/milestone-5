package model;

public class IceWall extends Tile implements Meltable{
    private boolean frozen = true;

    public IceWall (Coordinate coordinate){
        super(coordinate);
    }
    
    public boolean accept (Movable visitor){
        return visitor.visit(this);
    }

    public boolean melted (){
        return !frozen;
    }

    public void melt (){ 
        frozen = false;
    }
}
