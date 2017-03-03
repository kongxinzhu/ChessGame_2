/**
 * Created by caixinzhu on 2/23/17.
 */
public class PieceRook extends Piece {

    public PieceRook(String pieceName, String pieceImagePath, int pieceColor, Coordinate pieceCoordinate) {
        super(pieceName, pieceImagePath, pieceColor, pieceCoordinate);
    }
    @Override
    public Move findAvailablePosition(Board board) {

        Move temp = new Move(this.coordinate, board.moveToEast(this.coordinate));

        // move to east
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

        // move to south
        temp = new Move(this.coordinate, board.moveToSouth(this.coordinate));
        while (isValidPosition(temp, board)) {
            temp = new Move(this.coordinate, board.moveToSouth(temp.endCoordinate));
        }

        return board.availableMove.peek();
    }

}


