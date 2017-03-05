import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * Created by caixinzhu on 2/23/17.
 */

/*
 * PiecePawn inherits from Piece Class
 * method findAvailablePosition is to find available Move from specific pawn on current board
 * the available moves are stored in Board instance
 *
 * there is a list named availableMove in Board Class
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
            temp = new Move(this.coordinate, board.moveToNorth(this.coordinate));
            boolean added = isValidPosition(temp, board);

            // check if it's the first movement of this pawn
            if (added && temp.startCoordinate.row == 6 && temp.captureOpposite == false) {
                temp = new Move(this.coordinate,board.moveToNorth(temp.endCoordinate));
                isValidPosition(temp, board);
            }

            // check if there is any opposite's piece in the valid range of this pawn
            temp = new Move(this.coordinate, board.moveToNorthWest(this.coordinate));
            if (temp.endCoordinate != board.OUTOFBOARD && board.alivePieces.containsKey(temp.endCoordinate) && board.alivePieces.get(temp.endCoordinate).color != this.color) {
                temp.captureOpposite = true;
                board.availableMove.add(temp);
            }

            temp = new Move(this.coordinate,board.moveToNorthEast(this.coordinate));
            if (temp.endCoordinate != board.OUTOFBOARD && board.alivePieces.containsKey(temp.endCoordinate) && board.alivePieces.get(temp.endCoordinate).color != this.color) {
                temp.captureOpposite = true;
                board.availableMove.add(temp);
            }
        }


        // move to west
        if (color == BLACK) {
            temp = new Move(this.coordinate, board.moveToSouth(this.coordinate));
            boolean added = isValidPosition(temp, board);

            // check if it's the first movement of this pawn
            if (added && temp.startCoordinate.row == 1 && temp.captureOpposite == false) {
                temp = new Move(this.coordinate,board.moveToSouth(temp.endCoordinate));
                isValidPosition(temp, board);
            }

            // check if there is any opposite's piece in the valid range of this pawn
            temp = new Move(this.coordinate, board.moveToSouthWest(this.coordinate));
            if (temp.endCoordinate != board.OUTOFBOARD && board.alivePieces.containsKey(temp.endCoordinate) && board.alivePieces.get(temp.endCoordinate).color != this.color) {
                temp.captureOpposite = true;
                board.availableMove.add(temp);
            }

            temp = new Move(this.coordinate, board.moveToSouthEast(this.coordinate));
            if (temp.endCoordinate != board.OUTOFBOARD && board.alivePieces.containsKey(temp.endCoordinate) && board.alivePieces.get(temp.endCoordinate).color != this.color) {
                temp.captureOpposite = true;
                board.availableMove.add(temp);
            }
        }
        Collections.sort(board.availableMove, new MoveComparator(board));
        return board.availableMove.peek();
    }

    @Override
    public boolean isValidPosition(Move move, Board board) {
        boolean added = false;
        if (move.endCoordinate != board.OUTOFBOARD && !board.alivePieces.containsKey(move.endCoordinate)) {
            board.availableMove.add(move);
            added = true;
        }
        return added;
    }
}


