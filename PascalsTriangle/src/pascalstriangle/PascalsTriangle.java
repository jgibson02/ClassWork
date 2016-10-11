package pascalstriangle;

import java.math.BigInteger;

/**
 *
 * @author John Gibson
 */
public class PascalsTriangle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n = 100;
        
        for (int i = 0; i < n; i++) {
            BigInteger coefficient = BigInteger.ONE;
            for (int k = 0; k <= i; k++) {
                System.out.print(coefficient + " ");
                coefficient = coefficient.multiply(BigInteger.valueOf((i - k) / (k + 1)));
            }
            System.out.println();
        }
    }
}