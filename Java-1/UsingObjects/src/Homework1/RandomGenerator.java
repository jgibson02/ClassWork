/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Homework1;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * The user inputs a seed value and the program outputs a random number based on the seed using the middle-half technique.
 * @author John
 */
public class RandomGenerator {
    public static void main(String[] args) {
        System.out.print("Enter seed: ");
        Scanner in = new Scanner(System.in);
        String seed = in.next();
        
        BigInteger x = new BigInteger(seed);
        BigInteger y = x.pow(2);
        
        //extract middle half of the digits
        String s = y.toString();
        int n = s.length();
        
        System.out.println("Next random number: " + s.substring(n / 4, 3 * n / 4));
    }
}
