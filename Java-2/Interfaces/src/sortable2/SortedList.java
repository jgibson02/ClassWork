package sortable2;

import java.util.ArrayList;

/**
 * A sorted list of objects.
 * 
 * @author John Gibson
 */
public class SortedList {
    private ArrayList<Sortable> list;
    
    /**
     * Creates an empty list.
     */
    public SortedList() {
        list = new ArrayList<>();
    }
    
    /**
     * Returns an object from a specified position in the list.
     */
    public Sortable get(int i) {
        return list.get(i);
    }
    
    /**
     * Returns the number of items in the list.
     */
    public int size() {
        return list.size();
    }
    
    public void add(Sortable obj) {
        int i = 0;
        while (i < list.size() && list.get(i).comesBefore(obj)) {
            i++;
        }
        list.add(i, obj);
    }
}
