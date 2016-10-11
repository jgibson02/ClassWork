package onedim;

import java.util.Random;

/**
 * This program simulates multiple rolls of a die and outputs the numbers of 1's, 2's, etc.
 * 
 * @author John Gibson}
 */
public class DiceRoller {

    public static void main(String[] args) {
        Random rand = new Random();
        
        int[] rolls = new int[7];
        final int NUM_ROLLS = 1_000_000;
        
        for (int i = 0; i < NUM_ROLLS; i++) {
            int n = 1 + rand.nextInt(6);
            rolls[n]++;
        }
        
        int greatestNumber = 0;
        int lowestNumber = 1_000_000;
        for (int i = 0; i < 7; i++) {
            if (rolls[i] > greatestNumber) {
                greatestNumber = rolls[i];
            }
            if (rolls[i] < lowestNumber) {
                lowestNumber = rolls[i];
            }
        }
        
        int range = greatestNumber - lowestNumber;
        for (int i = 1; i <= 6; i++) {
            System.out.println(i + "'s: " + rolls[i]);
        }
        System.out.println("Range: " + range);
    }

}
