package forloops;

/**
 * Estimates the value of pi using the famous identity
 * 
 *   pi = 4 - 4/3 + 4/5 - 4/7 + ... 
 *
 * @author John Gibson}
 */
public class PiApproximator {

    public static void main(String[] args) {
        double π = 4.0;
        final int REPS = Integer.MAX_VALUE;
        long denominator = 3;
        
        for (int i = 0; i < REPS; i++) {
            if (i % 2 == 1) {
                π += 4.0 / denominator;
            } else {
                π -= 4.0 / denominator;
            }
            denominator += 2;
        }
        
        System.out.println("\u03C0 = " + π);
        System.out.println("\u03C0 = " + Math.PI);
    }

}
