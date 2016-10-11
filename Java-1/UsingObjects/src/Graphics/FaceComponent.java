/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import javax.swing.JComponent;

/**
 * A face with two eyes
 * @author John
 */
public class FaceComponent extends JComponent {
    
    /**
     * Draws the face
     * @param g the graphics context
     */
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        
        //paint the background
        g2.setColor(Color.GRAY);
        g2.fill(new Rectangle(600, 600));
        
        // antialiasing
        g2.addRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
        
        //head
        Ellipse2D.Double head = new Ellipse2D.Double(60, 60, 480, 480);
        g2.setColor(Color.YELLOW);
        g2.fill(head);
        
        //eyes
        Ellipse2D.Double leftEye = new Ellipse2D.Double(200, 200, 40, 40);
        Ellipse2D.Double rightEye = new Ellipse2D.Double(340, 200, 40, 40);
        g2.setColor(Color.BLACK);
        g2.fill(leftEye);
        g2.fill(rightEye);
        
        //mouth
        g2.setStroke(new BasicStroke(7));
        Point2D.Double leftEnd = new Point2D.Double(225, 400);
        Point2D.Double rightEnd = new Point2D.Double(365, 400);
        Line2D.Double mouth = new Line2D.Double(leftEnd, rightEnd);
        g2.draw(mouth);
        
        // some text
        g2.setColor(Color.GREEN);
        Font font = new Font("SegoeUI", Font.BOLD, 24);
        g2.setFont(font);
        g2.drawString("Man looking bravely into the future...", 25, 30);
    }
}
