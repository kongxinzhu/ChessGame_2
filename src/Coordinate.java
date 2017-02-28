/**
 * Created by caixinzhu on 2/23/17.
 */
public class Coordinate {
    int row;
    int col;
    public Coordinate(int row, int col) {
        this.row = row;
        this.col = col;
    }
    public boolean inBoard() {
        if(row >= 0 && row <= 7 && col >= 0 && col <= 7) {
            return true;
        } else {
            return false;
        }
    }
    public void moveToWest() {
        col--;
    }
    public void moveToNorthWest() {
        col--;
        row--;
    }
    public void moveToNorth() {
        row--;
    }
    public void moveToNorthEast() {
        row--;
        col++;
    }
    public void moveToEast() {
        col++;
    }
    public void moveToSouthEast() {
        row++;
        col++;
    }
    public void moveToSouth() {
        row++;
    }
    public void moveToSouthWest() {
        row++;
        col--;
    }
}
