package forloops;

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
        for (int numberToAdd = 1; numberToAdd <= n; numberToAdd++) {
            sum += numberToAdd;
        }
                
        //show the ouptut
        String result = "1 + 2 + 3 + ... + " + n + " = " + sum;
        JOptionPane.showMessageDialog(null, result);
    }

}
