/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decisions;

import java.util.Scanner;

/**
 * One rectangle can be nested inside another (with sides parallel) if its
 * dimensions are strictly less than the dimensions of the outside rectangle.
 * This program reads the dimensions of the two rectangles and tells if one can
 * be nested inside another.
 * 
 * @author John
 */
public class NestedRectangles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter dimensions of first rectangle: ");
        int w1 = sc.nextInt();
        int h1 = sc.nextInt();
        
        System.out.print("Enter dimensions of second rectangle: ");
        int w2 = sc.nextInt();
        int h2 = sc.nextInt();
        
        //swap if necessary so w1 < h1
        if (w1 > h1) {
            int temp = w1;
            w1 = h1;
            h1 = temp;
        }
        
        String s1 = "The first rectangle can be nested in the second rectangle.";
        String s2 = "The second rectangle can be nested in the first rectangle.";
        String s3 = "Neither rectangle can be nested in the other.";
        
        if (w1 < w2 && h1 < h2) {
            System.out.println(s1); // block 1
        } else if (w2 < w1 && h2 < h1) {
            System.out.println(s2); // block 2
        } else {
            System.out.println(s3); // block 3
        }
    }
}