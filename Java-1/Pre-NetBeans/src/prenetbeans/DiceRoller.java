/**
* Simulates rolling a pair of dice.
*
* @author John Gibson
*
*/
package main;

import javax.swing.*;
import java.util.Random;
import java.awt.*;

public class DiceRoller {
  public static void main(String[] args) {
    Random rand = new Random();

    //roll the dice
    int die1 = rand.nextInt(6) + 1;
    int die2 = rand.nextInt(6) + 1;
    int sum = die1 + die2;

    //display results
    System.out.println("First die:" + die1);
    System.out.println("Second die:" + die2);
    System.out.println("Sum:" + sum);

/*    //create window
    JFrame frame = new JFrame("DiceRoller");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);
    frame.pack();
    frame.setVisible(true);
*/
  }
}