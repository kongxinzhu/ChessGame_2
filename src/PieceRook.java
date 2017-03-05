import java.util.Collections;

/**
 * Created by caixinzhu on 2/23/17.
 */
public class PieceRook extends Piece {

    public PieceRook(String pieceName, String pieceImagePath, int pieceColor, Coordinate pieceCoordinate) {
        super(pieceName, pieceImagePath, pieceColor, pieceCoordinate);
    }

    @Override
    public Move findAvailablePosition(Board board) {

        Move temp;

        // move to east
        temp = new Move(this.coordinate, board.moveToEast(this.coordinate));
        while (isValidPosition(temp, board) && !temp.captureOpposite) {
            temp = new Move(this.coordinate, board.moveToEast(temp.endCoordinate));
        }

        // move to west
        temp = new Move(this.coordinate, board.moveToWest(this.coordinate));
        while (isValidPosition(temp, board) && !temp.captureOpposite) {
            temp = new Move(this.coordinate, board.moveToWest(temp.endCoordinate));
        }

        // move to north
        temp = new Move(this.coordinate, board.moveToNorth(this.coordinate));
        while (isValidPosition(temp, board) && !temp.captureOpposite) {
            temp = new Move(this.coordinate, board.moveToNorth(temp.endCoordinate));
        }

        // move to south
        temp = new Move(this.coordinate, board.moveToSouth(this.coordinate));
        while (isValidPosition(temp, board) && !temp.captureOpposite) {
            temp = new Move(this.coordinate, board.moveToSouth(temp.endCoordinate));
        }

        Collections.sort(board.availableMove, new MoveComparator(board));
        return board.availableMove.peek();
    }

}


