import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class ChessGameGUI extends JFrame implements ActionListener {
    BoardGUI board;
    JButton refresh;
    JButton hint;
    JPanel boardPanel;

    public ChessGameGUI() {
        // set title of window
        setTitle("Chess Game");

        // contentPane contains boardPanel and buttonPanel
        Container contentPane = getContentPane();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));

        // boardPanel contains board
        boardPanel = new JPanel();
        boardPanel.setBorder(new EmptyBorder(20, 20, 20, 10));
        boardPanel.setLayout(new BoxLayout(boardPanel, BoxLayout.Y_AXIS));

        board = new BoardGUI();

        // position the board in center of boardPanel
        boardPanel.add(Box.createVerticalGlue());
        boardPanel.add(board);
        boardPanel.add(Box.createVerticalGlue());

        // buttonPanel contains two buttons which are prev and next
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 20));
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        // position buttonPanel in the center
        buttonPanel.add(Box.createVerticalGlue());
        hint = new JButton("hint");
        refresh = new JButton("refresh");

        buttonPanel.add(hint);
        buttonPanel.add(refresh);
        buttonPanel.add(Box.createVerticalGlue());

        // add listener
        board.addActionListener(this);
        hint.addActionListener(this);
        refresh.addActionListener(this);

        // buttonPanelCenter.add(buttonPanel);
        contentPane.add(Box.createHorizontalGlue());
        contentPane.add(boardPanel);
        contentPane.add(buttonPanel);
        contentPane.add(Box.createHorizontalGlue());

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == hint) {
            if (board.moveHighLight) {
                board.removeHighLightForAvailableMove();
                board.moveHighLight = false;
            }
            board.realBoard.availableMove = new LinkedList();
            board.realBoard.isSelected = false;
            Move hintMove = board.realBoard.calculateHint();
            board.setHighLightForHint(hintMove);
            board.hintHighLight = true;
        }
        // refresh the board
        else if (source == refresh) {
            boardPanel.removeAll();
            boardPanel.revalidate();
            boardPanel.repaint();
            board = new BoardGUI();
            board.addActionListener(this);
            boardPanel.add(board);
        } else {

            SquareOfBoard clickedSquare = (SquareOfBoard) source;
            Piece targetPiece = board.realBoard.alivePieces.get(clickedSquare.coordinateOfButton);



            // check if it's right turn
            if (targetPiece != null && targetPiece.color == board.realBoard.turn % 2 && !board.realBoard.isSelected) {
                Piece selectedPiece = board.realBoard.alivePieces.get(clickedSquare.coordinateOfButton);
                board.realBoard.isSelected = true;
                //here
                if (board.hintHighLight && selectedPiece.coordinate != board.realBoard.availableMove.peek().startCoordinate) {
                    if (board.hintHighLight) {
                        board.removeHighLightForHint();
                        board.hintHighLight = false;
                    }
                    board.realBoard.availableMove.clear();
                    selectedPiece.findAvailablePosition(board.realBoard);
                    board.removeHighLightForHint();
                    board.hintHighLight = false;
                    board.setHighLightForAvailableMove();
                    board.moveHighLight = true;
                } else if(board.hintHighLight && selectedPiece.coordinate == board.realBoard.availableMove.peek().startCoordinate){
                    board.realBoard.availableMove.clear();
                    selectedPiece.findAvailablePosition(board.realBoard);
                } else if(!board.hintHighLight) {
                    selectedPiece.findAvailablePosition(board.realBoard);
                    board.setHighLightForAvailableMove();
                    board.moveHighLight = true;
                }


            } else {
                if (board.realBoard.isInAvailablePositionList(clickedSquare.coordinateOfButton)) {
                    Move move = new Move(board.realBoard.availableMove.peek().startCoordinate, clickedSquare.coordinateOfButton);
                    board.realBoard.upDatePieceInAlivePieces(move);
                    board.boardUpdate(move);
                    board.realBoard.turn++;
                }

                if (board.moveHighLight) {
                    board.removeHighLightForAvailableMove();
                    board.moveHighLight = false;
                }
                if (board.hintHighLight) {
                    board.removeHighLightForHint();
                    board.hintHighLight = false;
                }
                board.realBoard.availableMove = new LinkedList();
                board.realBoard.isSelected = false;
            }
        }
    }
}
