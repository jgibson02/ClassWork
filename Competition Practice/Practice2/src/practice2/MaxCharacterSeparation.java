/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice2;

import java.util.Scanner;

/**
 *
 * @author jhg95693
 */
public class MaxCharacterSeparation {
    
    public static void main(String[] args) {
        int maxSep = 0;
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String input = sc.next();
        
        for (int i = 0; i < input.length(); i++) {
            for (int j = input.length() - 1; j >= 0; j--) {
                if (input.charAt(i) == input.charAt(j)) {
                    int sep = j - i;
                    if (sep > maxSep) {
                        maxSep = sep;
                    }
                }
            }
        }
        
        
        System.out.println(maxSep);
    }
    
}
