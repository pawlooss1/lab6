package agh.cs.lab6;
/**
 * Created by Student33 on 2018-10-15.
 */
public enum MapDirection {
    NORTH,
    SOUTH,
    EAST,
    WEST;

    public String toString() {
        switch (this) {
            case NORTH:
                return "Północ";
            case SOUTH:
                return "Południe";
            case EAST:
                return "Wschód";
            case WEST:
                return "Zachód";
        }
        return "";
    }
    public MapDirection next() {
        switch (this) {
            case NORTH:
                return EAST;
            case SOUTH:
                return WEST;
            case EAST:
                return SOUTH;
            case WEST:
                return NORTH;
        }
        return NORTH;
    }
    public MapDirection previous() {
        switch (this) {
            case NORTH:
                return WEST;
            case SOUTH:
                return EAST;
            case EAST:
                return NORTH;
            case WEST:
                return SOUTH;
        }
        return NORTH;
    }
}
