package ecology;

/**
 * Hunts for prey, breeds, and dies when energy exhausted.
 * @author John Gibson
 * @version Mar 16, 2016
 */
public class Predator extends Creature {

    private static final int DEFAULT_INIT_ENERGY = 5;
    private static final int ENERGY_TO_BREED = 1;
    
    /**
     * Creates a new predator. 
     */
    public Predator(int energy) {
        super(energy);
    }
    
    /**
     * Creates a new predator. 
     */
    public Predator() {
        super(DEFAULT_INIT_ENERGY);
    }

    /**
     * Gains a unit of energy;
     */
    public void eat() {
        energy++;
    }
    
    /**
     * Chooses a direction to move. A predator will elect to move in the direction of 
     * prey if possible. 
     */
    @Override
    public Direction move(Creature[] neighbors) {
        energy--;
        Direction dir = toNeighbor(neighbors, Prey.class);
        if (dir == null) {
            // no prey, so move to empty cell
            dir = toNeighbor(neighbors, null);
        } else {
            eat();
        }
        return dir;
    }

    /**
     * Returns a new predator (if this one is ready to reproduce). 
     */
    @Override
    public Creature reproduce() {
        if (energy >= ENERGY_TO_BREED) {
            return new Predator(energy);
        }
        return null;
    }
    
}