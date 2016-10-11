package sortable2;

/**
 * Used to compare one object with another for purposes of sorting.
 * 
 * @author John Gibson
 */
public interface Sortable {
    
    /**
     * Returns true if the object at hand precedes the argument in sorted order.
     */
    boolean comesBefore(Sortable sortable);
}
