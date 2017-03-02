import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by caixinzhu on 3/2/17.
 */
public class Hint implements Runnable {
    ArrayList<Thread> threads;
    HashMap<Piece, Move> hint;
    Board board;

    @Override
    public void run() {
        for(Piece p : board.alivePieces.values()) {
            Move temp  = p.findAvailablePosition(board);
            if(temp != null)  hint.put(p, temp);
        }
    }
}
