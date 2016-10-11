package average;

import java.awt.Rectangle;
import java.util.Scanner;

/**
 * This short program calculates the average of a set of exam scores.
 *
 * @author John Gibson
 */
public class ExamScoreAverager {

    public static void main(String[] args) {
        System.out.print("Enter number of exams: ");
        Scanner sc = new Scanner(System.in);
        int numExams = sc.nextInt();
        
        Averager exams = new Averager();
        for (int i = 1; i <= numExams; i++) {
            System.out.print("Enter score " + i + ": ");
            int score = sc.nextInt();
            exams.addValue(score);
        
            
            double avg = exams.getAverage();
            System.out.println("Average score: " + avg);
        }

    }
}