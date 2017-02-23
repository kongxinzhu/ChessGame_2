import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        boardPanel.setBorder(new EmptyBorder(20,20,20,10));
        boardPanel.setLayout(new BoxLayout(boardPanel, BoxLayout.Y_AXIS));

        board = new BoardGUI();

        // position the board in center of boardPanel
        boardPanel.add(Box.createVerticalGlue());
        boardPanel.add(board);
        boardPanel.add(Box.createVerticalGlue());

        // buttonPanel contains two buttons which are prev and next
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0,10,0,20));
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        // position buttonPanel in the center
        buttonPanel.add(Box.createVerticalGlue());
        hint = new JButton("hint");
        refresh = new JButton("refresh");

        buttonPanel.add(hint);
        buttonPanel.add(refresh);
        buttonPanel.add(Box.createVerticalGlue());

        // add listener
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
    public void actionPerformed (ActionEvent e) {
        Object source = e.getSource();

        // refresh the board
        if(source == refresh) {
            boardPanel.removeAll();
            boardPanel.revalidate();
            boardPanel.repaint();
            board = new BoardGUI();
            boardPanel.add(board);
        }
    }
}