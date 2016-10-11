package demo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Suppose a spaceship races away from the earth at constant velocity v for a given time t.
 * Einstein's special theory of relativity tells how much time u will have passed on Earth:
 * 
 * t^2/u^2 = 1 - (v^2/c^2);
 * 
 * This program prompts the user to enter the travel time and the speed (as a fraction of
 * light speed) and displays the time elapsed on Earth.
 * 
 * @author John Gibson
 */
public class TimeDilator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Time Dilation Calculator");
        JButton button = new JButton("Calculate Elapsed Time on Earth");
        final int FIELD_WIDTH = 5;
        JTextField vField = new JTextField(FIELD_WIDTH);
        JTextField tField = new JTextField(FIELD_WIDTH);
        JLabel vLabel = new JLabel("Velocity (fraction of light speed)");
        JLabel tLabel = new JLabel("Travel time (years)");
        JLabel eLabel = new JLabel(); // elapsed time on Earth
        
        JPanel panel = new JPanel();
        panel.add(vLabel);
        panel.add(vField);
        panel.add(tLabel);
        panel.add(tField);
        panel.add(button);
        panel.add(eLabel);
        
        frame.add(panel);
        frame.setSize(300, 140);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
        
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double v = Double.parseDouble(vField.getText());
                double t = Double.parseDouble(tField.getText());
                
                if (v >= 0 && v < 1) {
                    // calculate time elapsed on earth
                    double elapsedTime = t / Math.sqrt(1 - v * v);
                    DecimalFormat f = new DecimalFormat(".0");
                    eLabel.setText(f.format(elapsedTime) + " years");
                } else {
                    String msg = "Velocity must be expressed as\n"
                            + "a fraction of light speed. Enter\n"
                            + "number between 0 and 1.";
                            JOptionPane.showMessageDialog(null, msg);
                }   
            }
        };
        button.addActionListener(listener);
    }

}