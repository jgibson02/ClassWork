package demo;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.util.Random;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author John Gibson
 */
public class CookieClicker extends JComponent {

    Random rand = new Random();
    static int w;
    static int h;
    static int clickCount;
    static JLabel clickCountLabel;
    
    @Override
    public void paintComponent(Graphics g) {
	Graphics2D g2 = (Graphics2D) g;
	w = getWidth();
	h = getHeight();
	g2.translate(w / 2, h / 2);
        
        // antialiasing
        g2.addRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, 
                RenderingHints.VALUE_ANTIALIAS_ON));

	// create cookie
	Color cookieColor = new Color(155, 114, 57);
	Ellipse2D.Double cookie = new Ellipse2D.Double(-w / 4, -h / 4, w / 2, h / 2);
	g2.setColor(cookieColor);
	g2.fill(cookie);

        g2.setColor(new Color(64, 30, 3));
        int numOfChips = rand.nextInt(3) + 4;
        for (int i = 0; i < numOfChips; i++) {
            g2.fill(getChip());
	}
    }

    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	class ButtonListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent ae) {
                clickCount++;
                clickCountLabel.setText(Integer.toString(clickCount));
            }
        }
        
        JFrame frame = new JFrame("Cookie Clicker");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(500, 500);
	frame.setVisible(true);
	frame.setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        Font f1 = new Font("SansSerif", Font.BOLD, 50);
        Font f2 = new Font("SansSerif", Font.BOLD, 20);
        
        JLabel ccLabel = new JLabel("Cookie Clicker");
        ccLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        ccLabel.setFont(f1);
        panel.add(ccLabel);
        
        panel.add(new CookieClicker());
        
        JButton clickButton = new JButton("Click Here");
        clickButton.addActionListener(new ButtonListener());
        clickButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(clickButton);
        
        
        clickCountLabel = new JLabel("0");
        clickCountLabel.setFont(f2);
        clickCountLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(clickCountLabel);
        
        frame.add(panel);
        
    }

    public Ellipse2D.Double getChip() {
        for (int i = 0; i < 100; i++) {
            int chipDiameter = rand.nextInt(50) + 20;
            int x = rand.nextInt(w/2 - (chipDiameter/2)) + -w/4;
            int y = rand.nextInt(h/2 - (chipDiameter/2)) + -h/4;
            if (Math.hypot(x, y) <=  (w/4 - chipDiameter/2)) {
                return new Ellipse2D.Double(x, y, chipDiameter, chipDiameter);
            }
        }
        return new Ellipse2D.Double(0, 0, 0, 0);
    }

}
