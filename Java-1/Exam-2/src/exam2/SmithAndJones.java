package exam2;

import java.text.DecimalFormat;
import java.util.Random;

/**
 * This program simulates the following game: Smith rolls a 4 sided die 9 times, and Jones
 * rolls a 6 sided die 6 times, then each person adds up the total of their dice rolls, 
 * and the winner is whoever has the higher total. This program simulates this game for a 
 * set number of times, then reports to the user the average probability of Smith winning.
 *
 * @author John Gibson
 */
public class SmithAndJones {
    public static Random rand = new Random();
    
    public static void main(String[] args) {
        final int TRIALS = 1_000_000;
        int wins = 0;
        
        for (int i = 0; i < TRIALS; i++) {
            if (compareSmithToJones()) {
                wins++;
            }
        }
        
        DecimalFormat decFormat = new DecimalFormat("0.000");
        System.out.println("Probability of Smith winning: " + 
                decFormat.format((100 * (double) wins / TRIALS)) + "%");
    }
    
    /**
     * Simulates the rolling of each person's dice for a set number of times, and adding
     * up each person's respective dice rolls, then comparing the two totals and 
     * determining if Smith's total was greater.
     * 
     * @return the boolean value of whether or not Smith's total was greater.
     */
    private static boolean compareSmithToJones() {
        int smithSum = 0;
        int jonesSum = 0;
        for (int i = 0; i < 9; i++) {
            smithSum += rollSmithDie();
        }
        
        for (int i = 0; i < 6; i++) {
            jonesSum += rollJonesDie();
        }
        
        return smithSum > jonesSum;
    }
    
    /**
     * Simulates the rolling of a four-sided die.
     * @return the integer value of the dice roll
     */
    private static int rollSmithDie() {
        return 1 + rand.nextInt(4);
    }
    
    /**
     * Simulates the rolling of a six-sided die.
     * @return the integer value of the dice roll
     */
    private static int rollJonesDie() {
        return 1 + rand.nextInt(6);
    }
}
