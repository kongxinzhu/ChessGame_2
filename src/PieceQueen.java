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
    public Move findAvailablePosition(Board board) {
        // move to east
        Move temp = new Move(board.moveToEast(this.coordinate));
        while (isValidPosition(temp, board)) {
            temp = new Move(board.moveToEast(temp.coordinate));
        }

        // move to west
        temp = new Move(board.moveToWest(this.coordinate));
        while (isValidPosition(temp, board)) {
            temp = new Move(board.moveToWest(temp.coordinate));
        }

        // move to north
        temp = new Move(board.moveToNorth(this.coordinate));
        while (isValidPosition(temp, board)) {
            temp = new Move(board.moveToNorth(temp.coordinate));
        }

        // move to northeast
        temp = new Move(board.moveToNorthEast(this.coordinate));
        while (isValidPosition(temp, board)) {
            temp = new Move(board.moveToNorthEast(temp.coordinate));
        }

        // move to northWest
        temp = new Move(board.moveToNorthWest(this.coordinate));
        while (isValidPosition(temp, board)) {
            temp = new Move(board.moveToNorthWest(temp.coordinate));
        }

        // move to south
        temp = new Move(board.moveToSouth(this.coordinate));
        while (isValidPosition(temp, board)) {
            temp = new Move(board.moveToSouth(temp.coordinate));
        }

        // move to southWest
        temp = new Move(board.moveToSouthWest(this.coordinate));
        while (isValidPosition(temp, board)) {
            temp = new Move(board.moveToSouthWest(temp.coordinate));
        }

        // move to southeast
        temp = new Move(board.moveToSouthEast(this.coordinate));
        while (isValidPosition(temp, board)) {
            temp = new Move(board.moveToSouthEast(temp.coordinate));
        }

        return board.availableMove.peek();
    }
}


