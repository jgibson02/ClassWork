package onedim;

import java.util.Random;

/**
 *
 *
 * @author John Gibson}
 */
public class DiceRoller2 {

    public static void main(String[] args) {
        final int TRIALS = 10_000;
        
        //number of times we get exactly 1000 sixes
        int hits = 0;
        
        for (int i = 0; i < TRIALS; i++) {
            if (roll6000()) {
                hits++;
            }
        }
        System.out.println((double) hits / TRIALS);
    }
    
    public static boolean roll6000() {
        Random rand = new Random();

        int sixes = 0;
        for (int i = 0; i < 6000; i++) {
            int a = 1 + rand.nextInt(6);
            if (a == 6) {
                sixes++;
            }
        }
        return sixes == 1000;
    }
}
