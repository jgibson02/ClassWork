package convexpoly;

import java.awt.Polygon;

/**
 * 
 * @author John Gibson
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Polygon p = new Polygon();
        p.addPoint(12, 23);
        p.addPoint(27, 40);
        p.addPoint(0, 57);
        
        Polygon q = new Polygon(/*x*/ new int[] {12, 27, 0}, /*y*/ new int[] {23, 40, 57}, 3);
        
        ConvexPolygon cp = new ConvexPolygon();
        cp.addPoint(0, 0);
        cp.addPoint(50, 0);
        cp.addPoint(0, 50);
        
        int[] a = {0, 50, 0};
        int[] b = {0, 0, 50};
        ConvexPolygon anotherCp = new ConvexPolygon(a, b, 3);
    }

}