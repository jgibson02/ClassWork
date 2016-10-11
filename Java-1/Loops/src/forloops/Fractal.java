package forloops;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.util.Random;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *
 *
 * @author John Gibson}
 */
public class Fractal extends JComponent {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(1000, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.add(new Fractal());
        frame.setVisible(true);
        frame.setResizable(true);
        frame.setAlwaysOnTop(true);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        int w = getWidth();
        int h = getHeight();
        
        // fill in background
        g2.setColor(Color.BLACK);
        g2.fill(new Rectangle(w, h));
        g2.setColor(Color.CYAN);
        
        //three corners
        Point2D.Double p1 = new Point2D.Double(w/2, 0);
        Point2D.Double p2 = new Point2D.Double(0, h);
        Point2D.Double p3 = new Point2D.Double(w, h);
        
        /*
        1. Pick a corner at random and call it the current point.
        2. Pick a corner at random and call it the next point.
        3. Draw a dot midway between the current and next point.
        4. Let the dot be the new current point and go back to step (2).
        */
        Point2D.Double currentPoint = getRandomPoint(p1, p2, p3);
        final int NUM_DOTS = 3_000_000;
        for (int i = 0; i < NUM_DOTS; i++) {
            Point2D.Double next = getRandomPoint(p1, p2, p3);
            currentPoint = getMidpoint(currentPoint, next);
            
            // draw the midpoint
            double x = currentPoint.getX();
            double y = currentPoint.getY();
            Ellipse2D.Double dot = new Ellipse2D.Double(x, y, 1, 1);
            g2.fill(dot);
        }
    }
    
    private Point2D.Double getMidpoint(Point2D.Double a, Point2D.Double b) {
        double x = (a.getX() + b.getX()) / 2;
        double y = (a.getY() + b.getY()) / 2;
        return new Point2D.Double(x, y);
    }
    
    /**
     * Gets a random point.
     * @param a a point
     * @param b a point
     * @param c a point
     * @return one of the three given points selected at random
     */
    private Point2D.Double getRandomPoint(Point2D.Double a, Point2D.Double b, 
            Point2D.Double c) {
        Random rand = new Random();
        int k = rand.nextInt(3);
        if (k == 0) {
            return a;
        }
        if (k == 1) {
            return b;
        }
        return c;
   }
    
}
