package model;

// TODO - run checks
public abstract class Movable implements Tile {
    private Coordinate curr, next;
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

    public Board getBoard (){
        return board;
    }

    public boolean forward (Direction dir){ 
        if (dir == null) return false;
        next = this.curr.toward(dir);
        if (next != null && board.inBounds(next)){
            Tile nextBoardTile = board.getTileAt(next);
            if (nextBoardTile == null || nextBoardTile.accept(this)){
                curr = next;
                return true;
            }
        }
        return false;
    }

    public boolean visit (Portal tile){
        if (tile == null) return true;
        if (this instanceof Teleportable) {
            Tile atExit = board.getTileAt(tile.getExiCoordinate());
            if (atExit != null && !(atExit instanceof Teleportable)){
                next = tile.getExiCoordinate();
                return true;
            }
        }
        return false;
    }

    // TODO might need to use getClass instead check
    public boolean visit (Crate tile){
        if (tile == null) return true;
        return (this instanceof Pusher)? tile.forward(((Pusher) this).getDir()) : false;
    }

    public boolean visit (Jewel tile){
        if (tile == null) return true;
        if (this instanceof Turtle){
            ((Turtle)this).won();
            board.remove(tile);
            board.remove(this);
            return true;
        }
        return false;
    }

    public boolean visit (IceWall tile){
        if(tile == null) return true;
        return tile.melted();
    }

    public boolean visit (StoneWall tile){
        return false;
    }

    public boolean visit (Turtle tile){
        return false;
    }
    
}
