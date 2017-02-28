import java.util.LinkedList;

/**
 * Created by caixinzhu on 2/23/17.
 */
public class PieceBishop extends Piece {

    public PieceBishop(String pieceName, String pieceImagePath, int pieceColor, Coordinate pieceCoordinate) {
        super(pieceName, pieceImagePath, pieceColor, pieceCoordinate);
    }

    @Override
    public void findAvailablePosition(Board board) {
        Move temp = new Move(this.coordinate);

        // move to northEast
        temp.moveToNorthEast();
        while (isValidPosition(temp, board) && !temp.captureOpposite) {
            temp = new Move(temp);
            temp.moveToNorthEast();
        }

        // move to northWest
        temp = new Move(this.coordinate);
        temp.moveToNorthWest();
        while (isValidPosition(temp, board) && !temp.captureOpposite) {
            temp = new Move(temp);
            temp.moveToNorthWest();
        }

        // move to southWest
        temp = new Move(this.coordinate);
        temp.moveToSouthWest();
        while (isValidPosition(temp, board) && !temp.captureOpposite) {
            temp = new Move(temp);
            temp.moveToSouthWest();
        }

        // move to southEast
        temp = new Move(this.coordinate);
        temp.moveToSouthEast();
        while (isValidPosition(temp, board) && !temp.captureOpposite) {
            temp = new Move(temp);
            temp.moveToSouthEast();
        }
    }
}


