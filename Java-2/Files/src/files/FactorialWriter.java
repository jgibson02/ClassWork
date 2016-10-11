package files;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigInteger;
import javax.swing.JOptionPane;

/**
 * Prompts the user for a positive integer k and writes the factorial of 1, 2, ..., k to 
 * a text file.
 * 
 * @author John Gibson
 * @version Apr 25, 2016
 */
public class FactorialWriter {
    
    public static void main(String[] args) throws FileNotFoundException {
        String msg = "Enter a positive integer.";
        int n = Integer.parseInt(JOptionPane.showInputDialog(msg));
        
        final String FILE_NAME = "factorial.txt";
        PrintWriter writer = new PrintWriter(FILE_NAME);
        
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            result = result.multiply(new BigInteger(String.valueOf(i)));
            writer.format(i + "! = " + result + "\n");
        }
        
        writer.close();
    }
    
}