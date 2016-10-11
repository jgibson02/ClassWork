package onedim;

import java.text.DecimalFormat;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 *
 * @author John Gibson}
 */
public class BirthdayProblem {

    public static void main(String[] args) {
        Random rand = new Random();
        final int DAYS_IN_YEAR = 365;
        final int NUM_PEOPLE = 23;
        final int NUM_TRIALS = 10_000;
        
        int numberOfMatches = 0;
        for (int i = 0; i < NUM_TRIALS; i++) {
            
            // generate random birthdays
            int[] birthdays = new int[DAYS_IN_YEAR];
            for (int j = 0; j < NUM_PEOPLE; j++) {
                int n = rand.nextInt(DAYS_IN_YEAR);
                birthdays[n]++;
            }
            
            // check for a birthday match
            boolean foundMatch = false;
            for (int k = 0; k < DAYS_IN_YEAR; k++) {
                if (birthdays[k] > 1) {
                    foundMatch = true;
                }
            }
            
            if (foundMatch) {
                numberOfMatches++;
            }
        }
        
        // compute probability of at least one match
        DecimalFormat dcFormat = new DecimalFormat("#.##");
        double prob = (double) numberOfMatches / NUM_TRIALS * 100;
        JOptionPane.showMessageDialog(null, dcFormat.format(prob) + "%");
    }

}
