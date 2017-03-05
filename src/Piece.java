import java.util.LinkedList;

/**
 * Created by caixinzhu on 2/23/17.
 */


public abstract class Piece {
    static final int BLACK = 0;
    static final int WHITE = 1;
    String name;
    String imagePath;
    int color;
    Coordinate coordinate;

    // constructor
    public Piece(String pieceName, String pieceImagePath, int pieceColor, Coordinate pieceCoordinate) {
        name = pieceName;
        imagePath = pieceImagePath;
        color = pieceColor;
        coordinate = pieceCoordinate;
    }

    public boolean isValidPosition(Move move, Board board) {
        boolean added = false;
        if (move.endCoordinate != board.OUTOFBOARD) {
            if (board.alivePieces.containsKey(move.endCoordinate) && board.alivePieces.get(move.endCoordinate).color != board.alivePieces.get(move.startCoordinate).color) {
                move.captureOpposite = true;
                board.availableMove.add(move);
                added = true;
            } else if (!board.alivePieces.containsKey(move.endCoordinate)) {
                board.availableMove.add(move);
                added = true;
            }
        }
        return added;
    }


    public abstract Move findAvailablePosition(Board board);

    public void upDateCoordinate(Coordinate newCoordinate) {
        coordinate = newCoordinate;
    }
}