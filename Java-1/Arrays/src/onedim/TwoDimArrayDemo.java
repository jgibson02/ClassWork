package onedim;

import java.text.DecimalFormat;
import java.util.Random;

/**
 * Quick introduction to multi-dimensional arrays.
 * 
 * @author John Gibson
 */
public class TwoDimArrayDemo {

    public static void main(String[] args) {
        // fill a 5x7 array with random numbers formatted as strings
        DecimalFormat f = new DecimalFormat("0.000");
        final int ARRAY_ROWS = 1500;
        final int ARRAY_COLS = 2000;
        String[][] b = new String[ARRAY_ROWS][ARRAY_COLS];
        for (int i = 0; i < ARRAY_ROWS; i++) {
            for (int j = 0; j < ARRAY_COLS; j++) {
                b[i][j] = f.format(Math.random());
            }
        }
        
        // fill an array with 
        String[][] b2 = new String[ARRAY_ROWS][ARRAY_COLS];
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*()_+-=";
        Random rand = new Random();
        for (int i = 0; i < ARRAY_ROWS; i++) {
            for (int j = 0; j < ARRAY_COLS; j++) {
                int k = rand.nextInt(36);
                b2[i][j] = letters.substring(k, k + 3);
            }
        }
        print(b2);
        System.out.println();        
        print(b);
        
        // initialize a 3x3 array in its declaration
        int[][] z = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        for (int[] row: z) {
            for (int s : row) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
    
    /**
     * Displays a table of strings.
     * @param a a two-dimensional array
     */
    private static void print(String[][] a) {
        // display contents of array
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

}
