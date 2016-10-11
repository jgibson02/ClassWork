/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package forloops;

import java.util.Random;

/**
 * Consider the following game: you roll three dice and you win if the number showing on
 * one of the dice is equal to the sum of the numbers showing on the other two.
 * 
 * This program estimates the probability of winning this game.
 * 
 * @author John Gibson}
 */
public class SumGame {

    public static void main(String[] args) {
        final int TRIALS = 10_000_000;
        int wins = 0;
        for (int i = 0; i < TRIALS; i++) {
            
            if (playGame()) {
                wins++;
            }
        }
        
        double prob = ((double) wins / TRIALS) * 100;
        System.out.println("Probability of winning: " + prob + "%.");
    }
    private static boolean playGame() {
        Random rand = new Random();
        int x = 1 + rand.nextInt(6);
        int y = 1 + rand.nextInt(6);
        int z = 1 + rand.nextInt(6);
        return x + y == z || x + z == y || y + z == x;
    }
}