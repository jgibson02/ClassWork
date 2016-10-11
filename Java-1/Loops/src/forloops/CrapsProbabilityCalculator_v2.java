package forloops;

import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * Estimates the probability of winning the game of Craps.
 *
 * @author John Gibson}
 */
public class CrapsProbabilityCalculator_v2 {

    public static void main(String[] args) {
        final int NUM_GAMES = 1_000_000;
        int wins = 0;
        int totalNumberOfRolls = 0; // total over all games
        int greatestNumberOfRolls = 0;
        
        for (int i = 0; i < NUM_GAMES; i++) {
            int winAtCraps = winAtCraps();
            boolean playerWins = winAtCraps > 0;
            int numberOfRolls = Math.abs(winAtCraps);
            if (playerWins) {
                wins++;
            }
            if (numberOfRolls > greatestNumberOfRolls) {
                greatestNumberOfRolls = numberOfRolls;
            }
            totalNumberOfRolls += numberOfRolls;
        }
        
        double winPercentage = 100.0 * wins / NUM_GAMES;
        int avg = totalNumberOfRolls / NUM_GAMES;
        String s1 = wins + "/" + NUM_GAMES + " wins.";
        String s2 = "Winning percentage: " + winPercentage + "%";
        String s3 = "Average number of rolls: " + avg;
        String s4 = "Greatest number of rolls: " + greatestNumberOfRolls;
        String output = s1 + "\n" + s2 + "\n" + s3 + "\n" + s4;
        ImageIcon d20 = new ImageIcon("d20.jpg");
        JOptionPane.showMessageDialog(null, output, "Results", JOptionPane.INFORMATION_MESSAGE, d20);
    }
    
    private static int rollDice() {
        Random rand = new Random();
        int x = rand.nextInt(6) + 1;
        int y = rand.nextInt(6) + 1;
        return x + y;
    }
    
    /**
     * Simulates the game of craps.
     * @return the number of rolls (positive if the player wins)
     */
    private static int winAtCraps() {
        int firstSum = rollDice();
        if (firstSum == 7 || firstSum == 11) {
            return 1;
        }
        if (firstSum == 2 || firstSum == 3 || firstSum == 12) {
            return -1;
        }
        int rolls = 1;
        int newSum = 0;
        while (newSum != firstSum && newSum != 7) {
            newSum = rollDice();
            rolls++;
        }
        if (newSum == firstSum) {
            return rolls;
        }
        return -rolls;
    }

}
