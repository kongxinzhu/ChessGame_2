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
    public Move findAvailablePosition(Board board) {
        Move temp;

        // move to east
        temp = new Move(this.coordinate, board.moveToWest(board.moveToNorthWest(this.coordinate)));
        isValidPosition(temp, board);

        // move to west
        temp = new Move(this.coordinate, board.moveToNorthWest(board.moveToNorth(this.coordinate)));
        isValidPosition(temp, board);

        // move to north
        temp = new Move(this.coordinate, board.moveToNorthEast(board.moveToNorth(this.coordinate)));
        isValidPosition(temp, board);

        // move to northeast
        temp = new Move(this.coordinate, board.moveToNorthEast(board.moveToEast(this.coordinate)));
        isValidPosition(temp, board);

        // move to northWest
        temp = new Move(this.coordinate, board.moveToSouthEast(board.moveToSouth(this.coordinate)));
        isValidPosition(temp, board);

        // move to southEast
        temp = new Move(this.coordinate, board.moveToSouthEast(board.moveToEast(this.coordinate)));
        isValidPosition(temp, board);


        // move to south
        temp = new Move(this.coordinate, board.moveToSouthWest(board.moveToSouth(this.coordinate)));
        isValidPosition(temp, board);

        // move to southWest
        temp = new Move(this.coordinate, board.moveToSouthWest(board.moveToWest(this.coordinate)));
        isValidPosition(temp, board);

        return board.availableMove.peek();
    }
}


