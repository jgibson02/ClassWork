/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam.pkg1;

import java.util.Scanner;

/**
 * This program finds the lowest grade out of a set of 3 user-inputted test scores, and then calculates the average of the highest two scores
 * @author John
 */
public class CompositeScore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter three exam scores: ");
        int score1 = sc.nextInt();
        int score2 = sc.nextInt();
        int score3 = sc.nextInt();
        
        //find lowest score
        int lowestOf2 = Math.min(score1, score2);
        int lowestOf3 = Math.min(lowestOf2, score3);
        int sum = score1 + score2 + score3;
        int compositeScore = (sum - lowestOf3) / 2;
        
        System.out.println("Composite score: " + compositeScore);        
    }
}
