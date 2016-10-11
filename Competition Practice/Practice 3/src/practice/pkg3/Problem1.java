/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.pkg3;

import java.util.Arrays;

/**
 *
 * @author jhg95693
 */
public class Problem1
{    
    public static void main(String[] args) {
        int[] ints = {5, 18, 2, 4};
        System.out.println(forSum(ints));
        //System.out.println(whileSum(ints));
        System.out.println(recursiveSum(ints));
    }
    
    public static int forSum(int[] ints) {
        int sum = 0;
        for (int i : ints) {
            sum += i;
        }
        return sum;
    }
    
    public static int whileSum(int[] ints) {
        int sum = 0;
        int i = 0;
        while (ints[i] != 0) {
            sum += ints[i];
            i++;
        }
        return 0;
    }
    
    public static int recursiveSum(int[] ints) {
        return ((ints.length > 1) ? ints[0] + recursiveSum(Arrays.copyOfRange(ints, 1, ints.length)) : ints[0]);
    }
}
