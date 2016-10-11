
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import javax.swing.JComponent;

/**
 *
 *
 * @author John Gibson
 */
public class DiagonalBar extends JComponent {

    @Override
    public void paintComponent(Graphics g) {
	Graphics2D g2 = (Graphics2D) g;
	g2.addRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));

	// variables
	int w = getWidth();
	int h = getHeight();

	Polygon poly = new Polygon();
	poly.addPoint(0, 0);
	poly.addPoint(w / 5, 0);
	poly.addPoint(w, h - h / 5);
	poly.addPoint(w, h);
	poly.addPoint(w - w / 5, h);
	poly.addPoint(0, h / 5);

	g2.setColor(Color.DARK_GRAY);
	g2.fill(poly);
	g2.setColor(Color.BLACK);
	g2.setStroke(new BasicStroke(5));
	g2.draw(poly);
    }

}
