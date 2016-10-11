package exam.pkg1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *
 * @author John
 */
public class ResizableDroid extends JComponent {
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.addRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
        
        int w = getWidth();
        int h = getHeight();
        
        g2.setColor(Color.ORANGE);
        g2.fill(new Rectangle(w, h));
        
        g2.translate(w/2, h/2);
        
        //head
        g2.setColor(Color.BLACK);
        final int HEAD_SIZE = 200;
        g2.fill(new Rectangle(-100, -100, HEAD_SIZE, HEAD_SIZE));
        
        //eyes
        g2.setColor(Color.LIGHT_GRAY);
        final int EYE_SIZE = 20;
        g2.fill(new Rectangle(-50, -50, EYE_SIZE, EYE_SIZE));
        g2.fill(new Rectangle(30, -50, EYE_SIZE, EYE_SIZE));
        
        //mouth
        final int MOUTH_WIDTH = 80;
        final int MOUTH_HEIGHT = 15;
        g2.fill(new Rectangle(-40, 50, MOUTH_WIDTH, MOUTH_HEIGHT));
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Droid");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setResizable(true);
        frame.add(new ResizableDroid());
        frame.setVisible(true);
    }
}