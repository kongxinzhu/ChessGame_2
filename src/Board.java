import java.util.*;
/*
 * Board is back-end of this program
 * Piece's place is changed following MoveList which shows which piece and where it goes
 */

public class Board
//        implements Runnable
{
    static final int BLACK = 0;
    static final int WHITE = 1;

    // coordinate which is out of board
    static final Coordinate OUTOFBOARD = new Coordinate(-1, -1);

    // 64 coordinates on board
    Coordinate[][] coordinates;

    // hint
    Hint hint;

    // valid selected piece
    Piece selectedPiece;

    // Alive piece list on the board
    HashMap<Coordinate, Piece> alivePieces;

    // current valid move position
    LinkedList<Move> availableMove = new LinkedList();

    // odd means white
    // even means black
    int turn;

    // constructor
    public Board() {
        // initialize 64 coordinates
        coordinates = new Coordinate[8][8];
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                coordinates[row][col] = new Coordinate(row, col);
            }
        }

        hint = new Hint(this);
        alivePieces = new HashMap<>();

        // initialize the beginning state of game and store all in alive pieces' list
        // black pieces
        alivePieces.put(coordinates[0][0], new PieceRook("rook", "Icon/black_rook.png", BLACK, coordinates[0][0]));
        alivePieces.put(coordinates[0][1], new PieceKnight("knight", "Icon/black_knight.png", BLACK, coordinates[0][1]));
        alivePieces.put(coordinates[0][2], new PieceBishop("bishop", "Icon/black_bishop.png", BLACK, coordinates[0][2]));
        alivePieces.put(coordinates[0][3], new PieceQueen("queen", "Icon/black_queen.png", BLACK, coordinates[0][3]));
        alivePieces.put(coordinates[0][4], new PieceKing("king", "Icon/black_king.png", BLACK, coordinates[0][4]));
        alivePieces.put(coordinates[0][5], new PieceBishop("black_bishop", "Icon/black_bishop.png", BLACK, coordinates[0][5]));
        alivePieces.put(coordinates[0][6], new PieceKnight("knight", "Icon/black_knight.png", BLACK, coordinates[0][6]));
        alivePieces.put(coordinates[0][7], new PieceRook("rook", "Icon/black_rook.png", BLACK, coordinates[0][7]));

        // pawn
        for (int col = 0; col < 8; col++) {
            alivePieces.put(coordinates[1][col], new PiecePawn("pawn", "Icon/black_pawn.png", BLACK, coordinates[1][col]));
        }

        // white pieces
        alivePieces.put(coordinates[7][0], new PieceRook("rook", "Icon/white_rook.png", WHITE, coordinates[7][0]));
        alivePieces.put(coordinates[7][1], new PieceKnight("knight", "Icon/white_knight.png", WHITE, coordinates[7][1]));
        alivePieces.put(coordinates[7][2], new PieceBishop("bishop", "Icon/white_bishop.png", WHITE, coordinates[7][2]));
        alivePieces.put(coordinates[7][3], new PieceQueen("queen", "Icon/white_queen.png", WHITE, coordinates[7][3]));
        alivePieces.put(coordinates[7][4], new PieceKing("king", "Icon/white_king.png", WHITE, coordinates[7][4]));
        alivePieces.put(coordinates[7][5], new PieceBishop("bishop", "Icon/white_bishop.png", WHITE, coordinates[7][5]));
        alivePieces.put(coordinates[7][6], new PieceKnight("knight", "Icon/white_knight.png", WHITE, coordinates[7][6]));
        alivePieces.put(coordinates[7][7], new PieceRook("rook", "Icon/white_rook.png", WHITE, coordinates[7][7]));

        // pawn
        for (int col = 0; col < 8; col++) {
            alivePieces.put(coordinates[6][col], new PiecePawn("pawn", "Icon/white_pawn.png", WHITE, coordinates[6][col]));
        }

        // turn
        turn = 1;
    }

    public void setSelectedPiece(Piece selectedPiece) {
        this.selectedPiece = selectedPiece;
    }

    // set available move position list
    // by specific required order
    public void setAvailableMove() {
        selectedPiece.findAvailablePosition(this);
        Collections.sort(availableMove, new MoveComparator(this));
    }

    // get the corresponding coordinate in coordinates array by row and col

    public Coordinate getCoordinate(int row, int col) {
        if (row >= 0 && row < 8 && col >= 0 && col < 8) {
            return coordinates[row][col];
        } else return null;
    }

    public void upDatePieceInAlivePieces(Coordinate end) {
        Coordinate start = this.selectedPiece.coordinate;
        this.selectedPiece.upDateCoordinate(end);
        alivePieces.put(end, this.selectedPiece);
        alivePieces.remove(start);
    }


    // move on board
    // return the corresponding coordinate in coordinates array
    public Coordinate moveToWest(Coordinate coordinate) {
        int row = coordinate.row;
        int col = coordinate.col - 1;
        Coordinate returnCoordinate = null;
        if (new Coordinate(row, col).inBoard() && coordinate != OUTOFBOARD) {
            returnCoordinate = getCoordinate(row, col);
        } else {
            returnCoordinate = OUTOFBOARD;
        }
        return returnCoordinate;
    }

    public Coordinate moveToNorthWest(Coordinate coordinate) {
        int row = coordinate.row - 1;
        int col = coordinate.col - 1;
        Coordinate returnCoordinate = null;
        if (new Coordinate(row, col).inBoard() && coordinate != OUTOFBOARD) {
            returnCoordinate = getCoordinate(row, col);
        } else {
            returnCoordinate = OUTOFBOARD;
        }
        return returnCoordinate;
    }

    public Coordinate moveToNorth(Coordinate coordinate) {
        int row = coordinate.row - 1;
        int col = coordinate.col;
        Coordinate returnCoordinate = null;
        if (new Coordinate(row, col).inBoard() && coordinate != OUTOFBOARD) {
            returnCoordinate = getCoordinate(row, col);
        } else {
            returnCoordinate = OUTOFBOARD;
        }
        return returnCoordinate;
    }

    public Coordinate moveToNorthEast(Coordinate coordinate) {
        int row = coordinate.row - 1;
        int col = coordinate.col + 1;
        Coordinate returnCoordinate = null;
        if (new Coordinate(row, col).inBoard() && coordinate != OUTOFBOARD) {
            returnCoordinate = getCoordinate(row, col);
        } else {
            returnCoordinate = OUTOFBOARD;
        }
        return returnCoordinate;
    }

    public Coordinate moveToEast(Coordinate coordinate) {
        int row = coordinate.row;
        int col = coordinate.col + 1;
        Coordinate returnCoordinate = null;
        if (new Coordinate(row, col).inBoard() && coordinate != OUTOFBOARD) {
            returnCoordinate = getCoordinate(row, col);
        } else {
            returnCoordinate = OUTOFBOARD;
        }
        return returnCoordinate;
    }

    public Coordinate moveToSouthEast(Coordinate coordinate) {
        int row = coordinate.row + 1;
        int col = coordinate.col + 1;
        Coordinate returnCoordinate = null;
        if (new Coordinate(row, col).inBoard() && coordinate != OUTOFBOARD) {
            returnCoordinate = getCoordinate(row, col);
        } else {
            returnCoordinate = OUTOFBOARD;
        }
        return returnCoordinate;
    }

    public Coordinate moveToSouth(Coordinate coordinate) {
        int row = coordinate.row + 1;
        int col = coordinate.col;
        Coordinate returnCoordinate = null;
        if (new Coordinate(row, col).inBoard() && coordinate != OUTOFBOARD) {
            returnCoordinate = getCoordinate(row, col);
        } else {
            returnCoordinate = OUTOFBOARD;
        }
        return returnCoordinate;
    }

    public Coordinate moveToSouthWest(Coordinate coordinate) {
        int row = coordinate.row + 1;
        int col = coordinate.col - 1;
        Coordinate returnCoordinate = null;
        if (new Coordinate(row, col).inBoard() && coordinate != OUTOFBOARD) {
            returnCoordinate = getCoordinate(row, col);
        } else {
            returnCoordinate = OUTOFBOARD;
        }
        return returnCoordinate;
    }

//    @Override
    public void getHint() {
        for (Piece p : this.alivePieces.values()) {
            Move temp = p.findAvailablePosition(this);
            if (temp != null) hint.hintPositionList.add(temp);
        }

    }

}
