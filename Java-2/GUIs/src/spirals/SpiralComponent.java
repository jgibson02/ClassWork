package spirals;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;
import javax.swing.JComponent;

/**
 * 
 * @author John Gibson
 * @version Apr 4, 2016
 */
public class SpiralComponent extends JComponent {
    
    public static final Color BG_COLOR = Color.BLACK;
    private static final Color SPIRAL_COLOR = Color.MAGENTA;
    private static boolean NAUTILUS_SHELL = false;
    
    // The radius of a curve at a given point is defined to be the radius of the circular
    // arc that best approximates the curve at that point. In the case of a spiral, the 
    // radius describes how tightly it winds around the center; the smaller the radius,
    // the tighter the winding.
    private int radius;
    
    public SpiralComponent(int radius) {
        this.radius = radius;
    }
    
    public int getRadius() {
        return radius;
    }
    
    public void setRadius(int radius) {
        this.radius = radius;
        repaint();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.addRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON));
        
        int w = getWidth();
        int h = getHeight();
        g2.setColor(BG_COLOR);
        g2.fill(new Rectangle(w, h));
        g2.translate(w / 2, h / 2);
        
        // We move a point around the center of a circle, steadily increasing its distance
        // from the origin. At each step, a line is drawn to the current point from the 
        // previous one. These lines will be small enough that the drawing will appear as
        // a smooth curve rather than a patchwork of line segments.
        double x1 = 0.0;
        double y1 = 0.0;
        final double STEP = 0.2;
        for (double a = 0.0; a < 6 * Math.PI; a += STEP) {
            // calculate position of next point
            double x2 = radius * a * Math.cos(a);
            double y2 = radius * a * Math.sin(a);
            
            g2.setColor(SPIRAL_COLOR);
            
            // draw line from (x1, y1) to (x2, y2) and update the current point to the next one
            g2.setStroke(new MultipleStroke(new BasicStroke(10), new BasicStroke(0.7f)));
            g2.draw(new Line2D.Double(x1, y1, x2, y2));
            x1 = x2;
            y1 = y2;
            
            if (NAUTILUS_SHELL) {
                g2.draw(new Line2D.Double(0, 0, x2, y2));
            }
        }
    }

    void setNautilusShell(boolean b) {
        NAUTILUS_SHELL = b;
        repaint();
    }
}