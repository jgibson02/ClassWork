package face;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.border.MatteBorder;

/**
 * A border styled as a rounded rectangle of a specified radius.
 *
 * @author John Gibson
 */
public class RoundedBorder extends MatteBorder {

    private final int RADIUS;
    private static int borderThickness;

    /**
     * Sets a RoundedBorder which has components from MatteBorder.
     *
     * @param top width of each border side
     * @param left width of each border side
     * @param bottom width of each border side
     * @param right width of each border side
     * @param radius radius of curvature of rounded border
     * @param c color to set border to
     */
    public RoundedBorder(int top, int left, int bottom, int right, int radius, Color c) {
        super(top, left, bottom, right, c);
        borderThickness = 6;
        this.RADIUS = radius;
    }

    /**
     * Paints the border of a specified component as a rounded rectangle.
     *
     * @param c specific button to draw on
     * @param g the graphics object to be used to paint the border
     * @param x start of border drawing
     * @param y start of border drawing
     * @param w width of border drawing
     * @param h height of border drawing
     */
    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int w, int h) {
        Graphics2D g2 = (Graphics2D) g;
        g.setColor(Color.BLACK);

        g2.setStroke(new BasicStroke(borderThickness));
        g.drawRoundRect(x + borderThickness / 2, y + borderThickness / 2, w - borderThickness, h - borderThickness, RADIUS, RADIUS);
    }
}
