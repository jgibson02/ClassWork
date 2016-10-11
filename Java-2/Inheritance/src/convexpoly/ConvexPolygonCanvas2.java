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
public class ConvexPolygonCanvas2 extends JComponent {
    
    private final ConvexPolygon convexPoly = new ConvexPolygon();
    private Color gradientStart = Color.ORANGE;
    private Color gradientEnd = Color.BLACK;
    
    public ConvexPolygonCanvas2() {        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                final int TOLERANCE = 50;
                Rectangle box = convexPoly.getBounds();
                int centerX = box.x + box.width / 2;
                int centerY = box.y + box.height / 2;
                double dist = Math.hypot(e.getX() - centerX, e.getY() - centerY);
                if (dist < TOLERANCE) {
                    gradientStart = getRandomColor();
                    gradientEnd = getRandomColor();
                } else {
                    convexPoly.addPoint(e.getX(), e.getY());
                }
                repaint();
                System.out.println("Clicked");
            }
        });
    }
    
    /**
     * Returns a color with a randomly generated RGB value.
     */
    private Color getRandomColor() {
        float r = (float) Math.random();
        float g = (float) Math.random();
        float b = (float) Math.random();
        return new Color(r, g, b);
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
        GradientPaint paint = new GradientPaint(x1, y1, gradientStart, x2, y2, gradientEnd);
        
        g2.setPaint(paint);
        g2.fill(convexPoly);
    }
    
    private void initMouseClicked() {
        
        
        MouseAdapter mouseAdapter = new MouseAdapter() {
            boolean dragging = false;
            
            @Override
            public void mouseClicked(MouseEvent e) {
                // If click was near the center of the polygon's bounding box, 
                // randomize gradients.
                final double TOLERANCE = 50; 
                Rectangle box = convexPoly.getBounds();
                int centerX = box.x + box.width / 2;
                int centerY = box.y + box.height / 2;
                double distanceFromCenter = Math.hypot(e.getX() - centerX, e.getY() - centerY);
                
                if (distanceFromCenter < TOLERANCE) {
                    gradientStart = getRandomColor();
                    gradientEnd = getRandomColor();
                } else {
                    convexPoly.addPoint(e.getX(), e.getY());
                }
                repaint();
            }
            
            @Override
            public void mouseDragged(MouseEvent e) {
                if (dragging) {
                    convexPoly.removePoint();
                    convexPoly.addPoint(e.getX(), e.getY());
                    repaint();
                }
            }
            
            @Override
            public void mousePressed(MouseEvent e) {
                dragging = true;
            }
            
            @Override
            public void mouseReleased(MouseEvent e) {
                dragging = false;
            }
        };
        addMouseListener(mouseAdapter);
        addMouseMotionListener(mouseAdapter);
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Convex Polygon");
        frame.add(new ConvexPolygonCanvas2());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
    }
    
}