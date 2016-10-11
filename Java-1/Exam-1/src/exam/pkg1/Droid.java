/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class Droid extends JComponent {
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.addRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
        g2.setColor(Color.ORANGE);
        g2.fill(new Rectangle(400, 400));
        
        //head
        g2.setColor(Color.BLACK);
        g2.fill(new Rectangle(100, 100, 200, 200));
        
        //eyes
        g2.setColor(Color.LIGHT_GRAY);
        g2.fill(new Rectangle(150, 150, 20, 20));
        g2.fill(new Rectangle(230, 150, 20, 20));
        
        //mouth
        g2.fill(new Rectangle(160, 250, 80, 15));
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Droid");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setResizable(false);
        frame.add(new Droid());
        frame.setVisible(true);
    }
}
