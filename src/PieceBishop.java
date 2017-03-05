import java.util.Collection;
import java.util.Collections;

/**
 * Created by caixinzhu on 2/23/17.
 */

/*
 * PieceBishop inherits from Piece Class
 * method findAvailablePosition is to find available Move from specific bishop on current board
 * the available moves are stored in Board instance
 *
 * there is a list named availableMove in Board Class
 */

public class PieceBishop extends Piece {

    public PieceBishop(String pieceName, String pieceImagePath, int pieceColor, Coordinate pieceCoordinate) {
        super(pieceName, pieceImagePath, pieceColor, pieceCoordinate);
    }

    @Override
    public Move findAvailablePosition(Board board) {
        Move temp;

        // move to northEast
        temp = new Move(this.coordinate, board.moveToNorthEast(this.coordinate));
        while (isValidPosition(temp, board) && !temp.captureOpposite) {
            temp = new Move(this.coordinate,board.moveToNorthEast(temp.endCoordinate));
        }

        // move to northWest
        temp = new Move(this.coordinate, board.moveToNorthWest(this.coordinate));
        while (isValidPosition(temp, board) && !temp.captureOpposite) {
            temp = new Move(this.coordinate, board.moveToNorthWest(temp.endCoordinate));
        }

        // move to southWest
        temp = new Move(this.coordinate, board.moveToSouthWest(this.coordinate));
        while (isValidPosition(temp, board) && !temp.captureOpposite) {
            temp = new Move(this.coordinate, board.moveToSouthWest(temp.endCoordinate));
        }

        // move to southEast
        temp = new Move(this.coordinate, board.moveToSouthEast(this.coordinate));
        while (isValidPosition(temp, board) && !temp.captureOpposite) {
            temp = new Move(this.coordinate, board.moveToSouthEast(temp.endCoordinate));
        }

        Collections.sort(board.availableMove, new MoveComparator(board));
        return board.availableMove.peek();
    }
}