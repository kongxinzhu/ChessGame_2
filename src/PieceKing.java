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
    public Move findAvailablePosition(Board board) {
        Move temp;

        // move to east
        temp = new Move(board.moveToEast(this.coordinate));
        isValidPosition(temp, board);

        // move to west
        temp = new Move(board.moveToWest(this.coordinate));
        isValidPosition(temp, board);

        // move to north
        temp = new Move(board.moveToNorth(this.coordinate));
        isValidPosition(temp, board);


        // move to northeast
        temp = new Move(board.moveToNorthEast(this.coordinate));
        isValidPosition(temp, board);

        // move to northWest
        temp = new Move(board.moveToNorthWest(this.coordinate));
        isValidPosition(temp, board);

        // move to south
        temp = new Move(board.moveToSouth(this.coordinate));
        isValidPosition(temp, board);


        // move to southWest
        temp = new Move(board.moveToSouthWest(this.coordinate));
        isValidPosition(temp, board);

        // move to southeast
        temp = new Move(board.moveToSouthEast(this.coordinate));
        isValidPosition(temp, board);

        return board.availableMove.peek();
    }
}


