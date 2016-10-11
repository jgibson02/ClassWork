package demo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * Clicking in the component area causes it to fill with a random color.
 * 
 * @author jhg95693
 */
public class MouseDemo extends JComponent {
    private Color backgroundColor;
    
    public MouseDemo() {
        class Listener implements MouseListener {

            @Override
            public void mouseClicked(MouseEvent e) {
                Random rand = new Random();
                int r = rand.nextInt(256);
                int g = rand.nextInt(256);
                int b = rand.nextInt(256);
                backgroundColor = new Color(r, g, b);
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("Mouse Pressed");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("Mouse Released");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println("Mouse Entered");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                System.out.println("Mouse Exited");
            }
            
        }
        
        Listener listener = new Listener();
        addMouseListener(listener);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(backgroundColor);
        g2.fill(new Rectangle(getWidth(), getHeight()));
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Mouse Demo");
        frame.add(new MouseDemo());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
}
