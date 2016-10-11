/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package whileloops;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author John Gibson}
 */
public class RandomWalk {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog("Enter radius: ");
        int radius = Integer.parseInt(input);
        final int TRIALS = 1000;
        int sumOfAllWalks = 0;
        int longestWalk = 0;
        int shortestWalk = Integer.MAX_VALUE;
        int i = 0; //loop counter
        
        while (i < TRIALS) {
            int currentLength = randomWalk(radius);
            sumOfAllWalks += currentLength;
            longestWalk = Math.max(currentLength, longestWalk);
            shortestWalk = Math.min(currentLength, shortestWalk);
            i++;
        }
        
        int avg = sumOfAllWalks / TRIALS;
        String result = "It took an average of " + avg + " steps to get to the edge." +
                "\nLongest walk: " + longestWalk + " steps." + "\nShortest walk: "
                + shortestWalk + " steps.";
        JOptionPane.showMessageDialog(null, result);
    }
    /**
     * Simulates a random walk in two dimensions.
     * @param n the radius of the circle
     * @return the number of steps taken before reaching the edge
     */
    private static int randomWalk(int n) {
        int steps = 0;
        int x = 0; //x-coordinate of current position
        int y = 0; //y-coordinate of current position
        Random rand = new Random();
        while (Math.hypot(x, y) < n) {
            int k = rand.nextInt(4);
            if (k == 0) {
                x++;
            }
            if (k == 1) {
                x--;
            }
            if (k == 2) {
                y++;
            }
            if (k == 3) {
                y--;
            }
            steps++;
        }
        return steps;
    }
}
