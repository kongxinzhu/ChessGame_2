import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by caixinzhu on 2/23/17.
 */
public class Move {
    Coordinate startCoordinate;
    Coordinate endCoordinate;
    boolean captureOpposite;

    public Move(Coordinate startCoordinate, Coordinate endCoordinate, boolean captureOpposite) {
        this.startCoordinate = startCoordinate;
        this.endCoordinate = endCoordinate;
        this.captureOpposite = captureOpposite;
    }

    public Move(Coordinate startCoordinate, Coordinate endCoordinate) {
        this.startCoordinate = startCoordinate;
        this.endCoordinate = endCoordinate;
        this.captureOpposite = false;
    }


    public static boolean isInAvailablePositionList(LinkedList<Move> moveList, Coordinate coordinate) {
        for(Move move : moveList) {
            if(move.endCoordinate == coordinate) {
                return true;
            }
        }
        return false;
    }


}
