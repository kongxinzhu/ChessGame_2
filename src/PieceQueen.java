import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * Created by caixinzhu on 2/23/17.
 */
public class PieceQueen extends Piece {

    public PieceQueen(String pieceName, String pieceImagePath, int pieceColor, Coordinate pieceCoordinate) {
        super(pieceName, pieceImagePath, pieceColor, pieceCoordinate);
    }

    @Override
    public Move findAvailablePosition(Board board) {
        // move to east
        Move temp = new Move(this.coordinate, board.moveToEast(this.coordinate));
        while (isValidPosition(temp, board)) {
            temp = new Move(this.coordinate, board.moveToEast(temp.endCoordinate));
        }

        // move to west
        temp = new Move(this.coordinate, board.moveToWest(this.coordinate));
        while (isValidPosition(temp, board)) {
            temp = new Move(this.coordinate, board.moveToWest(temp.endCoordinate));
        }

        // move to north
        temp = new Move(this.coordinate, board.moveToNorth(this.coordinate));
        while (isValidPosition(temp, board)) {
            temp = new Move(this.coordinate, board.moveToNorth(temp.endCoordinate));
        }

        // move to northeast
        temp = new Move(this.coordinate, board.moveToNorthEast(this.coordinate));
        while (isValidPosition(temp, board)) {
            temp = new Move(this.coordinate, board.moveToNorthEast(temp.endCoordinate));
        }

        // move to northWest
        temp = new Move(this.coordinate, board.moveToNorthWest(this.coordinate));
        while (isValidPosition(temp, board)) {
            temp = new Move(this.coordinate, board.moveToNorthWest(temp.endCoordinate));
        }

        // move to south
        temp = new Move(this.coordinate, board.moveToSouth(this.coordinate));
        while (isValidPosition(temp, board)) {
            temp = new Move(this.coordinate, board.moveToSouth(temp.endCoordinate));
        }

        // move to southWest
        temp = new Move(this.coordinate, board.moveToSouthWest(this.coordinate));
        while (isValidPosition(temp, board)) {
            temp = new Move(this.coordinate, board.moveToSouthWest(temp.endCoordinate));
        }

        // move to southeast
        temp = new Move(this.coordinate, board.moveToSouthEast(this.coordinate));
        while (isValidPosition(temp, board)) {
            temp = new Move(this.coordinate, board.moveToSouthEast(temp.endCoordinate));
        }

        Collections.sort(board.availableMove, new MoveComparator(board));
        return board.availableMove.peek();
    }
}


