package demo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 * Clicking in the component area causes it to fill with a random color.
 * 
 * @author jhg95693
 */
public class MouseDemo4 extends JComponent {
    private Color backgroundColor;
    
    public MouseDemo4() {
        
        
        class Listener extends MouseAdapter {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Mouse Clicked");
                Random rand = new Random();
                int r = rand.nextInt(256);
                int g = rand.nextInt(256);
                int b = rand.nextInt(256);
                backgroundColor = new Color(r, g, b);
            }
            
            @Override
            public void mouseDragged (MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                System.out.println(x + " " + y);
            }
        }
        
        Listener listener = new Listener();
        addMouseListener(listener);
        addMouseMotionListener(listener);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(backgroundColor);
        g2.fill(new Rectangle(getWidth(), getHeight()));
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Mouse Demo");
        frame.setLayout(new FlowLayout());
        
        JComponent c1 = new MouseDemo4();
        JComponent c2 = new MouseDemo4();
        JComponent c3 = new MouseDemo4();
        JComponent c4 = new MouseDemo4();
        JComponent c5 = new MouseDemo4();
        JComponent c6 = new MouseDemo4();
        JComponent c7 = new MouseDemo4();
        JComponent c8 = new MouseDemo4();
        JComponent c9 = new MouseDemo4();
        
        Dimension dim = new Dimension(400,200);
        c1.setPreferredSize(dim);
        c2.setPreferredSize(dim);
        c3.setPreferredSize(dim);
        c4.setPreferredSize(dim);
        c5.setPreferredSize(dim);
        c6.setPreferredSize(dim);
        c7.setPreferredSize(dim);
        c8.setPreferredSize(dim);
        c9.setPreferredSize(dim);
        
        frame.add(c1);
        frame.add(c2);
        frame.add(c3);
        frame.add(c4);
        frame.add(c5);
        frame.add(c6);
        frame.add(c7);
        frame.add(c8);
        frame.add(c9);
        
        frame.add(new MouseDemo4());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        
        class TimerListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                c1.repaint();
                c2.repaint();
                c3.repaint();
                c4.repaint();
                c5.repaint();
                c6.repaint();
                c7.repaint();
                c8.repaint();
                c9.repaint();
            }
        }
        Timer t = new Timer(15, new TimerListener());
        t.start();
    }
}
