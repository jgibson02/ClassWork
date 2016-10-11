/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package whileloops;

import javax.swing.JOptionPane;

/**
 * Adds up the number from 1 to n, where n is chosen by the user.
 * 
 * @author John Gibson
 */
public class Summer {

    public static void main(String[] args) {
        //prompt user for input
        String input = JOptionPane.showInputDialog("Enter the top bound.");
        int n = Integer.parseInt(input);
        
        //perform the additions
        int sum = 0;
        int numberToAdd = 1;
        while (numberToAdd <= n) {
            sum += numberToAdd;
            numberToAdd++;
        }
        
        //show the ouptut
        String result = "1 + 2 + 3 + ... + " + n + " = " + sum;
        JOptionPane.showMessageDialog(null, result);
    }

}
