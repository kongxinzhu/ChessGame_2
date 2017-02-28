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
                    buttons[row][col] = new SquareOfBoard(new Coordinate(row, col), Color.white);
                    col++;
                    buttons[row][col] = new SquareOfBoard(new Coordinate(row, col), Color.gray);
                }
            } else {
                for (int k = 0; k < 4; col++, k++) {
                    buttons[row][col] = new SquareOfBoard(new Coordinate(row, col), Color.gray);
                    col++;
                    buttons[row][col] = new SquareOfBoard(new Coordinate(row, col), Color.white);
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
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 8; j++) {
                Icon iconOfPiece = new ImageIcon(getClass().getResource(realBoard.boardTrace[i][j].imagePath));
                buttons[i][j].setIcon(iconOfPiece);
            }
        }
        for (int i = 6; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Icon iconOfPiece = new ImageIcon(getClass().getResource(realBoard.boardTrace[i][j].imagePath));
                buttons[i][j].setIcon(iconOfPiece);
            }
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
        int endRow = end.row;
        int endCol = end.col;


        if (realBoard.boardTrace[startRow][startCol] == null) {
            buttons[startRow][startCol].setIcon(null);
        }

        if (realBoard.boardTrace[startRow][startCol] != null) {
            imageOfPiece = new ImageIcon(getClass().getResource(realBoard.boardTrace[startRow][startCol].imagePath));
            buttons[startRow][startCol].setIcon(imageOfPiece);
        }

        if (realBoard.boardTrace[endRow][endCol] == null) {
            buttons[endRow][endCol].setIcon(null);
        }

        if (realBoard.boardTrace[endRow][endCol] != null) {
            imageOfPiece = new ImageIcon(getClass().getResource(realBoard.boardTrace[endRow][endCol].imagePath));
            buttons[endRow][endCol].setIcon(imageOfPiece);
        }
    }


    public void setHighLight() {
        for (Move move : realBoard.availableMove) {
            Color c = buttons[move.row][move.col].getBackground();
            originalSquareColor.add(c);
            buttons[move.row][move.col].setBackground(Color.YELLOW);
        }
    }

    public void removeHighLight() {
        Color color;
        Move move;
        while (!originalSquareColor.isEmpty()) {
            color = originalSquareColor.pop();
            move = realBoard.availableMove.pop();
            this.buttons[move.row][move.col].setBackground(color);
        }
    }
}
