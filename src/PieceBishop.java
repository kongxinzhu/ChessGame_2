import java.util.LinkedList;

/**
 * Created by caixinzhu on 2/23/17.
 */
public class PieceBishop extends Piece {

    public PieceBishop(String pieceName, String pieceImagePath, int pieceColor, Coordinate pieceCoordinate) {
        super(pieceName, pieceImagePath, pieceColor, pieceCoordinate);
    }

    @Override
    public Move findAvailablePosition(Board board) {
        Move temp = new Move(board.moveToNorthEast(this.coordinate));

        // move to northEast
        while (isValidPosition(temp, board) && !temp.captureOpposite) {
            temp = new Move(board.moveToNorthEast(temp.coordinate));
        }

        // move to northWest
        temp = new Move(board.moveToNorthWest(this.coordinate));
        while (isValidPosition(temp, board) && !temp.captureOpposite) {
            temp = new Move(board.moveToNorthWest(temp.coordinate));
        }

        // move to southWest
        temp = new Move(board.moveToSouthWest(this.coordinate));
        while (isValidPosition(temp, board) && !temp.captureOpposite) {
            temp = new Move(board.moveToSouthWest(temp.coordinate));
        }

        // move to southEast
        temp = new Move(board.moveToSouthEast(this.coordinate));
        while (isValidPosition(temp, board) && !temp.captureOpposite) {
            temp = new Move(board.moveToSouthEast(temp.coordinate));
        }

        return board.availableMove.peek();
    }
}


