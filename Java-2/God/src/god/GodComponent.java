package god;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.RenderingHints;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author John
 */
public class GodComponent extends JComponent {
    private static Point p1;
    private static Point p2;
    private static Point p3;
    private static int w;
    private static int h;
    
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.addRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
        
        w = getWidth();
        h = getHeight();
        
        p1 = new Point(w/3, 2 * (h/3));
        p2 = new Point(w/2, h/3);
        p3 = new Point(2 * (w/3), 2 * (h/3));
        
        int[] xPoints = {p1.x, p2.x, p3.x};
        int[] yPoints = {p1.y, p2.y, p3.y};
        
        Polygon triangle = new Polygon(xPoints, yPoints, 3);
        g2.fill(triangle);
        JLabel label = new JLabel(new ImageIcon("cage.jpg"));
    }
}
