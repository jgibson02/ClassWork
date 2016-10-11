/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphics;

import java.awt.*;
import javax.swing.JComponent;

/**
 *
 * @author John Gibson
 */
class RectangleComponent extends JComponent {

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        
        Rectangle r = new Rectangle(50, 50, 400, 250);
        Rectangle s = new Rectangle(r);
        s.translate(75, 100);
        
        Color c = new Color(28, 201, 173);
        g2.setColor(c);
        g2.fill(r);
        
        Color c2 = new Color (86, 219, 213);
        g2.setColor(c2);
        g2.fill(s);
        
        Rectangle intersection = r.intersection(s);
        g2.setColor(Color.CYAN);
        g2.fill(intersection);
        
    }
    
}
