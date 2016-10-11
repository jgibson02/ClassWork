package nestedloops;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *
 *
 * @author John Gibson}
 */
public class ChessBoard extends JComponent {
    
    /**
     * Draws the board.
     * @param g the graphics context
     */
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        
        // distance from edge of board to edge of window
        final int OFFSET = 20;
        
        final int SIZE = 8; // number of rows/cols
        int w = getWidth();
        int h = getHeight();
        int squareSize = (Math.min(w, h) - 2 * OFFSET) / SIZE;
        
        g2.setColor(new Color(191, 98, 0));
        Rectangle bg = new Rectangle(0, 0, w, h);
        g2.fill(bg);
        
        final Color borderColor = new Color(80, 80, 80);
        
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                
                // find top-left corner of square (i, j)
                int x = OFFSET + i * squareSize;
                int y = OFFSET + j * squareSize;
                Rectangle square = new Rectangle(x, y, squareSize, squareSize);
                
                // set the color for this square
                Color tan = new Color(232, 200, 115);
                Color brown = new Color(87, 23, 0);
                if ((i + j) % 2 == 0) {
                    g2.setColor(brown);
                } else {
                    g2.setColor(tan);
                }
                
                // draw border around square
                g2.fill(square);
                g2.setColor(borderColor);
                g2.setStroke(new BasicStroke(3));
                g2.draw(square);
            }
        }
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(900, 900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new ChessBoard());
        frame.setVisible(true);
        frame.setResizable(true);
        frame.setAlwaysOnTop(true);
    }

}
