package model;

// TODO - run checks
public abstract class Movable implements Tile {
    private Coordinate curr;
    private Board board;

    public Movable (Board board, Coordinate coordinate){
        this.board = board;
        this.curr = coordinate;
    }

    @Override
    public Coordinate getCoordinate (){
        return curr;
    }

    public void setCoordinate(Coordinate coordinate){
        this.curr = coordinate;
    }

    public boolean forward (Direction dir){
        if (dir == null) return false;
        Coordinate next = null;
        if      (dir == Direction.NORTH)  next = new Coordinate(curr.x(),   curr.y()-1);
        else if (dir == Direction.SOUTH)  next = new Coordinate(curr.x(),   curr.y()+1);
        else if (dir == Direction.WEST )  next = new Coordinate(curr.x()-1, curr.y()  );
        else if (dir == Direction.EAST )  next = new Coordinate(curr.x()+1, curr.y()  );
        if (next != null && board.inBounds(next)){
            Tile boardTile = board.getTileAt(next);
            if (boardTile == null || boardTile.accept(this)){
                this.curr = (boardTile instanceof Portal)? new Coordinate(((Portal) boardTile).getExiCoordinate()) : next;
                return true;
            }
        }
        return false;
    }

    public boolean visit (Crate tile){
        if (tile == null) return true;
        if ((curr.y() - tile.getCoordinate().y()) == -1) return tile.forward(Direction.SOUTH);
        if ((curr.y() - tile.getCoordinate().y()) ==  1) return tile.forward(Direction.NORTH);
        if ((curr.x() - tile.getCoordinate().x()) == -1) return tile.forward(Direction.EAST);
        if ((curr.x() - tile.getCoordinate().x()) ==  1) return tile.forward(Direction.WEST);
        
        return true;
    }

    public boolean visit (Jewel tile){
        if (tile == null) return true;
        return this instanceof Turtle;
    }

    public boolean visit (IceWall tile){
        if(tile == null) return true;
        return tile.melted();
    }

    public boolean visit (Portal tile){
        return true;
    }

    public boolean visit (StoneWall tile){
        return false;
    }

    public boolean visit (Turtle tile){
        return false;
    }
    
}
