package homework3;

import java.util.Scanner;

/**
 * This program calculates the difference between the sum of the squares of each integer
 * between 0 and a user-specified positive integer and the square of the sum of all 
 * integers within the same range.
 * @author John Gibson
 */
public class SquareSum {

    public static void main(String[] args) {
        // Receive upper limit from user
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int n = sc.nextInt();
        
        int sumSquares = 0;
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sumSquares += Math.pow((double) i, 2); // sums the square of each increment of i
            sum += i; //as i increments, its value is added to the previous sum
        }
        System.out.println("Square Sum Difference: " + ((sum * sum) - sumSquares));
    }

}