import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Created by caixinzhu on 2/26/17.
 */
public class SquareOfBoard extends JButton {
    Coordinate coordinateOfButton;
    Color colorOfSquare;
    public SquareOfBoard(Coordinate coordinateOfButton, Color colorOfSquare) {
        this.coordinateOfButton = coordinateOfButton;
        this.colorOfSquare = colorOfSquare;
        this.setPreferredSize(new Dimension(55, 55));
        this.setOpaque(true);
        this.setBorderPainted(true);
        this.setBorder(new LineBorder(Color.RED, 50));
        this.setBackground(colorOfSquare);
        this.setBorderPainted(false);
    }
}
