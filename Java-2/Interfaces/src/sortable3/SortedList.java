package sortable3;

import java.awt.Rectangle;
import java.util.ArrayList;

/**
 *
 * @author John Gibson
 */
public class SortedList {
    private final ArrayList<Object> list;
    private final Sortable sortable;
    
    /**
     * Creates an empty list.
     * @param sortable can tell when one object in the list comes before another
     */
    public SortedList(Sortable sortable) {
        list = new ArrayList<>();
        this.sortable = sortable;
    }
    
    /**
     * Returns the number of items in the list.
     */
    public int size() {
        return list.size();
    }
    
    /**
     * Returns the item at a given position of the list.
     */
    public Object get(int i) {
        return list.get(i);
    }
    
    /**
     * Adds a given object to the list in its correct position in sorted order.
     */
    public void add(Object n) {
        int i = 0;
        while (i < list.size()) {
            if(sortable.comesBefore(n, list.get(i))) {
                break;
            }
            i++;
        }
        list.add(i, n);
    }
    
    // test program
    public static void main(String[] args) {
        
        class StringComparator implements Sortable {
            @Override
            public boolean comesBefore(Object obj1, Object obj2) {
                String s1 = (String) obj1;
                String s2 = (String) obj2;
                return s1.length() < s2.length();
            }
        }
        
        StringComparator sc = new StringComparator();
        SortedList list = new SortedList(sc);
        list.add("quokka");
        list.add("waxwing");
        list.add("blobfish");
        for (int i = 0; i < 3; i++) {
            System.out.println(list.get(i));
        }
        
        class RectangleComparator implements Sortable {
            @Override
            public boolean comesBefore(Object obj1, Object obj2) {
                Rectangle s1 = (Rectangle) obj1;
                Rectangle s2 = (Rectangle) obj2;
                double a1 = s1.getWidth() * s1.getHeight();
                double a2 = s2.getWidth() * s2.getHeight();
                return a1 < a2;
            }
        }
        
        RectangleComparator rc = new RectangleComparator();
        list = new SortedList(rc);
        list.add(new Rectangle(8, 5));
        list.add(new Rectangle(3, 9));
        System.out.println(list.get(0));
        System.out.println(list.get(1));
            
    }
        
}