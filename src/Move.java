import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by caixinzhu on 2/23/17.
 */
public class Move {
    Coordinate coordinate;
    boolean captureOpposite;

    public Move(Coordinate coordinate, boolean captureOpposite) {
        this.coordinate = coordinate;
        this.captureOpposite = captureOpposite;
    }

    public Move(Coordinate coordinate) {
        this.coordinate = coordinate;
        this.captureOpposite = false;
    }


    public static boolean isInAvailablePositionList(LinkedList<Move> moveList, Coordinate coordinate) {
        for(Move move : moveList) {
            if(move.coordinate == coordinate) {
                return true;
            }
        }
        return false;
    }


}
