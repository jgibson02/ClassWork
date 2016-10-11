package randomtextgenerator;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigInteger;
import javax.swing.JOptionPane;

/**
 *
 * @author Maximillian Pegasus
 */
public class RandomTextGenerator {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        System.out.print("Enter a 4 digit integer: ");
        String seedString = JOptionPane.showInputDialog("Enter a 4 digit integer");
        BigInteger seed = new BigInteger(seedString);
        BigInteger seedToTenthPower = seed.pow(100000);
        String output = seedToTenthPower.toString(29);
        String s1 = output.replace("0", "t");
        String s2 = s1.replace("1", "u");
        String s3 = s2.replace("2", "v");
        String s4 = s3.replace("3", "w");
        String s5 = s4.replace("4", "x");
        String s6 = s5.replace("5", "y");
        String s7 = s6.replace("6", "z");
        String s8 = s7.replace("7", " ");
        String s9 = s8.replace("8", ",");
        String s10 = s9.replace("9", ".");
        
        PrintWriter out = new PrintWriter("Seed Output.txt");
        out.print(s10);
    }
}
