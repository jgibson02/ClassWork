package onedim;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 * This program simulates the random drawing from a set of coupons, and estimates the
 * number of drawings that would need to be taken to have a likely probability of having
 * each of 10 unique coupons.
 *
 * @author John Gibson
 */
public class CouponCollector {

    public static void main(String[] args) {
        String prompt = "How many types of coupons are there?";
        int n = Integer.parseInt(JOptionPane.showInputDialog(prompt));
        
        final int TRIALS = 1000;
        int total = 0; // number of coupons collected across all trials
        for (int i = 0; i < TRIALS; i++) {
            total += collectCoupons(n);
        }
        
        int avg = total / TRIALS;
        String result = avg + " random coupons were needed on average\n";
        result += "in order to collect one of each type.";
        JOptionPane.showMessageDialog(null, result);
    }
    
    /**
     * Simulates the collection of random coupons until one of 
     * @param n
     * @return 
     */
    private static int collectCoupons(int n) {
        Random rand = new Random();
        
        // coupons[k] = true means the k-th type has been collected
        boolean[] coupons = new boolean[n];
        int couponsCollected = 0;
        int typesCollectedSoFar = 0;
        
        // collect coupons
        while (typesCollectedSoFar < n) {
            int k = rand.nextInt(n);
            couponsCollected++;
            if (!coupons[k]) { // a new coupon
                coupons[k] = true;
                typesCollectedSoFar++;
            }
            couponsCollected++;
        }
        
        return couponsCollected;
    }
}