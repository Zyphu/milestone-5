package model;

import java.util.ArrayDeque;

public interface Player {
    public void setTurn (ArrayDeque<Move> moves);
    public void executeTurn();
}
