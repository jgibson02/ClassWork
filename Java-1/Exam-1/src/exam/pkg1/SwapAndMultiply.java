/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam.pkg1;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 
 * @author John
 */
public class SwapAndMultiply {
    public static void main(String[] args) {
        System.out.print("Enter an integer with an even number of digits: ");
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        
        int n = s.length();
        String t = s.substring(n/2) + s.substring(0, n/2);
        
        BigInteger x = new BigInteger(s);
        BigInteger y = new BigInteger(t);
        BigInteger z = x.multiply(y);
        String product = z.toString();
        
        System.out.println(x);
        System.out.println(y);
        System.out.println(product.substring(0, n));
    }
}
