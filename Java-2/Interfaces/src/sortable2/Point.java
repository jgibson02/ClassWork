package sortable2;

/**
 * An immutable point in the plane with integer coordinates.
 * 
 * @author John Gibson
 */
public class Point implements Sortable {
    
    private final int x;
    private final int y;
    
    /**
     * Constructs a new point at a given location.
     * @param x the x-coordinate of the point
     * @param y the y-coordinate of the point
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Returns the x-coordinate of this point.
     * @return 
     */
    public int getX() {
        return x;
    }
    
    /**
     * Returns the y-coordinate of this point.
     * @return 
     */
    public int getY() {
        return y;
    }
    
    /**
     * Returns a text description of this point.
     */
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
    
    /**
     * Returns the distance of this point from the origin.
     */
    public double distance() {
        return Math.hypot(x, y);
    }
    
    /**
     * Compares this point with another given point and returns true if this one comes before the
     * other in sorted order.
     */
    @Override
    public boolean comesBefore(Sortable point) {
        Point p = (Point) point;
        return this.distance() < p.distance();
    }
    
    
}
