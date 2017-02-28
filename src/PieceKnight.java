import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by caixinzhu on 2/23/17.
 */
public class PieceKnight extends Piece {

    public PieceKnight(String pieceName, String pieceImagePath, int pieceColor, Coordinate pieceCoordinate) {
        super(pieceName, pieceImagePath, pieceColor, pieceCoordinate);
    }
    @Override
    public void findAvailablePosition(Board board) {
        Move temp = new Move(this.coordinate);

        // move to east
        temp.moveToNorthWest();
        temp.moveToWest();
        isValidPosition(temp, board);


        // move to west
        temp = new Move(this.coordinate);
        temp.moveToNorthWest();
        temp.moveToNorth();
        isValidPosition(temp, board);

        // move to north
        temp = new Move(this.coordinate);
        temp.moveToNorthEast();
        temp.moveToNorth();
        isValidPosition(temp, board);

        // move to northeast
        temp = new Move(this.coordinate);
        temp.moveToNorthEast();
        temp.moveToEast();
        isValidPosition(temp, board);

        // move to northWest
        temp = new Move(this.coordinate);
        temp.moveToSouthEast();
        temp.moveToSouth();
        isValidPosition(temp, board);

        temp = new Move(this.coordinate);
        temp.moveToSouthEast();
        temp.moveToEast();
        isValidPosition(temp, board);

        // move to south
        temp = new Move(this.coordinate);
        temp.moveToSouthWest();
        temp.moveToSouth();
        isValidPosition(temp, board);

        // move to southWest
        temp = new Move(this.coordinate);
        temp.moveToSouthWest();
        temp.moveToWest();
        isValidPosition(temp, board);
    }
}


