package nestedloops;

import java.text.DecimalFormat;

/**
 *
 *
 * @author John Gibson}
 */
public class MultiplicationTable {

    public static void main(String[] args) {
        
        // used to format all numbers as 2-digit numbers
        DecimalFormat f = new DecimalFormat("000");
        
        final int MAX = 20;
        for (int row = 1; row <= MAX; row++) {
            
            for (int col = 1; col <= MAX; col++) {
                int product = row * col;
                System.out.print(f.format(product) + " ");
            }
            System.out.println();
        }
    }

}
