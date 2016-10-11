package life;

/**
 * 
 * @author John Gibson
 * @version Apr 11, 2016
 */
public class GameOfLife {
    private boolean[][] world; // true = living
    
    /**
     * Creates an empty world with a given number of rows and columns.
     */
    public GameOfLife(int n) {
        world = new boolean[n][n];
    }
    
    /**
     * Applies the Life rule to update the world to the next generation.
     */
    public void update() {
        int n = world.length;
        boolean[][] nextWorld = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int k = numberLivingNeighbors(i, j);
                switch (k) {
                    case 2:
                        nextWorld[i][j] = world[i][j];
                        break;
                    case 3:
                        nextWorld[i][j] = true;
                        break;
                    default:
                        nextWorld[i][j] = false;
                }
            }
        }
        
        world = nextWorld;
    }
    
    /**
     * Updates the world to the next generation
     */
    public void nextGeneration() {
        int n = world.length;
        boolean[][] nextWorld = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int k = numberLivingNeighbors(i, j);
                switch (k) {
                    case 2:
                        nextWorld[i][j] = world[i][j];
                        break;
                    case 3:
                        nextWorld[i][j] = true;
                        break;
                    default:
                        nextWorld[i][j] = false;
                }
            }
        }
        world = nextWorld;
    }
    
    /**
     * Returns the number of living cells adjacent to cell (x, y).
     */
    private int numberLivingNeighbors(int x, int y) {
        int count = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i == x && j == y) {
                    continue;
                }
                if (isAlive(i, j)) {
                    count++;
                }
            }
        }
        return count;
    }
    
    public boolean isAlive(int i, int j) {
        if (i < 0 || i >= world.length || j < 0 || j >= world.length) {
            return false;
        }
        return world[i][j];
    }
    
    /**
     * Returns the number of rows and columns. 
     */
    public int size() {
        return world.length;
    }
    
    /**
     * Sets each cells state to living or dead at random.
     * @param p the probability of a cell set to living.
     */
    public void randomize(double p) {
        for (boolean[] row : world) {
            for (int j = 0; j < row.length; j++) {
                row[j] = (Math.random() < p);
            }
        }
    }
    
    public void setLiving(int i, int j) {
        world[i][j] = true;
    }
    
    public void setDead(int i, int j) {
        world[i][j] = false;
    }
    
    public void toggle(int i, int j) {
        world[i][j] = !world[i][j];
    }
}