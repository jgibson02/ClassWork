/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Homework1;

import java.util.Scanner;

/**
 *
 * @author John
 */
public class PayBack {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.print("Enter principal: ");
        double principal = in.nextInt();
        
        System.out.print("Enter annual rate of interest: ");
        double rate = in.nextDouble();
        
        System.out.print("Enter period of loan in years: ");
        int period = in.nextInt();
        
        System.out.print("How many times is the interest compounded yearly? ");
        int compoundFreq = in.nextInt();
        
        double result = principal * Math.pow(1 + rate / compoundFreq, compoundFreq * period);
        
        String amount = String.valueOf(result);
        int indexOfDot = amount.indexOf(".");
        amount = amount.substring(0, indexOfDot + 3);
        
        String output = "Total to be repaid: $" + amount;
        System.out.println(output);
    }
}