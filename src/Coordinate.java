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
        if(this.row >= 0 && this.row <= 7 && this.col >= 0 && this.col <= 7) {
            return true;
        } else {
            return false;
        }
    }



}
