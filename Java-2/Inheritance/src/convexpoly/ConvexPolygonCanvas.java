package convexpoly;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * Draws a convex polygon with corners specified by mouse clicks.
 * 
 * @author John Gibson
 */
public class ConvexPolygonCanvas extends JComponent {
    
    private final ConvexPolygon convexPoly = new ConvexPolygon();
    
    public ConvexPolygonCanvas() {        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                convexPoly.addPoint(e.getX(), e.getY());
                repaint();
                System.out.println("Clicked");
            }
        });
    }
    
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.addRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON));
        g2.setColor(Color.CYAN);
        
        Rectangle box = convexPoly.getBounds();
        int x1 = (int) box.getX();
        int y1 = (int) box.getY();
        int x2 = x1 + (int) box.getWidth();
        int y2 = y1 + (int) box.getHeight();
        Color gradientStart = Color.ORANGE;
        Color gradientEnd = Color.BLACK;
        GradientPaint paint = new GradientPaint(x1, y1, gradientStart, x2, y2, gradientEnd);
        
        g2.fill(convexPoly);
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Convex Polygon");
        frame.add(new ConvexPolygonCanvas());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
    }
    
}