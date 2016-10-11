package fifteen;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 * This class displays a game of Fifteens using a GUI with a selectable dropdown
 * list of possible moves to make.
 * 
 * @author jhg95693
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Fifteen puzzle = new Fifteen();
        final int FONT_SIZE = 24;
        Font gameFont = new Font(Font.MONOSPACED, Font.BOLD, FONT_SIZE);
        Font goodbyeFont = new Font(Font.SANS_SERIF, Font.BOLD, FONT_SIZE);
        UIManager.put("OptionPane.messageFont", gameFont);
        String title = "SELECT TILE TO SLIDE";
        String userInput = null;

        while (!puzzle.over()) {
            userInput = (String) JOptionPane.showInputDialog(null, puzzle, title,
                    JOptionPane.PLAIN_MESSAGE, null, puzzle.choices(), "1");

            if (userInput == null) {
                break;
            }
            puzzle.slide(Integer.parseInt(userInput));
        }

        UIManager.put("OptionPane.messageFont", goodbyeFont);
        ImageIcon hughLaurie = new ImageIcon("Hugh Laurie.jpg");
        ImageIcon congratulations = new ImageIcon("congratulations.gif");
        if (userInput == null) {
            JOptionPane.showMessageDialog(null, ">mfw Americans lose Fifteens", "Lost", JOptionPane.INFORMATION_MESSAGE, hughLaurie);
        } else {
            JOptionPane.showMessageDialog(null, "You did it!", "Won", JOptionPane.INFORMATION_MESSAGE, congratulations);
        }
    }
}
