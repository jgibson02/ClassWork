package countergame;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * 
 * @author John Gibson
 */
public class CounterGame extends JComponent {
    //integer counters for each button
    static int b1 = 0;
    static int b2 = 0;
    static int b3 = 0;
    
    static JButton button1 = new JButton();
    static JButton button2 = new JButton();
    static JButton button3 = new JButton();
    static Random rand = new Random();
    static boolean gameOver = false;
    static ActionListener B1Listener;
    static ActionListener B2Listener;
    static ActionListener B3Listener;
    
    private static void reverse() {
        int n = rand.nextInt(3);
        if (n == 0) {
            b1--;
            b2++;
            b3++;
        }
        if (n == 1) {
            b1++;
            b2--;
            b3++;
        }
        if (n == 2) {
            b1++;
            b2++;
            b3--;
        }
    }
    
    public static void main(String[] args) {
        
        class B1Listener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                boolean gameOver = false;
                if (!gameOver) {
                    b1++;
                    b2--;
                    b3--;
                    button1.setText(Integer.toString(b1));
                    button2.setText(Integer.toString(b2));
                    button3.setText(Integer.toString(b3));
                    if (b1 == 0 && b2 == 0 && b3 == 0) {
                        gameOver = true;
                    }
                }
                if (gameOver) {
                    button1.setBackground(Color.RED);
                    button2.setBackground(Color.RED);
                    button3.setBackground(Color.RED);
                    button1.removeActionListener(B1Listener);
                    button2.removeActionListener(B2Listener);
                    button3.removeActionListener(B3Listener);
                }
            }
        }
        class B2Listener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!gameOver) {
                    b1--;
                    b2++;
                    b3--;
                    button1.setText(Integer.toString(b1));
                    button2.setText(Integer.toString(b2));
                    button3.setText(Integer.toString(b3));
                    if (b1 == 0 && b2 == 0 && b3 == 0) {
                        gameOver = true;
                    }
                }
                if (gameOver) {
                    button1.setBackground(Color.RED);
                    button2.setBackground(Color.RED);
                    button3.setBackground(Color.RED);
                    button1.removeActionListener(B1Listener);
                    button2.removeActionListener(B2Listener);
                    button3.removeActionListener(B3Listener);
                }
            }
        }
        class B3Listener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean gameOver = false;
                if (!gameOver) {
                    b1--;
                    b2--;
                    b3++;
                    button1.setText(Integer.toString(b1));
                    button2.setText(Integer.toString(b2));
                    button3.setText(Integer.toString(b3));
                    if (b1 == 0 && b2 == 0 && b3 == 0) {
                        gameOver = true;
                    }
                }
                if (gameOver) {
                    button1.setBackground(Color.RED);
                    button2.setBackground(Color.RED);
                    button3.setBackground(Color.RED);
                    button1.removeActionListener(B1Listener);
                    button2.removeActionListener(B2Listener);
                    button3.removeActionListener(B3Listener);
                }
            }
        }
        
        B1Listener = new B1Listener();
        B2Listener = new B2Listener();
        B3Listener = new B3Listener();
        button1.addActionListener(B1Listener);
        button2.addActionListener(B2Listener);
        button3.addActionListener(B3Listener);
        
        // initializes the values for the game to a playable state
        for (int i = 0; i < 10; i++) {
            reverse();
        }
        
        button1.setText(Integer.toString(b1));
        button2.setText(Integer.toString(b2));
        button3.setText(Integer.toString(b3));
        
        Font f = new Font("Monospaced", Font.BOLD, 24);
        button1.setFont(f);
        button2.setFont(f);
        button3.setFont(f);
        
        button1.setFocusable(false);
        button2.setFocusable(false);
        button3.setFocusable(false);
        
        JFrame frame = new JFrame("Counter Game");
        frame.setLayout(new GridLayout(1, 3));
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 100);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}