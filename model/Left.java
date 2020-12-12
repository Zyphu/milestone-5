package model;

public class Left implements Move {
    @Override
    public void execute(Turtle player) {
        switch(player.getDir()){
            case NORTH: player.setDir(Direction.WEST);  return;
            case SOUTH: player.setDir(Direction.EAST);  return;
            case EAST:  player.setDir(Direction.NORTH); return;
            case WEST:  player.setDir(Direction.SOUTH); return;
        }
    }
}
