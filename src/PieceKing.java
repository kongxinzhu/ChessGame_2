import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by caixinzhu on 2/23/17.
 */
public class PieceKing extends Piece {

    public PieceKing(String pieceName, String pieceImagePath, int pieceColor, Coordinate pieceCoordinate) {
        super(pieceName, pieceImagePath, pieceColor, pieceCoordinate);
    }

    @Override
    public void findAvailablePosition(Board board) {
        Move temp = new Move(this.coordinate);

        // move to east
        temp.moveToEast();
        isValidPosition(temp, board);


        // move to west
        temp = new Move(this.coordinate);
        temp.moveToWest();
        isValidPosition(temp, board);

        // move to north
        temp = new Move(this.coordinate);
        temp.moveToNorth();
        isValidPosition(temp, board);

        // move to northeast
        temp = new Move(this.coordinate);
        temp.moveToNorthEast();
        isValidPosition(temp, board);

        // move to northWest
        temp = new Move(this.coordinate);
        temp.moveToNorthWest();
        isValidPosition(temp, board);

        // move to south
        temp = new Move(this.coordinate);
        temp.moveToSouth();
        isValidPosition(temp, board);

        // move to southWest
        temp = new Move(this.coordinate);
        temp.moveToSouthWest();
        isValidPosition(temp, board);

        // move to southeast
        temp = new Move(this.coordinate);
        temp.moveToSouthEast();
        isValidPosition(temp, board);
    }
}


