
package lightsout;

import java.util.Random;
import javax.accessibility.AccessibleRole;

/**
 * Backend of a Lights Out game.
 * @author John Gibson
 */
public class LightsOut {
    
    private boolean[][] grid; // true=ON, false=OFF
    private int rows; // number of rows
    private int cols; // number of columns
    public int turns; // number of turns
    
    /**
     * Initializes the grid to a random starting configuration.
     * @param n the number of rows and columns
     */
    public LightsOut(int n) {
        this(n, n);
    }
    
    /**
     * Initializes the grid to a random starting configuration.
     * @param r the number of rows
     * @param c the number of columns
     */
    public LightsOut(int r, int c) {
        grid = new boolean[r][c];
        this.rows = r;
        this.cols = c;
        final int N = 2 * r * c; // number of random moves to make
        
        Random rand = new Random();
        for (int i = 0; i < N; i++) {
            int x = rand.nextInt(r);
            int y = rand.nextInt(c);
            move(x, y);
        }
    }
    
    /**
     * Makes a move. Invalid moves are ignored.
     * @param x the row at which to make the move
     * @param y the column at which to make the move
     */
    public void move(int x, int y) {
        if (!inBounds(x, y)) {
            return;
        }
        toggle(x, y);
        toggle(x - 1, y);
        toggle(x + 1, y);
        toggle(x, y - 1);
        toggle(x, y + 1);
    }
    
    /**
     * Toggles the light in a given cell.
     * @param r the row of the light
     * @param c the column of the light
     */
    private void toggle(int r, int c) {
        if (inBounds(r, c)) {
            grid[r][c] = !grid[r][c];
        }
    }
    
    /**
     * Tells if a given position is legal.
     * @param r a row
     * @param c a column
     * @return true if (r, c) is a valid position
     */
    private boolean inBounds(int r, int c) {
        return r >= 0 && r < rows && c >= 0 && c < cols;
    }
    
    /**
     * Tells if the game is over.
     * @return true if all lights are out.
     */
    public boolean isOver() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * Returns a text-based description of the current game state.
     * Assumes 1-10 columns.
     * @return the current game state
     */
    @Override
    public String toString() {
        String s = "    "; // 4 spaces
        
        // column numbers
        for (int i = 0; i < this.cols; i++) {
            s += i + "  "; // 2 spaces
        }
        s += "\n";
        
        for (int i = 0; i < rows; i++) {
            s += " " + i + " "; // row number
            for (int j = 0; j < cols; j++) {
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
}