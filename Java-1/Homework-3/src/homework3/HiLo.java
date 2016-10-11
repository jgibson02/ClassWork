package homework3;

import java.util.Random;
import java.util.Scanner;

/**
 * This program simulates a game where a user attempts to guess the number that
 * has been selected by the computer, with a feedback of whether their guess
 * was higher or lower than the computer's selected number.
 * @author John Gibson
 */
public class HiLo {

    public static void main(String[] args) {
        // pick a number between 1 and 100
        Random rand = new Random();
        int n = 1 + rand.nextInt(100);
        
        // prompt the user for input
        Scanner sc = new Scanner(System.in);
        System.out.println("I am thinking of a number between 1 and 100.");
        System.out.print("Guess the number: ");
        
        boolean correctGuess = false;
        int numberOfGuesses = 1;
        while (!correctGuess) {
            int input = sc.nextInt();
            if (input == n) {
                if (numberOfGuesses == 1) {
                    System.out.println("Correct! You made 1 guess.");
                } else {
                    System.out.println("Correct! You made " + numberOfGuesses + 
                            " guesses.");
                }
            } else if (input < n) {
                System.out.print("Too low. Try again: ");
                numberOfGuesses++;
            } else if (input > n) {
                System.out.print("Too high. Try again: ");
                numberOfGuesses++;
            }
        }
    }

}
