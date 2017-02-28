import java.util.ArrayList;
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

    public boolean isValidPosition(Move move, Board board){
        boolean added = false;
        if(move.inBoard()) {
            if(board.boardTrace[move.row][move.col] != null && board.boardTrace[move.row][move.col].color != board.selectedPiece.color) {
                move.captureOpposite = true;
                board.availableMove.add(move);
                added = true;
            } else if(board.boardTrace[move.row][move.col] == null) {
                board.availableMove.add(move);
                added = true;
            }
        }
        return added;
    }

    public abstract void findAvailablePosition(Board board);
    public void upDateCoordinate(Coordinate newCoordinate) {
        this.coordinate = newCoordinate;
    }
}
