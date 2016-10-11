/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice1;

import java.util.Scanner;

/**
 *
 * @author jhg95693
 */
public class DataEntry {
    static int numDoris = 0;
    static int numBoris = 0;
    static int numDataSets;
    static int numDataSetsScanned = 0;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        numDataSets = sc.nextInt();
        int n = sc.nextInt();
        if (n == 1 || n == 2 || n == 3) {
            numDoris = numDoris + n;
            for (int i = 0; i < n; i++) {
                sc.next();
            }
        } else {
            if (n != 0) {
                numBoris++;
                sc.next();
            }
        }
        System.out.println("Doris: " + numDoris);
        System.out.println("Boris: " + numBoris);
    }
}
