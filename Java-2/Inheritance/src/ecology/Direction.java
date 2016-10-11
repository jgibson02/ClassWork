

package ecology;

/**
 * The four cardinal directions.
 *
 * @author Drue Coles
 */
public enum Direction {

    NORTH, EAST, SOUTH, WEST;

    /**
     * @return distance traveled eastward after one step in this direction
     */
    public int horizontalChange() {
        switch (this) {
            case EAST:
                return 1;
            case WEST:
                return -1;
            default:
                return 0;
        }
    }

    /**
     * @return distance traveled southward after one step in this direction
     */
    public int verticalChange() {
        switch (this) {
            case SOUTH:
                return 1;
            case NORTH:
                return -1;
            default:
                return 0;
        }
    }

    /**
     * Gets the direction corresponding to a given index. Indexing starts from 0 = NORTH and 
     * continues clockwise.
     *
     * @param index an integer in the range 0-3 inclusive
     * @return the direction corresponding to the given index (or null if index is invalid)
     */
    public static Direction get(int index) {
        switch (index) {
            case 0:
                return NORTH;
            case 1:
                return EAST;
            case 2:
                return SOUTH;
            case 3:
                return WEST;
            default:
                return null;
        }
    }
    
    /**
     * @return the index of this direction
     */
    public int indexOf() {
        switch (this) {
            case NORTH: return 0;
            case EAST: return 1;
            case SOUTH: return 2;
            case WEST: return 3;
            default: return -1; // unreachable
        }
    }
}

