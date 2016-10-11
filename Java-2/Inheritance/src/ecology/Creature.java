package ecology;

import java.util.ArrayList;
import java.util.Random;

/**
 * A creature that can move and reproduce on a 2D grid. Movements depend on the type of
 * creatures in the immediate vicinity (von Neumann neighborhood).
 * 
 * @author John Gibson
 */
public abstract class Creature {
    
    protected int energy;
    
    /**
     * Creates a new creature with a given energy level.
     */
    public Creature(int energy) {
        this.energy = energy;
    }
    
    /**
     * Returns the direction of movement for this creature.
     * @param neighbors a list of neighboring creatures
     */
    public abstract Direction move(Creature[] neighbors);
    
    /**
     * Returns a new creature. 
     */
    public abstract Creature reproduce();
    
    public boolean isDead() {
        return energy < 1;
    }
    
    /**
     * Gets direction to a neighbor of a specified type. Subclasses will invoke this 
     * method from their own move method.
     */
    protected Direction toNeighbor(Creature[] neighbors, Class target) {
        // get indices of neighbors of target type
        ArrayList<Integer> targetIndices = new ArrayList<>();
        for (int i = 0; i < neighbors.length; i++) {
            if (neighbors[i] == null && target == null) {
                targetIndices.add(i);
            } else if (neighbors[i] != null && neighbors[i].getClass() == target) {
                targetIndices.add(i);
            }
        }
        
        // target type not found
        int numTargets = targetIndices.size();
        if (numTargets == 0) {
            energy--; // cannot move ... too crowded
            return null;
        }
        
        // choose a direction leading to target type
        Random rand = new Random();
        int k = rand.nextInt(numTargets);
        int dirIndex = targetIndices.get(k);
        return Direction.get(dirIndex);
    }
}