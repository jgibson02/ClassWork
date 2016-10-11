/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package whileloops;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author John Gibson
 */
public class GamblersRuin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int balance = Integer.parseInt(JOptionPane.showInputDialog("How many dollars does"
                + " the gambler have?"));
        Random rand = new Random();
        int tossCount = 0;
        int maxBalance = balance;
        
        while (balance > 0) {
            if (rand.nextBoolean()) {
                balance++;
            } else {
                balance--;
            }
            tossCount++;
            
            if (balance > maxBalance) {
                maxBalance = balance;
            }
        }
        JOptionPane.showMessageDialog(null, "The gambler went broke after " + tossCount + 
                " coin flips.\nHis maximum balance was $" + maxBalance + ".");
    }

}
