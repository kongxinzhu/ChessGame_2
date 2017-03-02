/**
 * Created by caixinzhu on 2/23/17.
 */
public class PieceRook extends Piece {

    public PieceRook(String pieceName, String pieceImagePath, int pieceColor, Coordinate pieceCoordinate) {
        super(pieceName, pieceImagePath, pieceColor, pieceCoordinate);
    }
    @Override
    public Move findAvailablePosition(Board board) {

        Move temp = new Move(board.moveToEast(this.coordinate));

        // move to east
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

        // move to south
        temp = new Move(board.moveToSouth(this.coordinate));
        while (isValidPosition(temp, board)) {
            temp = new Move(board.moveToSouth(temp.coordinate));
        }

        return board.availableMove.peek();
    }

}


