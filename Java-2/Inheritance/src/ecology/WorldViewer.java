package ecology;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 * 
 * @author John Gibson
 * @version Mar 23, 2016
 */
public class WorldViewer extends JComponent {
    
    private World world;
    private final int SIZE;
    private final Timer timer;
    
    private static final Color PREY_COLOR = Color.MAGENTA;
    private static final Color PREDATOR_COLOR = Color.YELLOW;
    private static final Color EMPTY_COLOR = Color.BLACK;
    
    private static final double INIT_PRED_DENSITY = 0.03;
    private static final double INIT_PREY_DENSITY = 0.05;
    private static final double INIT_JOEY_DENSITY = 0.02;
    
    private static final int UPDATE_DELAY = 200;
    
    private static final boolean CELL_BORDERS_ON = true;
    private static final Color CELL_BORDER_COLOR = Color.LIGHT_GRAY;
    
    private static final ImageIcon ross = new ImageIcon(
            WorldViewer.class.getResource("/images/ross.png"));
    private static final ImageIcon rachel = new ImageIcon(
            WorldViewer.class.getResource("/images/rachel.png"));
    private static final ImageIcon joey = new ImageIcon(
            WorldViewer.class.getResource("/images/joey.png"));
    
    public WorldViewer(int n) {
        world = new World(n, INIT_PRED_DENSITY, INIT_PREY_DENSITY);
        SIZE = n;
        timer = new Timer(UPDATE_DELAY, (ActionEvent e) -> {
            world.tick();
            repaint();            
        });
        timer.start();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.addRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, 
                RenderingHints.VALUE_ANTIALIAS_ON));
        final int PADDING = 5;
        final int CELL_SIZE = (getWidth() - 2 * PADDING) / SIZE;
        
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                // get pixel position of top-left corner of cell (i, j)
                int x = PADDING + j * CELL_SIZE;
                int y = PADDING + i * CELL_SIZE;
                Rectangle cell = new Rectangle(x, y, CELL_SIZE, CELL_SIZE);
                
                // choose color based on type of creature
                Creature creature = world.get(i, j);
                Class type = (creature == null ? null : creature.getClass());
                
                g2.setColor(EMPTY_COLOR);
                if (type == Predator.class) {
                    g2.setColor(PREDATOR_COLOR);
                    g2.drawImage(ross.getImage(), cell.x, cell.y, cell.width, cell.height, null);
                }
                if (type == Prey.class) {
                    g2.setColor(PREY_COLOR);
                    g2.drawImage(rachel.getImage(), cell.x, cell.y, cell.width, cell.height, null);
                }
                
                
                if (CELL_BORDERS_ON) {
                    g2.setColor(CELL_BORDER_COLOR);
                    g2.draw(cell);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Predator-Prey Simulation");
        String prompt = "Enter grid size";
        int size = Integer.parseInt(JOptionPane.showInputDialog(prompt));
        frame.add(new WorldViewer(size));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setVisible(true);
        frame.setAlwaysOnTop(false);
        frame.setMinimumSize(new Dimension(200, 200));
    }
    
}