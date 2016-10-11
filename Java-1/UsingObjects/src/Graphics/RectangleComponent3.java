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
import java.util.Random;
import javax.swing.JComponent;

/**
 *
 * @author John
 */
public class RectangleComponent3 extends JComponent {
    
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        
        //fill in the background
        Color bgColor = new Color(240, 240, 250);
        g2.setColor(bgColor);
        int w = getWidth();
        int h = getHeight();
        g2.fill(new Rectangle(0, 0, w, h));
        
        Color c1 = randomColor();
        g2.setColor(c1);
        Rectangle rect1 = randomRectangle();
        g2.fill(rect1);
        
        Color c2 = randomColor();
        g2.setColor(c2);
        Rectangle rect2 = randomRectangle();
        g2.fill(rect2);
        
        g2.setColor(getBlend(c1, c2));
        g2.fill(rect1.intersection(rect2));
    }
            
    /**
     * Creates a color with a random rgb value.
     * @return a random color
     */
        
    private Color randomColor() {
        Random r = new Random();
        int red = r.nextInt(256);
        int green = r.nextInt(256);
        int blue = r.nextInt(256);
        Color c = new Color(red, green, blue);
        return c;
    }
    
    /**
     * Creates a rectangle in a random position
     * @return a randomly positioned rectangle
     */
    
    private Rectangle randomRectangle() {
        Random rand = new Random();
        int w = getWidth();
        int h = getHeight();
        int x = rand.nextInt(w/2);
        int y = rand.nextInt(h/2);
        Rectangle rect = new Rectangle(x, y, w / 2, h / 2);
        return rect;
    }
    
    /**
     * Creates a blend of two colors.
     * @param c1 a color
     * @param c2 a color
     * @return a blend of c1 and c2
     */
    
    private Color getBlend(Color c1, Color c2) {
        int r1 = c1.getRed();
        int g1 = c1.getGreen();
        int b1 = c1.getBlue();
        
        int r2 = c2.getRed();
        int g2 = c2.getGreen();
        int b2 = c2.getBlue();
        
        int newRed = (r1 + r2) / 2;
        int newGreen = (g1 + g2) / 2;
        int newBlue = (b1 + b2) / 2;
        
        return new Color(newRed, newGreen, newBlue);
        
    }
}