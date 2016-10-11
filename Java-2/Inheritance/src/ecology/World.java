

package ecology;

/**
 * A population of predator and prey creatures in a toroidal grid.
 *
 * @author Drue Coles
 */
public class World {

    private Creature[][] world;
    private int size;

    /**
     * Populates the world with predators and prey distributed uniformly at random.
     *
     * @param size the number cells in a row or column
     * @param p1 probability for a given cell to contain a predator
     * @param p2 probability for a given cell to contain a prey creature
     */
    public World(int size, double p1, double p2) {

        if (p1 + p2 > 1.0) {
            String msg = p1 + " + " + p2 + " > 1.0";
            throw new RuntimeException(msg);
        }

        this.size = size;
        world = new Creature[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                double prob = Math.random();
                if (prob < p1) {
                    world[i][j] = new Predator();
                } else if (prob < p1 + p2) {
                    world[i][j] = new Prey();
                }
            }
        }
    }

    /**
     * @param i row index
     * @param j column index
     * @return the creature at cell (i, j)
     */
    public Creature get(int i, int j) {
        // indices computed with wrap-around since toroidal grid is assumed
        int x = (i + size) % size;
        int y = (j + size) % size;
        return world[x][y];
    }

    /**
     * List of neighbors (null indicating an adjacent empty cell)
     *
     * @param i row index
     * @param j column index
     * @return a list of the four neighbors of the creature situated at (i, j)
     */
    Creature[] getNeighbors(int i, int j) {

        return new Creature[]{
            get(i - 1, j), // north
            get(i, j + 1), // east
            get(i + 1, j), // south
            get(i, j - 1) // west
        };
    }

    /**
     * Updates the world by one time unit.
     */
    public void tick() {
        tick(Prey.class);
        tick(Predator.class);
    }

    /**
     * Moves all the creatures of a given type to their next position in the world.
     *
     * @param type the type of creature to move
     */
    private void tick(Class type) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {

                Creature creature = world[row][col];

                if (creature == null) {
                    continue;
                }
                if (creature.isDead()) {
                    world[row][col] = null;
                    continue;
                }

                if (creature.getClass() != type) {
                    continue;
                }

                Creature[] neighbors = getNeighbors(row, col);
                Direction direction = creature.move(neighbors);

                if (direction == null) {
                    continue;
                }

                int nextRow = (row + direction.verticalChange() + size) % size;
                int nextCol = (col + direction.horizontalChange() + size) % size;
                world[row][col] = creature.reproduce();
                world[nextRow][nextCol] = creature;
            }
        }
    }
}

