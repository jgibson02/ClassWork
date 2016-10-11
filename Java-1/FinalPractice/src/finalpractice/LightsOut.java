package lightsout;

import java.util.Random;

/**
 * Backend of a Lights Out Game
 * 
 * @author Austin Myers
 */
public class LightsOut {

    private final boolean[][] grid; // true = ON, false = OFF
    private final int ROWS; // number of rows
    private final int COLS; // number of columns

    /**
     * Initializes the game to a random solvable position. 
     *
     * @param n the number of rows and columns
     */
    public LightsOut(int n) {
         this(n, n);
    }
            
    /**
     * Initializes the game to a random solvable position. 
     *
     * @param r the number of rows
     * @param c the number of columns     
     */
    public LightsOut(int r, int c) {
        grid = new boolean[r][c];
        ROWS = r;
        COLS = c;

        final int N = 2 * r * c; // number of random moves to make.
        /*
         * The grid is filled with false values initially, representing
         * all lights out. We then make N legal moves to initialize the
         * puzzle to a random-looking configuration.
         */
        Random rand = new Random();
        for (int i = 0; i < N; i++) {
            move(rand.nextInt(r), rand.nextInt(c));
        }
    }

    /**
     * Performs a legal move. Invalid moves are ignored.
     *
     * @param r the row of the move
     * @param c the column of the move
     */
    public final void move(int r, int c) {
        if (!inBounds(r, c)) {
            return;
        }

        toggle(r, c);
        toggle(r - 1, c);
        toggle(r + 1, c);
        toggle(r, c - 1);
        toggle(r, c + 1);
    }

    /**
     * Tells if the game is over.
     *
     * @return true if all lights are off
     */
    public boolean over() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j]) { // light on
                   return false;
                }
            }
        }
        return true;
    }

    /**
     * Returns a text-based description of the game state.
     * Assumes 1-10 columns.
     *
     * @return the current game state
     */
    @Override
    public String toString() {
        String s = "    ";   // 4 spaces

        // column numbers
        for (int i = 0; i < COLS; i++) {
            s += i + "  ";    // 2 spaces at the end
        }
        s += "\n";

        for (int i = 0; i < ROWS; i++) {
            s += " " + i + " ";   // row number
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j]) {
                    s += " # ";
                } else {
                    s += " - ";
                }
            }
            s += "\n";
        }

        return s;
    }

    /**
     * Toggles the light in a given cell.
     *
     * @param r the row of the cell
     * @param c the column of the cell
     */
    private void toggle(int r, int c) {
        if (inBounds(r, c)) {
            grid[r][c] = !grid[r][c];
        }
    }

    /**
     * Checks if a given position is valid.
     * @param r the row
     * @param c the column
     * @return true if (r, c) is in bounds
     */
    private boolean inBounds(int r, int c) {
        return r >= 0 && r < ROWS && c >= 0 && c < COLS;
    }
}