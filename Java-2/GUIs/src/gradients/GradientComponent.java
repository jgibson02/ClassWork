package gradients;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.MultipleGradientPaint;
import java.awt.RadialGradientPaint;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JColorChooser;
import javax.swing.JComponent;

/**
 * A component with a background gradient color.
 * 
 * @author John Gibson
 * @version Mar 28, 2016
 */
public class GradientComponent extends JComponent {

    private final Color[] gradientColors = new Color[2];
    
    private enum GradientType {
        LINEAR, RADIAL, NONE
    }
    
    private GradientType gType = GradientType.LINEAR;
    
    // Floating-point numbers between 0 and 1 specifying the distribution of colors along 
    // the gradient. The first fraction must be smaller than the second.
    private final float[] fractions = {0.1f, 1.0f};
    
    /**
     * Constructs a new gradient component.
     * @param startGradient the starting color of the gradient
     * @param endGradient the ending color of the gradient
     */
    public GradientComponent(Color startGradient, Color endGradient) {
        gradientColors[0] = startGradient;
        gradientColors[1] = endGradient;
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                gradientColors[0] = JColorChooser.showDialog(null, "Starting Color", Color.RED);
                gradientColors[1] = JColorChooser.showDialog(null, "Ending Color", Color.ORANGE);
                repaint();
            }
        });
    }
    
    public void setLinearGradient() {
        gType = GradientType.LINEAR;
        repaint();
    }
    
    public void setRadialGradient() {
        gType = GradientType.RADIAL;
        repaint();
    }
    
    public void setNoGradient() {
        gType = GradientType.NONE;
        repaint();
    }
    
    public void setDistributionFractions(float d1, float d2) {
        fractions[0] = d1;
        fractions[1] = d2;
        repaint();
    }
    
    public float getFraction1() {
        return fractions[0];
    }
    
    public float getFraction2() {
        return fractions[1];
    }
    
    public void invertColors() {
        Color t1 = new Color(1 - gradientColors[0].getRGB());
        Color t2 = new Color(1 - gradientColors[1].getRGB());
        gradientColors[0] = t1;
        gradientColors[1] = t2;
        repaint();
    }
    
    public void swapColors() {
        Color t1 = gradientColors[0];
        Color t2 = gradientColors[1];
        gradientColors[0] = t2;
        gradientColors[1] = t1;
        repaint();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.addRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, 
                RenderingHints.VALUE_ANTIALIAS_ON));
        int w = getWidth();
        int h = getHeight();
        
        MultipleGradientPaint paint;
        switch (gType) {
            case LINEAR:
                paint = new LinearGradientPaint(0, 0, w, h, fractions, gradientColors);
                break;
            case RADIAL:
                float radius = Math.max(w/2, h/2);
                paint = new RadialGradientPaint(w/2, h/2, radius, fractions, gradientColors);
                break;
            default:
                paint = null;
        }
        
        if (paint == null) {
            g2.setColor(gradientColors[0]);
        } else {
            g2.setPaint(paint);
        }
        g2.fill(new Rectangle(w, h));
    }

}