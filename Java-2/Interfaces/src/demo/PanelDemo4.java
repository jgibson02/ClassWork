package demo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * 
 * @author jhg95693
 */
public class PanelDemo4 {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 73);
        frame.setVisible(true);
        
        JButton leftButton = new JButton("LEFT");
        JButton rightButton = new JButton("RIGHT");
        
        JPanel panel = new JPanel();
        panel.add(leftButton);
        panel.add(rightButton);
        frame.add(panel);
        
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object source = e.getSource();
                if (source == leftButton) {
                    JOptionPane.showMessageDialog(null, "LEFT BUTTON");
                }
                if (source == rightButton) {
                    JOptionPane.showMessageDialog(null, "RIGHT BUTTON");
                }
            }
        };
        leftButton.addActionListener(listener);
        rightButton.addActionListener(listener);
    }

}
