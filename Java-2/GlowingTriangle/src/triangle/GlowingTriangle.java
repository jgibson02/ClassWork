package triangle;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 * This program creates a window in which the user can select 3 points by clicking the
 * mouse, creating a glowing red triangle out of the three points. The user can then also
 * drag the triangle around the window.
 * 
 * @author John Gibson
 */
public class GlowingTriangle extends JComponent {

    Point p1;
    Point p2;
    Point p3;
    static int alpha = 20;
    static int clicks = 0;
    final static int DELAY = 10;
    Polygon triangle = new Polygon();
    Color triangleColor = new Color(255, 0, 0, alpha);
    
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;       
        
        // create background
        g2.setColor(Color.BLACK);
        g2.fill(new Rectangle(getWidth(), getHeight()));

        //antialiasing
        g2.addRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON));

        // set color and fill the triangle
        g2.setColor(triangleColor);
        g2.fillPolygon(triangle);
    }
    
    public GlowingTriangle() {
        
        class TimerListener implements ActionListener {

            boolean increasing = true;
            final int MIN_ALPHA = 20;
            final int MAX_ALPHA = 200;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (alpha == MAX_ALPHA) { // if at max, start decreasing
                    increasing = false;
                }
                if (alpha == MIN_ALPHA && !increasing) { // if at min, start increasing
                    increasing = true;
                }
                if (increasing && alpha < MAX_ALPHA) { // if increasing and less than
                    alpha++;                           // max, keep increasing
                }
                if (!increasing && alpha > MIN_ALPHA) { // if decreasing and greater than
                    alpha--;                            // min, keep decreasing
                }
                triangleColor = new Color(255, 0, 0, alpha); // give triangle new alpha
                repaint(); // update the window
            }
        }
        
        TimerListener tListener = new TimerListener();
        final Timer t = new Timer(DELAY, tListener);
        
        class Listener extends MouseAdapter {
            
            int oldX;
            int oldY;
            boolean mouseDragged = false;
            
            @Override
            public void mouseClicked(MouseEvent e) {
                clicks++;
                int x = e.getX();
                int y = e.getY();
                if (clicks <= 3) {
                    triangle.addPoint(x, y);
                }
                if (clicks >= 3) {
                    t.start();
                }
            }
            
            @Override
            public void mouseDragged (MouseEvent e) {
                if (clicks >= 3 && triangle.contains(e.getPoint())) {
                    setCursor(new Cursor(Cursor.HAND_CURSOR));
                    int x = e.getX();
                    int y = e.getY();
                    if (mouseDragged && clicks >= 3) {
                        triangle.translate(x - oldX, y - oldY);
                    }
                    oldX = x;
                    oldY = y;
                    mouseDragged = true;
                    repaint();
                }
            }
            
            @Override
            public void mouseReleased (MouseEvent e) {
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        }

        Listener listener = new Listener();
        addMouseListener(listener);
        addMouseMotionListener(listener);
    }

    public static void main(String[] args) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double height = screenSize.getHeight();
        double width = screenSize.getWidth();
        
        JFrame frame = new JFrame("Glowing Triangle");
        frame.getContentPane().setBackground(Color.BLACK);
        frame.add(new GlowingTriangle());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize((int) (width * 0.5), (int) (height * 0.75));
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}