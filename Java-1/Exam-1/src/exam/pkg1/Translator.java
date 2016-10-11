/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam.pkg1;

import java.util.Scanner;

/**
 *
 * @author John
 */
public class Translator {
    public static void main(String[] args) {
        System.out.print("Enter expression of the form x^y");
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        
        int i = input.indexOf("^");
        String base = input.substring(0, i);
        String exp = input.substring(i + 1);
        System.out.println(base + " multiplied by iteself " + exp + " times");
    }
}
