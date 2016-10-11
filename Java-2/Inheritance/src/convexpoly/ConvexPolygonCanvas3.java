package convexpoly;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JColorChooser;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;

/**
 * Draws a convex polygon with corners specified by mouse clicks. The user can click to
 * add a corner or drag to see a prospective new corner. Clicking near the center of the
 * polygon's bounding box will randomize the gradient colors. There are options to manage
 * colors. There are options to manage colors and to remove the most recently added 
 * corner.
 * 
 * @author John Gibson
 */
public class ConvexPolygonCanvas3 extends JComponent {
    
    private final ConvexPolygon convexPoly = new ConvexPolygon();
    private Color gradientStart = Color.ORANGE;
    private Color gradientEnd = Color.BLACK;
    private Color background = Color.DARK_GRAY;
    
    private final JPopupMenu popupMenu = new JPopupMenu("Options");
    
    public ConvexPolygonCanvas3() {        
        initLeftClickEvents();
        initPopupEvents();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.addRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON));
        g2.setColor(background);
        g2.fill(new Rectangle(getWidth(), getHeight()));
        
        // create a gradient color
        Rectangle box = convexPoly.getBounds();
        int x1 = (int) box.getX();
        int y1 = (int) box.getY();
        int x2 = x1 + (int) box.getWidth();
        int y2 = y1 + (int) box.getHeight();
        GradientPaint paint = new GradientPaint(
                x1, y1, gradientStart,
                x2, y2, gradientEnd);
        
        g2.setPaint(paint);
        g2.fill(convexPoly);
    }
    
    /**
     * Initialize event handlers for left mouse button click. The user can click to add a
     * new corner and optionally dragging it with the mouse.
     */
    private void initLeftClickEvents() {
        MouseAdapter mouseAdapter = new MouseAdapter() {
            private boolean dragging = false;
            
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    dragging = true;
                    convexPoly.addPoint(e.getX(), e.getY());
                    repaint();
                }
            }
            
            @Override
            public void mouseReleased(MouseEvent e) {
                dragging = false;
            }
            
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    convexPoly.addPoint(e.getX(), e.getY());
                    repaint();
                }                
            }
            
            @Override
            public void mouseDragged(MouseEvent e) {
                if (dragging) {
                    convexPoly.removePoint();
                    convexPoly.addPoint(e.getX(), e.getY());
                    repaint();
                }
            }           
        };
        
        addMouseListener(mouseAdapter);
        addMouseMotionListener(mouseAdapter);
    }

    /**
     * Initialize pop-up menu with options for changing colors and removing a corner.
     */
    private void initPopupEvents() {
        // menu options for changing colors
        JMenuItem startColorItem = new JMenuItem("Start gradient");
        JMenuItem endColorItem = new JMenuItem("End gradient");
        JMenuItem randomGradientItem = new JMenuItem("Random gradient");
        JMenuItem bgColorItem = new JMenuItem("Background");
        popupMenu.add(startColorItem);
        popupMenu.add(endColorItem);
        popupMenu.add(randomGradientItem);
        popupMenu.add(bgColorItem);
        
        // create and register event handler for removing corner
        JMenuItem removeItem = new JMenuItem("Remove corner");
        popupMenu.add(new JSeparator());
        popupMenu.add(removeItem);
        
        removeItem.addActionListener((ActionEvent e) -> {
            convexPoly.removePoint();
            repaint();
        });
        
        // create and register event handler for pop-up menu
        class PopupListener extends MouseAdapter {

            @Override
            public void mouseReleased(MouseEvent e) {
                maybeShowPopup(e);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    
                }
            }
            
            private void maybeShowPopup(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    popupMenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }
            
        }
        addMouseListener(new PopupListener());
        
        // create event handler for color options
        ActionListener listener = (ActionEvent e) -> {
            Object src = e.getSource();
            if (src == randomGradientItem) {
                gradientStart = getRandomColor();
                gradientEnd = getRandomColor();
            }
            else if (src == bgColorItem) {
                background = JColorChooser.showDialog(popupMenu, "Background", background);
            }
            else if (src == startColorItem) {
                gradientStart = JColorChooser.showDialog(popupMenu, "Gradient start", gradientStart);
            }
            else if (src == endColorItem) {
                gradientEnd = JColorChooser.showDialog(popupMenu, "Gradient end", gradientEnd);
            }
            repaint();
        };
        
        // register event handler for color options
        randomGradientItem.addActionListener(listener);
        startColorItem.addActionListener(listener);
        endColorItem.addActionListener(listener);
        bgColorItem.addActionListener(listener);
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
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Convex Polygon");
        frame.add(new ConvexPolygonCanvas3());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
    }
    
}