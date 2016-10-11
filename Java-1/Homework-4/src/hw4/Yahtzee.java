package hw4;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;

/**
 * This program simulates the rolling of five dice and determining the probability of each
 * of the various outcomeNames of the game Yahtzee by repeating the simulation 10 million
 * times and calculating the average probability.
 * 
 * @author John Gibson
 */
public class Yahtzee {

    public static final int TRIAL_COUNT = 10_000_000;
    
    public static void main(String[] args) {
        DecimalFormat dFormat = new DecimalFormat("0.00");
        String[] outcomeNames = {"yahtzee", "four of a kind", "large straight", "full house", 
            "small straight", "three of a kind"};
        
        // simulate game 10 million times and count each outcome
        int[] outcomeCounts = new int[6];        
        for (int i = 0; i < TRIAL_COUNT; i++) {
            int[] dice = rollDice();
            Arrays.sort(dice);
            
            if (isYahtzee(dice)) {
                outcomeCounts[0]++;
            }
            if (isFourOfAKind(dice)) {
                outcomeCounts[1]++;
            }
            if (isLargeStraight(dice)) {
                outcomeCounts[2]++;
            }
            if (isFullHouse(dice)) {
                outcomeCounts[3]++;
            }
            if (isSmallStraight(dice)) {
                outcomeCounts[4]++;
            }
            if (isThreeOfAKind(dice)) {
                outcomeCounts[5]++;
            }
            
        }
        
        // Get the probabilities and print them
        for (int k = 0; k < 6; k++) {
            System.out.println("Probability of " + outcomeNames[k] + ": " + 
                dFormat.format(getProbability(outcomeCounts[k])) + "%");
        }
    }
    
    /**
     * This method constructs an int[] array containing five pseudo-random values ranging
     * from 1 to 6.
     * @return an int[] array containing five pseudo-random values ranging from 1 to 6 
     */
    private static int[] rollDice() {
        int[] dice = new int[5];
        Random rand = new Random();
        for (int i = 0; i < 5; i++) {
            dice[i] = 1 + rand.nextInt(6);
        }
        return dice;
    }    
    
    /**
     * This method calculates the percentages of times an outcome occurred out of all
     * trials.
     * @param outcomeCount an integer value pulled from the dice[] array
     * @return 
     */
    private static double getProbability(int outcomeCount) {
        return ((double) outcomeCount / TRIAL_COUNT) * 100;
    }
    
    /**
     * This method determines whether or not a bubble-sorted int[] array contains five of 
     * the same value.
     * @param dice the array of 5 rolled six-sided dice values after being bubble sorted
     * @return a boolean value representing whether the 5 dice contain a full house
     */
    private static boolean isYahtzee(int[] dice) {
        return dice[0] == dice[4]; //if the first and last are equal, it should be Yahtzee
    }
    
    /**
     * This method determines whether or not a bubble-sorted int[] array contains at least
     * four of the same value.
     * @param dice the array of 5 rolled six-sided dice values after being bubble sorted
     * @return a boolean value representing whether the 5 dice contain a four-of-a-kind
     */
    private static boolean isFourOfAKind(int[] dice) {
        for (int i = 0; i < 2; i++) {
            if (dice[i] == dice[i + 3]) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * This method determines whether or not an int[] array of five bubble sorted dice
     * contains five consecutive values between 1 to 6.
     * @param dice the array of 5 rolled six-sided dice values after being bubble sorted
     * @return a boolean value representing whether the 5 dice contains a large straight
     */
    private static boolean isLargeStraight(int[] dice) {
        int n = 1;
        for (int i = 1; i < 5; i++) {
            if (dice[i - 1] + 1 == dice[i]) {
                n++;
            }
        }
        return n >= 5;
    }
    
    /**
     * This method looks to see if there is both a pair of two identical dice rolls and a 
     * set of three identical dice rolls.
     * @param dice the array of 5 rolled six-sided dice values after being bubble sorted
     * @return a boolean value representing whether the 5 dice contain a full house
     */
    private static boolean isFullHouse(int[] dice) {
        int[] count = new int[6];
        boolean hasTwoOfAKind = false;
        boolean hasThreeOfAKind = false;
        for (int i = 0; i < 5; i++) {
            count[dice[i] - 1]++;
        }
        for (int i : count) {
            hasTwoOfAKind |= (i == 2);
            hasThreeOfAKind |= (i == 3);
        }
        return (hasTwoOfAKind && hasThreeOfAKind);
    }
    
    /**
     * This method determines whether or not an int[] array of five bubble sorted dice
     * contains four consecutive values between 1 to 6.
     * @param dice the array of 5 rolled six-sided dice values after being bubble sorted
     * @return a boolean value representing whether the 5 dice contains a small straight
     */
    private static boolean isSmallStraight(int[] dice) {
        int n = 1;
        for (int i = 1; i < 5; i++) {
            if (dice[i - 1] + 1 == dice[i]) {
                n++;
            }
        }
        return n >= 4;
    }
    
    /**
     * This method determines whether a bubble-sorted int[] array contains at least 3 of
     * the same value.
     * @param dice the array of 5 rolled six-sided dice values after being bubble sorted
     * @return a boolean value representing whether the 5 dice contain a three-of-a-kind
     */
    private static boolean isThreeOfAKind(int[] dice) {
        for (int i = 0; i < 3; i++) {
            if (dice[i] == dice[i + 2]) {
                return true;
            }
        }
        return false;
    }
    
}