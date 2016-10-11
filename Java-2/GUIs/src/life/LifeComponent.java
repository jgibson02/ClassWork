package life;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;

/**
 * 
 * @author John Gibson
 * @version Apr 18, 2016
 */
public class LifeComponent extends JComponent {
    
    private final GameOfLife game;
    private final int SIZE;
    
    // fields for continuous updating
    private boolean autoUpdate;
    private int delay; // milliseconds between updates
    public static final int SLOW = 500;
    public static final int MEDIUM = 250;
    public static final int FAST = 15;
    
    // fields for drawing
    private static final int LINE_THICKNESS = 1;
    private static final int OFFSET = 15;
    private static final Color BG_COLOR = Color.BLACK;
    private static final Color LIVING_COLOR = Color.CYAN;
    private static final Color LINE_COLOR = Color.GRAY;
    private int cellWidth;
    private int cellHeight;
    
    public LifeComponent(int size) {
        SIZE = size;
        game = new GameOfLife(SIZE);
        delay = MEDIUM;
        initMouseEventHandlers();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        int w = getWidth();
        int h = getHeight();
        g2.setColor(BG_COLOR);
        g2.fill(new Rectangle(w, h));
        
        // draw grid
        g2.setStroke(new BasicStroke(LINE_THICKNESS));
        cellWidth =  (w - 2 * OFFSET) / SIZE;
        cellHeight = (h - 2 * OFFSET) / SIZE;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                // find position of top-left corner of cell (i, j)
                int x = OFFSET + i * cellWidth;
                int y = OFFSET + j * cellHeight;
                if (game.isAlive(i, j)) {
                    g2.setColor(LIVING_COLOR);
                } else {
                    g2.setColor(BG_COLOR);
                }
                g2.fillRect(x, y, cellWidth, cellHeight);
                g2.setColor(LINE_COLOR);
                g2.drawRect(x, y, cellWidth, cellHeight);
            }
        }
        
        if (autoUpdate) {            
            try {
                game.nextGeneration();
                Thread.sleep(delay);
                repaint();
            } catch (InterruptedException ex) {
                Logger.getLogger(LifeComponent.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
    }
    
    private void initMouseEventHandlers() {
        
        MouseAdapter listener = new MouseAdapter() {
            
            private boolean turnOnWhenDragging = false;
            
            // find row and column of cell containing the cursor
            private Point getCellContainingCursor(Point cursor) {
                for (int i = 0; i < SIZE; i++) {
                    for (int j = 0; j < SIZE; j++) {
                        
                        // find top-left corner of cell (i, j)
                        int x = OFFSET + i * cellWidth;
                        int y = OFFSET + j * cellHeight;
                        if (new Rectangle(x, y, cellWidth, cellHeight).contains(cursor)) {
                            return new Point(i, j);
                        }                        
                    }
                }
                return null;
            }
            
            @Override
            public void mousePressed(MouseEvent e) {
                Point currentPoint = e.getPoint();
                Point p = getCellContainingCursor(currentPoint);
                if (p == null) {
                    return;
                }
                
                // The state of this cell gets toggled, and other cells through which the
                // mouse is dragged have their states changed to that of this cell.
                int i = (int) p.getX();
                int j = (int) p.getY();
                turnOnWhenDragging = !game.isAlive(i, j);
                game.toggle(i, j);
                autoUpdate = false;
                repaint();
            }
            
            /**
             * Mask cell states. 
             */
            @Override
            public void mouseDragged(MouseEvent e) {
                Point currentPoint = e.getPoint();
                Point p = getCellContainingCursor(currentPoint);
                if (p == null) {
                    return;
                }
                
                // The state of this cell gets toggled, and other cells through which the
                // mouse is dragged have their states changed to that of this cell.
                int i = (int) p.getX();
                int j = (int) p.getY();
                
                if (turnOnWhenDragging) {
                    game.setLiving(i, j);
                } else {
                    game.setDead(i, j);
                }
                
                autoUpdate = false;
                repaint();
            }
            
        };
        addMouseListener(listener);
        addMouseMotionListener(listener);
    }
    
    /**
     * Populates the world with life at random. Each cell will be alive with probability
     * d.
     * @param d 
     */
    public void randomize(double d) {
        game.randomize(d);
        repaint();
    }
    
    /**
     * Goes into continuous update mode.
     */
    public void run() {
        autoUpdate = true;
        game.nextGeneration();
        repaint();
    }

    /**
     * Updates to the next generation.
     */
    public void step() {
        game.nextGeneration();
        autoUpdate = false;
        repaint();
    }

    /**
     * Stops continuously updating generations.
     */
    public void stop() {
        autoUpdate = false;
    }
    
    /**
     * Destroys all life.
     */
    public void clear() {
        randomize(0);
    }
    
    public void setDelay(int delay) {
        this.delay = delay;
    }
    
    /**
     * Toggles the state of a cell.
     *
     * @param u the row of the cell
     * @param v the column of the cell
     */
    public void toggle(int u, int v) {
        this.game.toggle(u, v);
        repaint();
    }
}