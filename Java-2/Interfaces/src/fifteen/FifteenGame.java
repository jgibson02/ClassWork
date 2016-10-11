package fifteen;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author John Gibson
 */
public class FifteenGame extends JComponent {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Game of Fifteen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final Fifteen game = new Fifteen();
        frame.setLayout(new GridLayout(4, 4));
        
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }
        
        JButton[][] buttons = new JButton[4][4];
        
        class ButtonListener implements ActionListener {
            private final int ROW;
            private final int COL;
            
            public ButtonListener(int row, int col) {
                this.ROW = row;
                this.COL = col;
            }
            
            /**
             * Slide the selected tile and update the button text.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if (game.slide(ROW, COL)) {
                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < 4; j++) {
                            buttons[i][j].setText(game.toString(i, j));
                        }
                    }
                    if (game.over()) {
                        JOptionPane.showMessageDialog(frame, "YOU WIN!", "FIFTEENS", 
                                JOptionPane.INFORMATION_MESSAGE, 
                                new ImageIcon("congratulations.gif"));
                    }
                } else {
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        }
        // Creates the buttons
        Color buttonBackground = Color.CYAN;
        Color buttonForeground = Color.WHITE;
        Font font = new Font("Segoe UI", Font.BOLD, 30);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                buttons[i][j] = new JButton(game.toString(i, j));
                buttons[i][j].setFocusable(false);
                buttons[i][j].setBackground(buttonBackground);
                buttons[i][j].setForeground(buttonForeground);
                buttons[i][j].setFont(font);
                buttons[i][j].addActionListener(new ButtonListener(i, j));
                frame.add(buttons[i][j]);
            }
        }
        
        // add a menu bar with an ABOUT menu
        JMenuBar mBar = new JMenuBar();
        JMenu menu = new JMenu("About");
        JMenuItem menuItem = new JMenuItem("How to Win");
        frame.setJMenuBar(mBar);
        mBar.add(menu);
        menu.add(menuItem);
        
        menuItem.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               String msg = "The winning configuration";
               String title = "Game of Fifteen";
               ImageIcon icon = new ImageIcon("puzzle15.png");
               JOptionPane.showMessageDialog(frame, msg, title, JOptionPane.INFORMATION_MESSAGE, icon);
           }
        });
        
        frame.setSize(500, 500);
        //frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
    
    @Override
    public void reshape(int x, int y, int width, int height) {
        int currentWidth = getWidth();
        int currentHeight = getHeight();
        if (currentWidth!=width || currentHeight!=height) {
            // find out which one has changed
            if (currentWidth!=width && currentHeight!=height) {  
                // both changed, set size to max
                width = height = Math.max(width, height);
            }
            else if (currentWidth==width) {
                  // height changed, make width the same
                width = height;
            }
            else // currentHeight==height
                height = width;
        }
        super.reshape(x, y, width, height);
    }
}