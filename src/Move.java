import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by caixinzhu on 2/23/17.
 */
public class Move extends Coordinate {
    boolean captureOpposite;

    public Move(int row, int col, boolean captureOpposite) {
        super(row, col);
        this.captureOpposite = captureOpposite;
    }

    public Move(Coordinate coordinate) {
        super(coordinate.row, coordinate.col);
        this.captureOpposite = false;
    }

    public static boolean isInAvailablePositionList(LinkedList<Move> moveList, Coordinate coordinate) {
        for(Move move : moveList) {
            if(move.row == coordinate.row && move.col == coordinate.col) {
                return true;
            }
        }
        return false;
    }
}
