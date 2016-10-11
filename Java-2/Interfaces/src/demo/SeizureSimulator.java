package demo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 * Endangers epileptic end-users.
 * @author jhg95693
 */
public class SeizureSimulator extends JComponent {

    private Color backgroundColor;
        
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(backgroundColor);
        g2.fill(new Rectangle(getWidth(), getHeight()));
    }
    
    public SeizureSimulator() {
        class TimerListener implements ActionListener {         
            @Override
            public void actionPerformed(ActionEvent e) {
                Random rand = new Random();
                int r = rand.nextInt(256);
                int g = rand.nextInt(256);
                int b = rand.nextInt(256);
                backgroundColor = new Color(r, g, b);
                repaint();
            }
        }
        TimerListener listener = new TimerListener();
        Timer t = new Timer(17, listener);
        t.start();
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Seizure Simulator");
        frame.add(new SeizureSimulator());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        frame.setVisible(true);
    }

}