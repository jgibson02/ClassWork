package memorygame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;

/**
 * This class presents a main menu for the user to select how often the game will
 * check for a pair of matching cards, and will store the shortest amount of time
 * that it took the user to beat the game in the current execution.
 * 
 * @author John Gibson
 */
public class MemoryGameGUI {

    static int delay = 500;
    static double bestTime;
    
    /**
     * 
     * @param n 
     */
    public static void setDelay(int n) {
        delay = n;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Main Menu");
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        
        JLabel instructions = new JLabel("Please select the delay for flipping tiles.");
        instructions.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        
        JSlider delaySlider = new JSlider(100, 1000, 500);
        delaySlider.setPaintLabels(true);
        delaySlider.setPaintTicks(true);
        delaySlider.setMajorTickSpacing(100);
        delaySlider.setAlignmentX(JSlider.CENTER_ALIGNMENT);
        
        JButton startGame = new JButton("Start Game");
        startGame.setAlignmentX(JButton.CENTER_ALIGNMENT);
        
        frame.add(instructions);
        frame.add(delaySlider);
        frame.add(startGame);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setSize(400, 150);
        
        startGame.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent ae) {
                setDelay(delaySlider.getValue());
                MemoryGame mg = new MemoryGame(delay);
            }
            
        });
    }

}