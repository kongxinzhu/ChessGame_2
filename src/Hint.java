import java.util.*;

/**
 * Created by caixinzhu on 3/2/17.
 */
public class Hint {
    LinkedList<Move> hintPositionList;
    Board board;

    public Hint(Board board) {
        this.board = board;
        hintPositionList = new LinkedList();
    }

    public Move calculateHint() {
        for(Piece p : board.alivePieces.values()) {
            if(board.turn % 2 == p.color) {
                Move move = p.findAvailablePosition(board);
                if(move != null) {
                    hintPositionList.add(move);
                }
            }
        }
        Collections.sort(hintPositionList, new MoveComparator(board));
        return hintPositionList.peek();
    }
}
