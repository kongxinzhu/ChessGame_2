import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by caixinzhu on 2/23/17.
 */
public class PiecePawn extends Piece {

    public PiecePawn(String pieceName, String pieceImagePath, int pieceColor, Coordinate pieceCoordinate) {
        super(pieceName, pieceImagePath, pieceColor, pieceCoordinate);
    }

    @Override
    public void findAvailablePosition(Board board) {
        Move temp = new Move(this.coordinate);

        // white
        if (color == WHITE) {
            temp.moveToNorth();
            boolean added = isValidPosition(temp, board);

            // check if it's the first movement of this pawn
            if (added && temp.row == 5 && temp.captureOpposite == false) {
                temp = new Move(temp.row, temp.col, false);
                temp.moveToNorth();
                isValidPosition(temp, board);
            }

            // check if there is any opposite's piece in the valid range of this pawn
            temp = new Move(this.coordinate);
            temp.moveToNorthWest();
            if (temp.inBoard() && board.alivePieces.containsKey(temp) && board.alivePieces.get(temp).color != this.color) {
                temp.captureOpposite = true;
                board.availableMove.add(temp);
            }

            temp = new Move(this.coordinate);
            temp.moveToNorthEast();
            if (temp.inBoard() && board.alivePieces.containsKey(temp) && board.alivePieces.get(temp).color != this.color) {
                temp.captureOpposite = true;
                board.availableMove.add(temp);
            }
        }


        // move to west
        if (color == BLACK) {
            temp.moveToSouth();
            boolean added = isValidPosition(temp, board);

            // check if it's the first movement of this pawn
            if (added && temp.row == 2 && temp.captureOpposite == false) {
                temp = new Move(temp.row, temp.col, false);
                temp.moveToSouth();
                isValidPosition(temp, board);
            }

            // check if there is any opposite's piece in the valid range of this pawn
            temp = new Move(this.coordinate);
            temp.moveToSouthWest();
            if (temp.inBoard() && board.alivePieces.containsKey(temp) && board.alivePieces.get(temp).color != this.color) {
                temp.captureOpposite = true;
                board.availableMove.add(temp);
            }

            temp = new Move(this.coordinate);
            temp.moveToSouthEast();
            if (temp.inBoard() && board.alivePieces.containsKey(temp) && board.alivePieces.get(temp).color != this.color) {
                temp.captureOpposite = true;
                board.availableMove.add(temp);
            }
        }


    }

    @Override
    public boolean isValidPosition(Move move, Board board) {
        boolean added = false;
        if (move.inBoard() && !board.alivePieces.containsKey(move)) {
            board.availableMove.add(move);
            added = true;
        }
        return added;
    }
}


