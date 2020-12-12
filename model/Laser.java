package model;

public class Laser implements Move {
    @Override
    public void execute(Turtle player) {
        Tile toMelt = player.getBoard().getTileAt(player.getCoordinate().toward(player.getDir()));
        if (toMelt instanceof Meltable)
            ((Meltable)toMelt).melt();
    }
    
}
