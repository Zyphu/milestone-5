package model;

public class Forward implements Move {
    @Override
    public void execute(Turtle player) {
        player.forward(player.getDir());
    }
    
}
