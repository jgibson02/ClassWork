package homework3;

import java.text.DecimalFormat;
import java.util.Random;

/**
 * This program simulates the game Fatal Fives 1 million times,and finds the
 * average profit received from the game.
 * @author John Gibson
 */
public class FatalFives {

    public static void main(String[] args) {
        // number of times game should be repeated
        final int NUM_TRIALS = 1_000_000;
        
        // sum of all profits made during simulation
        int totalProfit = 0;
        
        // runs the game 1 million times
        for (int i = 0; i < 1_000_000; i++) {
            totalProfit += fatalFivesProfit();
        }
        
        // the mean profit of all trials
        double averageProfit = (double) totalProfit / NUM_TRIALS;
        
        DecimalFormat dollarFormat = new DecimalFormat("0.00");
        dollarFormat.setMaximumFractionDigits(2);
        
        System.out.println("$" + dollarFormat.format(averageProfit));
    }
    
    private static int fatalFivesProfit() {
        Random rand = new Random();
        int profit = 0;
        int die1 = 1 + rand.nextInt(6);
        int die2 = 1 + rand.nextInt(6);
        int die3 = 1 + rand.nextInt(6);
        
        if (die1 != 5 && die2 != 5 && die3 != 5) {
            profit = die1 + die2 + die3;
        }
        if (die1 != 5 && die2 != 5 && die3 == 5) {
            profit = die1 + die2;
        }
        if (die1 != 5 && die2 == 5) {
            profit = die1;
        }
        if (die1 == 5) {
            profit = 0;
        }
        return profit;
    }
}
