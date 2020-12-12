package model;

public class Right implements Move {
    @Override
    public void execute(Turtle player) {
        switch(player.getDir()){
            case NORTH: player.setDir(Direction.EAST);  return;
            case SOUTH: player.setDir(Direction.WEST);  return;
            case EAST:  player.setDir(Direction.SOUTH); return;
            case WEST:  player.setDir(Direction.WEST);  return;
        }
    }
}
