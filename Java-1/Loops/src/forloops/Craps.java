package forloops;

import java.util.Random;

/**
 * The game of Craps is an old dice game. The player rolls the dice and:
 * 
 * (a) If the sum is 7 or 11, the player WINS.
 * (b) If the sum is 2, 3, or 12, the player LOSES.
 * 
 * If the player does not win or lose on the first roll, she continues rolling until she
 * gets either:
 * 
 * (a) the sum obtained on the first roll (WINS)
 * (b) a sum of 7 (LOSES)
 * 
 * @author John Gibson}
 */
public class Craps {

    public static void main(String[] args) {
        Random rand = new Random();
        
        //first roll
        int die1 = 1 + rand.nextInt(6);
        int die2 = 1 + rand.nextInt(6);
        int firstSum = die1 + die2;
        
        System.out.println(die1 + " + " + die2 + " = " + firstSum);
        
        if (firstSum == 7 || firstSum == 11) {
            System.out.println("You win!");
        } else if (firstSum == 2 || firstSum == 3 || firstSum == 12) {
            System.out.println("You lose!");
        } else { // the game continues
            int newSum = 0;
            while (newSum != firstSum || newSum == 7) {
                die1 = 1 + rand.nextInt(6);
                die2 = 1 + rand.nextInt(6);
                newSum = die1 + die2;
                System.out.println(die1 + " + " + die2 + " = " + newSum);
            }
            
            // game over
            if (newSum == firstSum) {
                System.out.println("You win!");
            } else {
                System.out.println("You lose!");
            } // else
        } // if statement
    } //main method

}
