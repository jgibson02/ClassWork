package homework3;

import java.text.DecimalFormat;
import java.util.Random;

/**
 * This program simulates two dice-based events and finds the average probability of a
 * particular outcome for each event to be true.
 * @author John Gibson
 */
public class DiceGames {
    
    public static void main(String[] args) {
        final int NUM_TRIALS = 1_000_000;
        int oneSixWins = 0;
        int doubleSixWins = 0;
        for (int i = 0; i < NUM_TRIALS; i++) {
            if (oneSix()) {
                oneSixWins++;
            }
            if (doubleSix()) {
                doubleSixWins++;
            }
        }
        DecimalFormat format = new DecimalFormat("0.00");
        double event1Probability = ((double) oneSixWins / NUM_TRIALS) * 100;
        double event2Probability = ((double) doubleSixWins / NUM_TRIALS) * 100;
        System.out.println("Probability of winning for event 1: " + 
                format.format(event1Probability) + "%");
        System.out.println("Probability of winning for event 2: " + 
                format.format(event2Probability) + "%");
    }
    
    /**
     * Simulates the tossing of a 6-sided die.
     * @return the value of a random die toss
     */
    public static int dieToss() {
        Random rand = new Random();
        return 1 + rand.nextInt(6);
    }
    
    /**
     * Simulates the tossing of 4 dice and seeing if any are a 6.
     * @return whether or not any of the 4 dice landed a 6
     */
    private static boolean oneSix() {
        int die1 = dieToss();
        int die2 = dieToss();
        int die3 = dieToss();
        int die4 = dieToss();
        return die1 == 6 || die2 == 6 || die3 == 6 || die4 == 6;
    }
    
    /**
     * Simulates the tossing of a pair of dice 25 times, and then checking to
     * see if any of the pairs were both sixes.
     * @return whether or not any of the 25 pairs of dice were both sixes
     */
    private static boolean doubleSix() {
        boolean doubleSixes = false;
        for (int i = 0; i < 25; i++) {
            int die1 = dieToss();
            int die2 = dieToss();
            if (die1 == 6 && die2 == 6) {
                doubleSixes = true;
            }
        }
        return doubleSixes;
    }
}
