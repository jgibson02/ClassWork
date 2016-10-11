package exam3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;
import javax.swing.border.MatteBorder;

/**
 * 
 * @author John Gibson
 * @version Apr 13, 2016
 */
public class Patch extends JComponent {
    private int size;
    private int red;
    private int green;
    private int blue;
    
    public Patch(int size, Color color) {
        this.size = size;
        this.red = color.getRed();
        this.green = color.getGreen();
        this.blue = color.getBlue();
        int borderThickness;
        switch (size) {
            case 25: 
                borderThickness = 1;
                break;
            case 100: 
                borderThickness = 5;
                break;
            default : 
                borderThickness = 3;
        }
        setBorder(new MatteBorder(borderThickness, borderThickness, borderThickness, 
                borderThickness, Color.BLACK));
        setPreferredSize(new Dimension(size, size));
    }
    
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        
        int w = getWidth();
        int h = getHeight();
        
        g2.setColor(new Color(red, green, blue));
        g2.fill(new Rectangle(size, size));
    }
    
    public Color getColor() {
        return new Color(red, green, blue);
    }
    
    public void setColor(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        repaint();
    }
    
}