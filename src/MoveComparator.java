import java.util.Comparator;

/**
 * Created by caixinzhu on 3/2/17.
 */
public class MoveComparator implements Comparator<Move> {
    Board board;

    public MoveComparator(Board board) {
        this.board = board;
    }

    @Override
    public int compare(Move m1, Move m2) {
        int res = 0;
        if (m1.captureOpposite != m2.captureOpposite) {
            res = m1.captureOpposite == false ? 1 : -1;
        }

        if (res == 0) {
            if (m1.endCoordinate.col == m2.endCoordinate.col) res = 0;
            else if (board.turn % 2 == 1) res = m1.endCoordinate.col < m2.endCoordinate.col ? 1 : -1;
            else if (board.turn % 2 == 0) res = m1.endCoordinate.col > m2.endCoordinate.col ? 1 : -1;
        }

        if (res == 0) {
            if (m1.endCoordinate.row == m2.endCoordinate.row) res = 0;
            else if (board.turn % 2 == 1) res = m1.endCoordinate.row > m2.endCoordinate.row ? 1 : -1;
            else if (board.turn % 2 == 0) res = m1.endCoordinate.row < m2.endCoordinate.row ? 1 : -1;
        }

        if (res == 0) {
            if (m1.startCoordinate.col == m2.startCoordinate.col) res = 0;
            else if (board.turn % 2 == 1) res = m1.startCoordinate.col > m2.startCoordinate.col ? 1 : -1;
            else if (board.turn % 2 == 0) res = m1.startCoordinate.col < m2.startCoordinate.col ? 1 : -1;
        }

        if (res == 0) {
            if (m1.startCoordinate.row == m2.startCoordinate.row) res = 0;
            else if (board.turn % 2 == 1) res = m1.startCoordinate.row < m2.startCoordinate.row ? 1 : -1;
            else if (board.turn % 2 == 0) res = m1.startCoordinate.row > m2.startCoordinate.row ? 1 : -1;
        }
        return res;
    }
}
