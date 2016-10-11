/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package whileloops;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.util.Random;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * This program simulates a random person stumbling around town until he reaches
 * the outskirts of town, and tells the user how many steps it took him to get
 * there.
 * 
 * @author John Gibson}
 */
public class VisualRandomWalk extends JComponent {
    String input = JOptionPane.showInputDialog("Enter the radius of the circle in pixels: ");
    int radius = Integer.parseInt(input);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frame;
        frame = new JFrame("Random Walk");
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new VisualRandomWalk());
        frame.setVisible(true);
        frame.setResizable(false);
    }
    
    @Override
    public void paintComponent (Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        
        //antialiasing
        g2.addRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, 
                RenderingHints.VALUE_ANTIALIAS_ON));
        
        int w = getWidth();
        int h = getHeight();
        int x = 0;
        int y = 0;
        g2.translate(w/2, h/2);
                
        g2.setColor(Color.CYAN);
        g2.setStroke(new BasicStroke(10, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        Ellipse2D.Double circle = new Ellipse2D.Double(-radius, -radius, 2 * radius, 2 * radius);
        g2.draw(circle);
        
        Rectangle man = new Rectangle(-5, -5, 10, 10);
        g2.setColor(Color.GREEN);
        g2.fill(man);
        
        final int STEP = 10;
        Random rand = new Random();
        int steps = 0;
        while (Math.hypot(x, y) < radius) {
            int k = rand.nextInt(4);
            if (k == 0) {
                x = x + STEP;
            }
            if (k == 1) {
                x = x - STEP;
            }
            if (k == 2) {
                y = y + STEP;
            }
            if (k == 3) {
                y = y - STEP;
            }
            man.setLocation(x, y);
            steps++;
        }
        JOptionPane.showMessageDialog(null, steps);
    }

}
