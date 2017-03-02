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
    public Move findAvailablePosition(Board board) {
        Move temp;

        // white
        if (color == WHITE) {
            temp = new Move(board.moveToNorth(this.coordinate));
            boolean added = isValidPosition(temp, board);

            // check if it's the first movement of this pawn
            if (added && temp.coordinate.row == 5 && temp.captureOpposite == false) {
                temp = new Move(board.moveToNorth(temp.coordinate));
                isValidPosition(temp, board);
            }

            // check if there is any opposite's piece in the valid range of this pawn
            temp = new Move(board.moveToNorthWest(this.coordinate));
            if (temp != null && board.alivePieces.containsKey(temp) && board.alivePieces.get(temp).color != this.color) {
                temp.captureOpposite = true;
                board.availableMove.add(temp);
            }

            temp = new Move(board.moveToNorthEast(this.coordinate));
            if (temp != null && board.alivePieces.containsKey(temp) && board.alivePieces.get(temp).color != this.color) {
                temp.captureOpposite = true;
                board.availableMove.add(temp);
            }
        }


        // move to west
        if (color == BLACK) {
            temp = new Move(board.moveToSouth(this.coordinate));
            boolean added = isValidPosition(temp, board);

            // check if it's the first movement of this pawn
            if (added && temp.coordinate.row == 2 && temp.captureOpposite == false) {
                temp = new Move(board.moveToSouth(temp.coordinate));
                isValidPosition(temp, board);
            }

            // check if there is any opposite's piece in the valid range of this pawn
            temp = new Move(board.moveToSouthWest(this.coordinate));
            if (temp != null && board.alivePieces.containsKey(temp) && board.alivePieces.get(temp).color != this.color) {
                temp.captureOpposite = true;
                board.availableMove.add(temp);
            }

            temp = new Move(board.moveToSouthEast(this.coordinate));
            if (temp != null && board.alivePieces.containsKey(temp) && board.alivePieces.get(temp).color != this.color) {
                temp.captureOpposite = true;
                board.availableMove.add(temp);
            }
        }

        return board.availableMove.peek();
    }

    @Override
    public boolean isValidPosition(Move move, Board board) {
        boolean added = false;
        if (move.coordinate != board.OUTOFBOARD && !board.alivePieces.containsKey(move.coordinate)) {
            board.availableMove.add(move);
            added = true;
        }
        return added;
    }
}


