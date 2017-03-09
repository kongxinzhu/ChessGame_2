import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class BoardGUI extends JPanel {
    SquareOfBoard[][] buttons;
    Board realBoard;


    // original color of square for the current valid move position
    LinkedList<Color> originalSquareColor;

    // if hint highlight on board
    boolean hintHighLight;
    boolean moveHighLight;

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
    public void boardUpdate(Move move) {
        buttons[move.startCoordinate.row][move.startCoordinate.col].setIcon(null);
        imageOfPiece = new ImageIcon(getClass().getResource(realBoard.alivePieces.get(move.endCoordinate).imagePath));
        buttons[realBoard.alivePieces.get(move.endCoordinate).coordinate.row][realBoard.alivePieces.get(move.endCoordinate).coordinate.col].setIcon(imageOfPiece);
    }

    public void setHighLightForAvailableMove() {
        originalSquareColor.clear();
        for (Move move : realBoard.availableMove) {
            Color c = buttons[move.endCoordinate.row][move.endCoordinate.col].getBackground();
            originalSquareColor.add(c);
            buttons[move.endCoordinate.row][move.endCoordinate.col].setBackground(Color.YELLOW);
        }
    }

    public void removeHighLightForAvailableMove() {
        Color color;
        Move move;
        while (!originalSquareColor.isEmpty()) {
            color = originalSquareColor.pop();
            move = realBoard.availableMove.pop();
            this.buttons[move.endCoordinate.row][move.endCoordinate.col].setBackground(color);
        }
    }

    public void setHighLightForHint(Move move) {
        Color endColor = buttons[move.endCoordinate.row][move.endCoordinate.col].getBackground();
        Color startColor = buttons[move.startCoordinate.row][move.startCoordinate.col].getBackground();
        originalSquareColor.add(endColor);
        originalSquareColor.add(startColor);
        buttons[move.endCoordinate.row][move.endCoordinate.col].setBackground(Color.YELLOW);
        buttons[move.startCoordinate.row][move.startCoordinate.col].setBackground(Color.YELLOW);
    }

    public void removeHighLightForHint() {
        Color destinationColor;
        Color startColor;
        Move move;
        if (originalSquareColor.size() != 0) {
            destinationColor = originalSquareColor.pop();
            startColor = originalSquareColor.pop();
            move = realBoard.availableMove.pop();
            buttons[move.endCoordinate.row][move.endCoordinate.col].setBackground(destinationColor);
            buttons[move.startCoordinate.row][move.startCoordinate.col].setBackground(startColor);
        }
    }
}
