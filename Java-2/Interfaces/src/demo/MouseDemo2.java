package demo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * Clicking in the component area causes it to fill with a random color.
 * 
 * @author jhg95693
 */
public class MouseDemo2 extends JComponent {
    private Color backgroundColor;
    
    public MouseDemo2() {
        class Listener extends MouseAdapter {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Mouse Clicked");
                Random rand = new Random();
                int r = rand.nextInt(256);
                int g = rand.nextInt(256);
                int b = rand.nextInt(256);
                backgroundColor = new Color(r, g, b);
                repaint();
            }
            
            @Override
            public void mouseDragged (MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                System.out.println(x + " " + y);
            }
        }
        
        Listener listener = new Listener();
        addMouseListener(listener);
        addMouseMotionListener(listener);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(backgroundColor);
        g2.fill(new Rectangle(getWidth(), getHeight()));
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Mouse Demo");
        frame.add(new MouseDemo2());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 700);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
