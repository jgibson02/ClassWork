package demo;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * 
 * @author John Gibson
 */
public class BorderLayoutDemo {
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Border Layout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        
        
        JButton[] buttons = new JButton[5];
        
        ActionListener listener = (ActionEvent e) -> {
            for (JButton button : buttons) {
                button.setVisible(e.getSource() != button);
            }
            Toolkit.getDefaultToolkit().beep();
        };
        
        String[] pos = {"North", "East", "South", "West", "Center"};
        for (int i = 0; i < 5; i++) {
            buttons[i] = new JButton(pos[i]);
            frame.add(buttons[i], pos[i]);
        }
        Toolkit.getDefaultToolkit().beep();
        
        frame.setVisible(true);
    }
}
