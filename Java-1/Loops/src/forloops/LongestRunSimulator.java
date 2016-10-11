package forloops;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 * If you flip a fair coin n times, what would you expect to be the maximum number of
 * consecutive heads or tails? In other words, what do you expect the longest run to be?
 * 
 * This program simulates the flipping of n coins many times and estimates the expected
 * length of the longest run by averaging the longest runs over all trials of the
 * experiment.
 *
 * @author John Gibson}
 */
public class LongestRunSimulator {

    public static void main(String[] args) {
        
        String input = JOptionPane.showInputDialog("How many coins?");
        int n = Integer.parseInt(input);
        final int TRIALS = 1_000_000;
        
        int max = 0; // The greatest length of a longest run.
        int total = 0; // Total of all lengths of longest runs.
        
        for (int i = 0; i < TRIALS; i++) {
            int k = flipCoins(n);
            total += k;
            if (k > max) {
                max = k;
            }
        }
        
        // average length of all longest runs
        double avg = (double) total / TRIALS;
        
        // calculate the mathematical expectation of the length of the longest run: log_2(n)
        double expectedValue = Math.log(n) / Math.log(2);
        
        String result = n + " coins\n";
        result += "Average length of longest run: " + avg;
        result += "\nActual expected length: " + expectedValue;
        result += "\nGreatest length of a longest run: " + max;
        JOptionPane.showMessageDialog(null, result);
    }
    
    /**
     * Simulates the flipping of a random sequence of coins.
     * @param numCoins the number of coins to flip
     * @return the length of the longest run
     */
    private static int flipCoins(int numCoins) {
        Random rand = new Random();
        int max = 0;
        String str = randomSequence(numCoins);
                
        for (int i = 0; i < numCoins; i++) {
            
            // find length of block starting at position 1
            int length = 1;
            int j = i + 1;
            while (j < numCoins && str.charAt(j) == str.charAt(i)) {
                length++;
                j++;
            }
            if (length > max) {
                max = length;
            }
        }
        return max;
    }
    
    /**
     * Creates a random binary sequence.
     * @param n the length of the sequence
     * @return a random binary sequence of length n
     */
    private static String randomSequence(int n) {
        String s = "";
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            if (rand.nextBoolean()) {
                s += 'H';
            } else {
                s += 'T';
            }
 
        }
        return s;
    }

}
