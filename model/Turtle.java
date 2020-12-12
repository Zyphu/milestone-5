package model;

// TODO - implements Movable
public class Turtle extends ColouredTile implements Orientable {
    private Direction direction;
    private Board board;
    private Move[] moves = null;

    public Turtle (Coordinate coordinate, Colour colour, Direction direction, Board board){
        super(coordinate, colour);
        this.direction = direction;
        this.board = board;
    }

    public Board getBoard (){
        return board;
    }

    public Direction getDir() {
        return direction;
    }

    public void setDir (Direction direction){
        this.direction = direction;
    }

    public void setTurn (Move[] moves){
        this.moves = moves;
    }

    public void executeTurn(){
        if (moves != null)
            for (Move move : moves) move.execute(this);
    }

    public void setCoordinate (Coordinate coordinate){
        this.coordinate = coordinate;
    }

    // @Override
    // public boolean visit(Portal tile) {
    //     // TODO Auto-generated method stub
    //     return false;
    // }

    // @Override
    // public boolean visit(StoneWall tile) {
    //     // TODO Auto-generated method stub
    //     return false;
    // }

    // @Override
    // public boolean visit(IceWall tile) {
    //     // TODO Auto-generated method stub
    //     return false;
    // }

    // @Override
    // public boolean visit(Jewel tile) {
    //     // TODO Auto-generated method stub
    //     return false;
    // }

    // // @Override
    // // public boolean visit(Turtle tile) {
    // //     // TODO Auto-generated method stub
    // //     return false;
    // // }

    @Override
    public boolean accept(Movable visitor) {
        return visitor.visit(this);
    }

    // @Override
    // public boolean accept(Turtle player) {
    //     // TODO Auto-generated method stub
    //     return false;
    // }

}
