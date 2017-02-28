import java.util.*;
/*
 * Board is back-end of this program
 * Piece's place is changed following MoveList which shows which piece and where it goes
 */

public class Board {
    static final int BLACK = 0;
    static final int WHITE = 1;

    // valid selected piece
    Piece selectedPiece;

    // current valid move position
    LinkedList<Move> availableMove = new LinkedList();

    // odd means white
    // even means black
    int turn = 1;

    Piece[][] boardTrace;

    // constructor
    public Board() {
        // initialize the beginning state of game
        // black pieces
        boardTrace = new Piece[8][8];
        boardTrace[0][0] = new PieceRook("rook", "Icon/black_rook.png", BLACK, new Coordinate(0,0));
        boardTrace[0][1] = new PieceKnight("knight", "Icon/black_knight.png",BLACK, new Coordinate(0,1));
        boardTrace[0][2] = new PieceBishop("bishop", "Icon/black_bishop.png", BLACK, new Coordinate(0,2));
        boardTrace[0][3] = new PieceQueen("queen", "Icon/black_queen.png", BLACK, new Coordinate(0,3));
        boardTrace[0][4] = new PieceKing("king", "Icon/black_king.png",BLACK, new Coordinate(0,4));
        boardTrace[0][5] = new PieceBishop("black_bishop", "Icon/black_bishop.png", BLACK, new Coordinate(0,5));
        boardTrace[0][6] = new PieceKnight("knight", "Icon/black_knight.png",BLACK, new Coordinate(0,6));
        boardTrace[0][7] = new PieceRook("rook", "Icon/black_rook.png", BLACK, new Coordinate(0,7));
        // pawn
        for (int col = 0; col < 8; col++) {
            boardTrace[1][col] = new PiecePawn("pawn", "Icon/black_pawn.png", BLACK, new Coordinate(1,col));
        }

        // empty square
        for (int row = 2; row < 6; row++) {
            for (int col = 0; col < 8; col++) {
                boardTrace[row][col] = null;
            }
        }

        // white pieces
        boardTrace[7][0] = new PieceRook("rook", "Icon/white_rook.png", WHITE, new Coordinate(7,0));
        boardTrace[7][1] = new PieceKnight("knight", "Icon/white_knight.png",WHITE, new Coordinate(7,1));
        boardTrace[7][2] = new PieceBishop("bishop", "Icon/white_bishop.png", WHITE, new Coordinate(7,2));
        boardTrace[7][3] = new PieceQueen("queen", "Icon/white_queen.png", WHITE, new Coordinate(7,3));
        boardTrace[7][4] = new PieceKing("king", "Icon/white_king.png", WHITE, new Coordinate(7,4));
        boardTrace[7][5] = new PieceBishop("bishop", "Icon/white_bishop.png", WHITE, new Coordinate(7,5));
        boardTrace[7][6] = new PieceKnight("knight", "Icon/white_knight.png",WHITE, new Coordinate(7,6));
        boardTrace[7][7] = new PieceRook("rook", "Icon/white_rook.png", WHITE, new Coordinate(7,7));
        // pawn
        for (int col = 0; col < 8; col++) {
            boardTrace[6][col] = new PiecePawn("pawn", "Icon/white_pawn.png", WHITE, new Coordinate(6,col));
        }
    }

    public void setSelectedPiece(Piece selectedPiece) {
        this.selectedPiece = selectedPiece;
    }

    // set available move position list
    public void setAvailableMove() {
        selectedPiece.findAvailablePosition(this);
    }


    public void upDate(Coordinate start, Coordinate end) {
        int startRow = start.row;
        int startCol = start.col;
        int endCol = end.col;
        int endRow = end.row;

        boardTrace[startRow][startCol].upDateCoordinate(end);
        boardTrace[endRow][endCol] = boardTrace[startRow][startCol];
        boardTrace[startRow][startCol] = null;
    }
}
