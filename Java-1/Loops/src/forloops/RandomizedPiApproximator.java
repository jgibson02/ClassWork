package forloops;

/**
 *
 *
 * @author John Gibson}
 */
public class RandomizedPiApproximator {

    public static void main(String[] args) {
        int hits = 0;
        final int NUM_DARTS = 100_000_000;
        
        // Repeat the experiment of throwing a dart onto the square and keep track of the
        // number of hits in the bullseye
        for (int i = 0; i < NUM_DARTS; i++) {
            // position of randomly thrown dart
            double x = Math.random();
            double y = Math.random();
            boolean insideBullseye;
            
            // Is the dart inside the bullseye?
            if (Math.hypot(x, y) <= 1) {
                hits++;
            }
        }
        
        // Since the area of the bullseye is π/4, the expected number of hits is NUM_DARTS
        // * π/4. So we estimate π by computing 4 * hits / NUM_DARTS.
        double π = 4.0 * hits / NUM_DARTS;
        System.out.println("\u03c0 = " + π);
        System.out.println("\u03c0 = " + Math.PI);
    }

}
