package demo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 * Outputs a countdown with a one-second delay between consecutive numbers.
 * 
 * @author jhg95693
 */
public class Countdown {

    public static void main(String[] args) {
        class TimerListener implements ActionListener {
            
            private int count = 10;
            
            public TimerListener(int count) {
                this.count = count;
            }
            
            @Override
            public void actionPerformed(ActionEvent e) {
                if (count > 0) {
                    System.out.println(count);
                }
                if (count == 0) {
                    System.out.println("Blast off.");
                }
                count--;
            }
        }
        
        TimerListener listener = new TimerListener(12);
        final int DELAY = 1000;
        Timer t = new Timer(DELAY, listener);
        t.start();
        
        JOptionPane.showMessageDialog(null, "Quit?");
        System.exit(0);
    }

}
