package exam2;

import java.util.Random;

/**
 * This program simulates the rolling of 3 dice, and determining whether they won if the
 * sum of their dice rolls is between 11 and 17 (inclusive) and the three dice are not of
 * equal value. The program also performs this simulation a set number of times and tells
 * the user the probability of winning.
 * 
 * @author John Gibson
 */
public class ElevenSeventeen {

    public static int wins = 0;
    
    public static void main(String[] args) {
        final int TRIALS = 1_000_000;
        for (int i = 0; i < TRIALS; i++) {
            if (playGame()) {
                wins++;
            }
        }
        
        System.out.println("The average probability of winning is: " + 
                (100 * (double) wins / TRIALS) + "%");
    }
    
    /**
     * Performs the logical analysis of the three rolled dice.
     * @return a boolean value representing whether the player has won or lost
     */
    private static boolean playGame() {
            int die1 = diceRoll();
            int die2 = diceRoll();
            int die3 = diceRoll();
            int sum = die1 + die2 + die3;
            
            boolean winsGame = (sum >= 11 && sum <= 17) && (die1 != die2 || die1 != die3);
            return winsGame;
    }
    
    /**
     * Simulates the rolling of a single die.
     * @return the integer value of a dice roll between 1 and 6
     */
    public static int diceRoll() {
        Random rand = new Random();
        return 1 + rand.nextInt(6);
    }
}