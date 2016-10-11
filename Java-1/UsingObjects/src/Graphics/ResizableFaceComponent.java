/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import javax.swing.JComponent;

/**
 * Draws a resizable face.
 * @author John
 */
public class ResizableFaceComponent extends JComponent {
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        
        g2.addRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
        
        //background
        int w = getWidth();
        int h = getHeight();
        g2.setColor(Color.GRAY);
        g2.fill(new Rectangle(w, h));
        
        //move the origin to center of the drawing area
        g2.translate(w/2, h/2);
        
        final int N = Math.min(w, h);
        
        //distance from head to edge of viewing area
        final int SPACE = 20;
        
        //head
        Ellipse2D.Double head = new Ellipse2D.Double(-N/2 + SPACE, -N/2 + SPACE, N - 2*SPACE, N - 2*SPACE);
        g2.setColor(Color.YELLOW);
        g2.fill(head);
        
        //eyes
        g2.setColor(Color.BLACK);
        final int EYE_RADIUS = 30;
        final int EYE_DIAMETER = 2 * EYE_RADIUS;
        int leftEyeCenterX = -w / 5;
        int leftEyeCenterY = -h / 5;
        Ellipse2D.Double leftEye = new Ellipse2D.Double(leftEyeCenterX - EYE_RADIUS, leftEyeCenterY - EYE_RADIUS, EYE_DIAMETER, EYE_DIAMETER);
        int rightEyeCenterX = w / 5;
        int rightEyeCenterY = -h / 5;
        Ellipse2D.Double rightEye = new Ellipse2D.Double(rightEyeCenterX - EYE_RADIUS, rightEyeCenterY - EYE_RADIUS, EYE_DIAMETER, EYE_DIAMETER);
        g2.fill(leftEye);
        g2.fill(rightEye);
    }
}
