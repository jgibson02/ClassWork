package sortable1;

import java.util.ArrayList;
import java.util.Random;

/**
 * List of points in sorted order according to distance from origin.
 * 
 * @author John Gibson
 */
public class SortedListOfPoints {
    
    private final ArrayList<Point> listOfPoints;
    
    /**
     * Creates an empty list of points.
     */
    public SortedListOfPoints() {
        listOfPoints = new ArrayList<>();
    }
    
    /**
     * Adds a point to the list in sorted order.
     */
    public void add(Point p) {
        int i = 0;
        int size = listOfPoints.size();
        double dist = p.distance();
        while (i < size && listOfPoints.get(i).distance() < dist) {
            i++;
        }
        listOfPoints.add(i, p);
    }
    
    /**
     * Gets a point of the list.
     * @param i the index of the point to return
     */
    public Point get(int i) {
       return listOfPoints.get(i);
    }
    
    /**
     * Returns the number of points in the list.
     */
    public int size() {
        return listOfPoints.size();
    }
    
    // test program
    public static void main(String[] args) {
        Random rand = new Random();
        SortedListOfPoints list = new SortedListOfPoints();
        for (int i = 0; i < 10; i++) {
            int x = rand.nextInt(100);
            int y = rand.nextInt(100);
            list.add(new Point(x, y));
        }
        
        // output contents of list
        for (int i = 0; i < 10; i++) {
            Point p = list.get(i);
            System.out.println(p + " " + p.distance());
        }
    }
}
