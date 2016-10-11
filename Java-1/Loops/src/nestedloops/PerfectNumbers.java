package nestedloops;

/**
 * A perfect number is one that is equal to the sum of its proper divisors. The first four
 * were known to the ancient Greeks. This program displays all perfect numbers below 
 * 10,000.
 *
 * @author John Gibson}
 */
public class PerfectNumbers {

    public static void main(String[] args) {
        final int MAX = 40_000_000;
        for (int numToCheck = 2; numToCheck < MAX; numToCheck++) {
            if (isPerfect(numToCheck)) {
                System.out.println(numToCheck);
            }            
        }
    }
    
    /**
     * Determines if a given number is perfect.
     * @param n an integer greater than 1
     * @return true if n is perfect
     */
    private static boolean isPerfect(int n) {
        int sumOfDivisors = 0;
            for (int divisor = 1; divisor < n; divisor++) {
                if (n % divisor == 0) {
                    sumOfDivisors += divisor;
                }
            }
            return sumOfDivisors == n;
    }

}
