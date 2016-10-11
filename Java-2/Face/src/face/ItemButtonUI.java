package face;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;

/**
 * The listeners for the custom buttons.
 * 
 * Known errors: mousePressed(MouseEvent e) does not seem to draw a new border around
 * buttons, we don't know what could be causing this.
 *
 * @author John Gibson, Daniel Kilgallon
 */
public class ItemButtonUI extends BasicButtonUI implements Serializable, MouseListener {

    private static final int CORNER_RADIUS = 40;

    private static final int WIDTH = 100;
    private static final int HEIGHT = 100;

    public static final GradientPaint SELECTED_BACKGROUND_GRADIENT
            = new GradientPaint(new Point(0, 0), new Color(142, 212, 188),
                    new Point(100, 100), new Color(31, 159, 110));
    public static final GradientPaint NORMAL_GRADIENT_PAINT
            = new GradientPaint(new Point(0, 0), Color.WHITE,
                    new Point(100, 100), new Color(231, 255, 248));
    public static final Color SELECTED_BORDER_COLOR = new Color(0, 181, 196);

    protected static final Border BORDER_NORMAL = new RoundedBorder(5, 5, 5, 5, CORNER_RADIUS, Color.BLACK);
    protected static final Border BORDER_LOWERED = new RoundedBorder(5, 5, 5, 5, CORNER_RADIUS, SELECTED_BORDER_COLOR);

    /**
     * Paints the button
     * @param g the graphics object to be used for painting
     * @param c the specific button the method is painting
     */
    @Override
    public void paint(Graphics g, JComponent c) {
        AbstractButton b = (AbstractButton) c;
        ItemButton ib = (ItemButton) b;
        Dimension d = b.getSize();
        Graphics2D g2 = (Graphics2D) g;

        // fill background
        if (ib.getBackgroundColor() != null) {
            g2.setPaint(new GradientPaint(new Point(0, 0), ib.getBackgroundColor().brighter(), new Point(100, 100), ib.getBackgroundColor()));
        } else {
            g2.setPaint(NORMAL_GRADIENT_PAINT);
        }
        g2.fillRoundRect(0, 0, d.width, d.height, CORNER_RADIUS, CORNER_RADIUS);

        if (b.getModel().isRollover() || b.getModel().isPressed()) {
            g2.setPaint(SELECTED_BACKGROUND_GRADIENT);
            g2.fillRoundRect(0, 0, d.width, d.height, CORNER_RADIUS, CORNER_RADIUS);
            b.setSelected(true);
        }

        if (b.getModel().isPressed()) {
            b.setBorder(BORDER_LOWERED);
        } else {
            b.setBorder(BORDER_NORMAL);
        }

        //if the button has an icon, it will be painted
        if (b.getIcon() != null) {
            paintIcon(g, c, null);
        }
    }

    /**
     * 
     * @param g the graphics object to be used for painting
     * @param c the specific button the icon is on
     * @param rctngl has no use
     */
    @Override
    protected void paintIcon(Graphics g, JComponent c, Rectangle rctngl) {
        AbstractButton b = (AbstractButton) c;
        ItemButton ib = (ItemButton) b;
        Dimension d = b.getSize();
        Graphics2D g2 = (Graphics2D) g;

        // fill background
        if (ib.getBackgroundColor() != null) {
            g2.setPaint(new GradientPaint(new Point(0, 0), ib.getBackgroundColor().brighter(), new Point(100, 100), ib.getBackgroundColor()));
        } else {
            g2.setPaint(NORMAL_GRADIENT_PAINT);
        }
        g2.fillRoundRect(0, 0, d.width, d.height, CORNER_RADIUS, CORNER_RADIUS);

        if (b.getModel().isRollover() || b.getModel().isPressed()) {
            g2.setPaint(SELECTED_BACKGROUND_GRADIENT);
            g2.fillRoundRect(0, 0, d.width, d.height, CORNER_RADIUS, CORNER_RADIUS);
            b.setSelected(true);
        }

        if (b.getModel().isPressed()) {
            b.setBorder(BORDER_LOWERED);
        } else {
            b.setBorder(BORDER_NORMAL);
        }

        ImageIcon icon = (ImageIcon) b.getIcon();
        g2.drawImage(icon.getImage(), b.getWidth() / 2 - icon.getIconWidth() / 2, b.getHeight() / 2 - icon.getIconHeight() / 2, null);
    }

    /**
     * Paints any text on any button
     * 
     * @param g the graphics object to be used for painting
     * @param b button to have text drawn on
     * @param textRect rectangle surrounding all text
     * @param text specific text to draw
     */
    @Override
    protected void paintText(Graphics g, AbstractButton b, Rectangle textRect, String text) {
        super.paintText(g, b, textRect, text);
    }

    /**
     * Adds UI to the specific button
     */
    @Override
    public void installUI(JComponent c) {
        super.installUI(c);
        AbstractButton b = (AbstractButton) c;
        ItemButton ib = (ItemButton) b;
        b.setBorder(BORDER_NORMAL);
        ib.setBackgroundColor(Color.WHITE);
        b.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        b.addMouseListener(this);
    }

    /**
     * removes UI from the specific button
     */
    @Override
    public void uninstallUI(JComponent c) {
        super.uninstallUI(c);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    /**
     * Sets the border color to specified color when clicked.
     */
    @Override
    public void mousePressed(MouseEvent e) {
        AbstractButton c = (AbstractButton) e.getSource();
        c.setBorder(BORDER_LOWERED);
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
