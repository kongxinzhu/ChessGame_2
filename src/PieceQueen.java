import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by caixinzhu on 2/23/17.
 */
public class PieceQueen extends Piece {

    public PieceQueen(String pieceName, String pieceImagePath, int pieceColor, Coordinate pieceCoordinate) {
        super(pieceName, pieceImagePath, pieceColor, pieceCoordinate);
    }

    @Override
    public void findAvailablePosition(Board board) {
        Move temp = new Move(this.coordinate);

        // move to east
        temp.moveToEast();
        while (isValidPosition(temp, board)) {
            temp = new Move(temp);
            temp.moveToEast();
        }

        // move to west
        temp = new Move(this.coordinate);
        temp.moveToWest();
        while (isValidPosition(temp, board)) {
            temp = new Move(temp);
            temp.moveToWest();
        }

        // move to north
        temp = new Move(this.coordinate);
        temp.moveToNorth();
        while (isValidPosition(temp, board)) {
            temp = new Move(temp);
            temp.moveToNorth();
        }

        // move to northeast
        temp = new Move(this.coordinate);
        temp.moveToNorthEast();
        while (isValidPosition(temp, board)) {
            temp = new Move(temp);
            temp.moveToNorthEast();
        }

        // move to northWest
        temp = new Move(this.coordinate);
        temp.moveToNorthWest();
        while (isValidPosition(temp, board)) {
            temp = new Move(temp);
            temp.moveToNorthWest();
        }

        // move to south
        temp = new Move(this.coordinate);
        temp.moveToSouth();
        while (isValidPosition(temp, board)) {
            temp = new Move(temp);
            temp.moveToSouth();
        }

        // move to southWest
        temp = new Move(this.coordinate);
        temp.moveToSouthWest();
        while (isValidPosition(temp, board)) {
            temp = new Move(temp);
            temp.moveToSouthWest();
        }

        // move to southeast
        temp = new Move(this.coordinate);
        temp.moveToSouthEast();
        while (isValidPosition(temp, board)) {
            temp = new Move(temp);
            temp.moveToSouthEast();
        }
    }
}


