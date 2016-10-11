/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphics;

import java.awt.*;
import java.util.Random;
import javax.swing.JComponent;

/**
 *
 * @author jhg95693
 */
class RectangleComponent2 extends JComponent {
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        
        //fill in the background
        Color bgColor = new Color(240, 240, 250);
        g2.setColor(bgColor);
        int w = getWidth();
        int h = getHeight();
        g2.fill(new Rectangle(0, 0, w, h));
        
        Color c;
        Random r = new Random(); // for random colors
        
        //create first rectangle in a random position
        int x = r.nextInt(w / 2);
        int y = r.nextInt(h / 2);
        Rectangle rectl = new Rectangle(x, y, w / 2, h / 2);
        
        //make a random color and fill in the first rectangle
        int rgbR = r.nextInt(256);
        int rgbG = r.nextInt(256);
        int rgbB = r.nextInt(256);
        c = new Color(rgbR, rgbG, rgbB);
        g2.setColor(c);
        g2.fill(rectl);
    }
}
