package model;

import java.util.ArrayDeque;

public interface Player extends Coloured {
    public void setTurn (ArrayDeque<Move> moves);
    public void executeTurn();
    public boolean hasWon ();
    public void won ();
}
