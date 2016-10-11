package convexpoly;

import java.awt.Polygon;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * @author John Gibson
 */
public class ConvexPolygon extends Polygon {
    
    private final ArrayList<Point> listOfPoints;
    
    public ConvexPolygon() {
        super();
        listOfPoints = new ArrayList<>();
    }
    
    public ConvexPolygon(int[] x, int[] y, int n) {
        super(x, y, n);
        listOfPoints = new ArrayList<>();
    }
    
    public void removePoint() {
        int n = listOfPoints.size();
        if (n > 0) {
            listOfPoints.remove(n - 1);
            setToHull();
        }
    }
    
    /**
     * Adds a new point to this polygon if convexity will be maintained.
     * @param x the x-coordinate of the point to add
     * @param y the y-coordinate of the point to add
     */
    @Override
    public void addPoint(int x, int y) {
        listOfPoints.add(new Point(x, y));
        int n = listOfPoints.size();
        if (n < 3) {
            return;
        }
        setToHull();
    }
    
    /**
     * Converts the list of points into its convex hull and then takes the corners of the 
     * hull as the updated list.
     */
    private void setToHull() {
        // Copy the points into an array which will be passed to getConvexHull
        Point[] temp = new Point[listOfPoints.size()];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = listOfPoints.get(i);
        }
        Point[] hull = getConvexHull(temp);
        
        // Clear the list of points for this polygon and then add all of the corners of 
        // the convex hull to the list.
        listOfPoints.clear();
        listOfPoints.addAll(Arrays.asList(hull));
        rebuildPolygon();
    }
    
      /**
     * Calculates the convex hull of a given set of points. The code is adapted from
     * en.wikibooks.org/wiki/Algorithm_Implementation/Geometry/Convex_hull/Monotone_chain
     *
     * @param points a collection of points
     * @return the corner points of the convex hull
     */
    private static Point[] getConvexHull(Point[] points) {
        if (points.length <= 1) {
            return points;
        }

        int n = points.length;
        int k = 0;
        Point[] h = new Point[2 * n];
        Arrays.sort(points);

        for (int i = 0; i < n; ++i) { // Build lower hull.
            while (k >= 2 && cross(h[k - 2], h[k - 1], points[i]) <= 0) {
                k--;
            }
            h[k++] = points[i];
        }

        for (int i = n - 2, t = k + 1; i >= 0; i--) {  // Build upper hull.
            while (k >= t && cross(h[k - 2], h[k - 1], points[i]) <= 0) {
                k--;
            }
            h[k++] = points[i];
        }
        if (k > 1) { // Remove non-hull vertices after k; remove k-1 which is a duplicate.            
            h = Arrays.copyOfRange(h, 0, k - 1);
        }
        return h;
    }

    /**
     * Helper method used by getConvexHull. It computes the 2D cross product of vectors pq and pr 
     * (i.e., the z-component of the 3D cross product).
     *
     * @param p
     * @param q
     * @param r
     * @return a positive value if pqr makes a counter-clockwise turn, negative for a
     * clockwise turn, and zero if the points are collinear.
     */
    private static long cross(Point p, Point q, Point r) {
        return (q.x - p.x) * (r.y - p.y) - (q.y - p.y) * (r.x - p.x);
    }
    
    /**
     * Rotates each corner of this polygon about a specified point.
     * 
     * @param degrees 
     * @param originX 
     * @param originY 
     */
    public void rotate(double degrees, int originX, int originY) {
        listOfPoints.stream().forEach((p) -> {
            p.x -= originX;
            p.y -= originY;
            double sin = Math.sin(Math.toRadians(degrees));
            double cos = Math.cos(Math.toRadians(degrees));
            p.setLocation(p.x * cos - p.y * sin, p.x * sin + p.y * cos);
            p.x += originX;
            p.y += originY;
        });
       rebuildPolygon();
    }

    /**
     * Adds points in list to this polygon. Called when the list has changed.
     */
    private void rebuildPolygon() {
        reset();
        for (Point p : listOfPoints) {
            super.addPoint(p.x, p.y);
        }
    }
    
}

/**
 * An extension of java.awt.Point that implements the Comparable interface so that points
 * can be sorted as needed for the convex hull algorithm used in ConvexPolygon above.
 */
class Point extends java.awt.Point implements Comparable {

    public Point(int x, int y) {
        super(x, y);
    }
    
    /**
     * 
     * @param o
     * @return true if this point is to the left of, or below, the given point of 
     */
    @Override
    public int compareTo(Object o) {
        Point p = (Point) o;
        if (this.x == p.x) {
            return this.y - p.y;
        }
        return this.x - p.x;
    }
    
}