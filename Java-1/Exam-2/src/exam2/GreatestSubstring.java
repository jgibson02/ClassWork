package exam2;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 *
 * @author John Gibson}
 */
public class GreatestSubstring {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string of digits and an integer: ");
        BigInteger digitString = sc.nextBigInteger();
        String s1 = digitString.toString();
        int k = sc.nextInt();
        int length = s1.length();
        int greatestSubstring = 0;
        
        for (int i = 0; i < length - (k - 1); i++) {
            int block = Integer.parseInt(s1.substring(i, i + k));
            if (block > greatestSubstring) {
                greatestSubstring = block;
            }
        }
        
        System.out.println("Greatest " + k + "-digit substring: " + greatestSubstring);
    }

}
