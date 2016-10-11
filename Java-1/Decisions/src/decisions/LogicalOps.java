/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package decisions;

import java.util.Random;

/**
 *
 * @author John Gibson}
 */
public class LogicalOps {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Random rand = new Random();
       int die = rand.nextInt(6) + 1;
       
       boolean isEven = die % 2 == 0;
       
       if (isEven) {
           System.out.println(die + " is even.");
        } else {
           System.out.println(die + " is odd.");
       }
    }
}
