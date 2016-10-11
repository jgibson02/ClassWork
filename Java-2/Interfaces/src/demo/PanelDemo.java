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
public class PanelDemo {

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
        
        class Listener implements ActionListener {
            
            private String msg;
            
            public Listener(String msg) {
                this.msg = msg;
            }
            
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, msg);
            }
        }
        leftButton.addActionListener(new Listener("LEFT BUTTON"));
        rightButton.addActionListener(new Listener("RIGHT BUTTON"));
    }

}
