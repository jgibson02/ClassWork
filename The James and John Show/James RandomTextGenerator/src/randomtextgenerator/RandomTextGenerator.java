/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randomtextgenerator;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author John
 */
public class RandomTextGenerator {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a 4 digit integer: ");
        String seedString = JOptionPane.showInputDialog("Enter a 4 digit integer");
        BigInteger seed = new BigInteger(seedString);
        BigInteger seedToTenthPower = seed.pow(100000);
        String seedToTenthPowerString = seedToTenthPower.toString(30);
        String s1 = seedToTenthPowerString.
        
        PrintWriter out = new PrintWriter("Seed Output.txt");
        out.println(seedToTenthPowerString);
    }
    
}
