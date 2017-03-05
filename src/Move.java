import java.util.LinkedList;

/**
 * Created by caixinzhu on 2/23/17.
 */

/*
 * Move class contains start coordinate and end coordinate
 * moreover the Move instance has a variable to show if this Move can capture the opposite piece
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
}
