/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.pkg3;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author jhg95693
 */
public class Problem4
{
    public static void main(String args[]) {
        String[] a = {"99", "9", "978", "7", "8", "999"};
        Arrays.sort(a, new intSort());
        for (String i : a) {
            System.out.print(i);
        }
    }
}

class intSort implements Comparator<String> {

    @Override
    public int compare(String o1, String o2)
    {
        return (o2 + o1).compareTo(o1 + o2);
    }
    
}
