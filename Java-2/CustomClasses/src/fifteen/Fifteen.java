package fifteen;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

/**
 * Manages the state of the Fifteen Puzzle. A 4x4 grid contains 15 numbered tiles and an empty space. The goal
 * is to repeatedly slide a tile into the empty space until the tiles appear in order.
 *
 * @author John Gibson
 */
public class Fifteen {

    private final int[][] grid;
    private static final int ROWS = 4;
    private static final int COLS = 4;
    private static final int EMPTY_SPACE = 0;

    /**
     * Initializes the grid to a random configuration.
     */
    public Fifteen() {
	int tile = 1;
	grid = new int[ROWS][COLS];
	for (int i = 0; i < ROWS; i++) {
	    for (int j = 0; j < COLS; j++) {
		grid[i][j] = tile;
		tile++;
	    }
	}
	grid[ROWS - 1][COLS - 1] = EMPTY_SPACE;

	Random rand = new Random();
	final int NUM_MOVES = 12;
	for (int i = 0; i < NUM_MOVES; i++) {
	    int tileToMove = 1 + rand.nextInt(ROWS * COLS);
	    slide(tileToMove);
	}
    }

    /**
     * Moves a specified tile into the adjacent empty space. If the empty space is not adjacent, the method
     * terminates without changing the state of the game.
     */
    public final void slide(int tileToSlide) {
	// ignore invalid moves
	if (tileToSlide < 1 || tileToSlide >= ROWS * COLS) {
	    return;
	}

	int tileRow = 0; // row of tile to slide
	int tileCol = 0; // column of tile to slide
	int spaceRow = 0; // row of empty space
	int spaceCol = 0; // column of empty space
	for (int i = 0; i < ROWS; i++) {
	    for (int j = 0; j < COLS; j++) {
		if (grid[i][j] == tileToSlide) {
		    tileRow = i;
		    tileCol = j;
		}
		if (grid[i][j] == EMPTY_SPACE) {
		    spaceRow = i;
		    spaceCol = j;
		}
	    }
	}

	if (Math.abs(tileRow - spaceRow) + Math.abs(tileCol - spaceCol) == 1) {
	    grid[tileRow][tileCol] = EMPTY_SPACE;
	    grid[spaceRow][spaceCol] = tileToSlide;
	}
    }

    @Override
    public String toString() {
	String s = "";
	for (int i = 0; i < ROWS; i++) {
	    for (int j = 0; j < COLS; j++) {
		s += (" " + toString(i, j) + " ");
	    }
	    s += "\n";
	}
	return s;
    }

    /**
     * Converts the contents of a grid cell to text.
     *
     * @param i the row
     * @param j the column
     * @return the contents of the cell at (i, j)
     */
    public String toString(int i, int j) {
	if (grid[i][j] == EMPTY_SPACE) {
	    return "  ";
	}
	DecimalFormat f = new DecimalFormat("00");
	return f.format(grid[i][j]);
    }

    /**
     * Returns ture if the game is over (all tiles are in order).
     *
     * @return
     */
    public boolean over() {
	int tile = 1;
	for (int i = 0; i < ROWS; i++) {
	    for (int j = 0; j < COLS; j++) {

		// special case: empty space in last position
		if (i == ROWS - 1 && j == COLS - 1) {
		    return true;
		}

		if (grid[i][j] != tile) {
		    return false;
		}
		tile++;
	    }

	}
	return true; //unreachable
    }

    /**
     * Gets a list of legal moves.
     *
     * @return an array of tiles adjacent to the empty space
     */
    public String[] choices() {
	ArrayList<String> list = new ArrayList<>();

	// Search for empty space.
	for (int i = 0; i < ROWS; i++) {
	    for (int j = 0; j < COLS; j++) {

		// When we find the empty space, find tile numbers in adjacent cells.
		if (grid[i][j] == EMPTY_SPACE) {
		    if (i > 0) { // above
			list.add(toString(i - 1, j));
		    }
		    if (i < ROWS - 1) { // below
			list.add(toString(i + 1, j));
		    }
		    if (j > 0) { // left
			list.add(toString(i, j - 1));
		    }
		    if (j < COLS - 1) { // right
			list.add(toString(i, j + 1));
		    }
		}

	    } // j-loop
	} // i-loop
	return list.toArray(new String[list.size()]);
    }
}
