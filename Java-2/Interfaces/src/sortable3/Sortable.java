package sortable3;

/**
 * 
 * @author John Gibson
 */
public interface Sortable {
    
    /**
     * Returns true if obj1 comes before obj2 in sorted order.
     */
    boolean comesBefore(Object obj1, Object obj2);
}
