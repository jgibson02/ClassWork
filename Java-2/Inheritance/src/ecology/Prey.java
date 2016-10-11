package ecology;

/**
 * A creature that moves and reproduces and never dies except when eaten.
 * 
 * @author John Gibson
 * @version Mar 16, 2016
 */
class Prey extends Creature {
    
    // energy remains at this level until eaten
    private static final int LIFE_FORCE = 1;
    private static final double BREED_PROB = 0.25;
    
    /**
     * Creates a new predator. 
     */
    public Prey(int energy) {
        super(energy);
    }
    
    /**
     * Creates a new prey with a fixed energy level. 
     */
    public Prey() {
        super(LIFE_FORCE);
    }

    /**
     * Gains a unit of energy;
     */
    public void eat() {
        energy++;
    }
    
    /**
     * Returns the direction to which the creature wants to move.
     * A prey creature wants to move to an empty location.
     */
    @Override
    public Direction move(Creature[] neighbors) {
        return toNeighbor(neighbors, null);
    }

    /**
     * Returns a new predator (if this one is ready to reproduce). 
     */
    @Override
    public Creature reproduce() {
        return Math.random() < BREED_PROB ? new Prey() : null;
    }
}