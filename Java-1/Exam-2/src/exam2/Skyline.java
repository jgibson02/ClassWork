package exam2;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * This program draws a series of rectangles with randomly set heights resembling a city
 * skyline.
 *
 * @author John Gibson
 */
public class Skyline extends JComponent {
    public static Random rand = new Random();
    
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        int w = getWidth();
        int h = getHeight();
        
        final int WIDTH = 80;
        final int GAP = 5;
        int x = 0;
                
        while (x < w) {
            int y = 40 + rand.nextInt(h - 40);
            g2.fill(new Rectangle(x, h - y, WIDTH, y));
            x += WIDTH + GAP;
        }
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(505, 505);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Skyline());
        frame.setVisible(true);
        frame.setResizable(true);
        frame.setAlwaysOnTop(true);
    }

}
