package model;

public class Forward implements Move {
    @Override
    public void execute(Turtle player) {
        if (player != null && player.getBoard() != null){    
            Board board = player.getBoard();
            Direction dir = player.getDir();
            Coordinate next = null;
            Coordinate curr = player.getCoordinate();
            if      (dir == Direction.NORTH)  next = new Coordinate(curr.x(),   curr.y()-1);
            else if (dir == Direction.SOUTH)  next = new Coordinate(curr.x(),   curr.y()+1);
            else if (dir == Direction.WEST )  next = new Coordinate(curr.x()-1, curr.y()  );
            else if (dir == Direction.EAST )  next = new Coordinate(curr.x()+1, curr.y()  );
            
            if (board.inBounds(next)){
                Tile tmp = board.getTileAt(next);
                if (tmp == null || tmp.accept(player)) // TODO - make turtle implement movable
                    player.setCoordinate(next);
            }

        }
    }
    
}
