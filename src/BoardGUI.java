import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class BoardGUI extends JPanel {
    SquareOfBoard[][] buttons;
    Board realBoard;

    // square where the valid selected piece is
    SquareOfBoard start;

    // original color of square for the current valid move position
    LinkedList<Color> originalSquareColor;

    private Icon imageOfPiece;

    // constructor
    public BoardGUI() {
        realBoard = new Board();
        buttons = new SquareOfBoard[8][8];

        originalSquareColor = new LinkedList();

        GridLayout gridLayout = new GridLayout(8, 8);
        gridLayout.setHgap(0);
        gridLayout.setVgap(0);
        setLayout(gridLayout);

        setBorder(new LineBorder(Color.black, 2));
        setVisible(true);
        setSize(600, 600);

        // create 64 squares
        for (int row = 0; row < 8; row++) {
            int col = 0;
            if (row % 2 != 0) {
                for (int k = 0; k < 4; col++, k++) {
                    buttons[row][col] = new SquareOfBoard(realBoard.coordinates[row][col], Color.white);
                    col++;
                    buttons[row][col] = new SquareOfBoard(realBoard.coordinates[row][col], Color.gray);
                }
            } else {
                for (int k = 0; k < 4; col++, k++) {
                    buttons[row][col] = new SquareOfBoard(realBoard.coordinates[row][col], Color.gray);
                    col++;
                    buttons[row][col] = new SquareOfBoard(realBoard.coordinates[row][col], Color.white);
                }
            }
        }

        // add buttons in board panel
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                add(buttons[i][j]);
            }
        }

        // initialize the beginning state of game
        for (Piece piece : realBoard.alivePieces.values()) {
            Icon iconOfPiece = new ImageIcon(getClass().getResource(piece.imagePath));
            buttons[piece.coordinate.row][piece.coordinate.col].setIcon(iconOfPiece);
        }
        setSize(600, 600);
    }

    public void addActionListener(ActionListener actionListener) {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                buttons[row][col].addActionListener(actionListener);
            }
        }
    }


    // update the icon on chess board in GUI
    public void boardUpdate(Coordinate start, Coordinate end) {

        int startRow = start.row;
        int startCol = start.col;

        buttons[startRow][startCol].setIcon(null);
        imageOfPiece = new ImageIcon(getClass().getResource(realBoard.alivePieces.get(end).imagePath));
        buttons[realBoard.alivePieces.get(end).coordinate.row][realBoard.alivePieces.get(end).coordinate.col].setIcon(imageOfPiece);
    }


    public void setHighLight() {
        if (realBoard.availableMove.size() != 0) {
            Move move = realBoard.availableMove.peek();
            Color destination = buttons[move.row][move.col].getBackground();
            Color start = buttons[realBoard.selectedPiece.coordinate.row][realBoard.selectedPiece.coordinate.col].getBackground();
            originalSquareColor.add(destination);
            originalSquareColor.add(start);
            buttons[move.row][move.col].setBackground(Color.YELLOW);
            buttons[realBoard.selectedPiece.coordinate.row][realBoard.selectedPiece.coordinate.col].setBackground(Color.YELLOW);
        }
    }

    public void removeHighLight() {
        Color destinationColor;
        Color startColor;
        Move move;
        if (originalSquareColor.size() != 0) {
            destinationColor = originalSquareColor.pop();
            startColor = originalSquareColor.pop();
            move = realBoard.availableMove.pop();
            buttons[move.row][move.col].setBackground(destinationColor);
            buttons[start.coordinateOfButton.row][start.coordinateOfButton.col].setBackground(startColor);
        }
    }
}
