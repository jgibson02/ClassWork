package decisions;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * Computes a day of the week for a given date. We use Zeller's congruence,
 * which maps the date to an integer in the range [0, 6] corresponding to the
 * day of the week.
 * 
 * This version does a little error checking.
 * 
 * @author John Gibson
 */
public class DayOfWeekCalculator3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String prompt = "Enter month, day and year.";
        String input = JOptionPane.showInputDialog(prompt);
        Scanner sc = new Scanner(input);
        int month = sc.nextInt();
        int day = sc.nextInt();
        int year = sc.nextInt();
        
        //rough validity check of the input
        if (isValid(month, day)) {
            String result = dayOfWeek(month, day, year);
            JOptionPane.showMessageDialog(null, result);
        } else {
            JOptionPane.showMessageDialog(null, "Invalid input, you baffoon.");
        }
    }
    
    /**
     * Tells if a given month and day are valid.
     * @param m the month
     * @param d the day
     * @return true if the month is valid and day is between 1-31
     */
    public static boolean isValid(int m, int d) {
        return !(m < 1 || m > 12 || d < 1 || d > 31);
    }
    
    /**
     * Gets the day of the week for a given date.
     * @param month
     * @param day
     * @param year
     * @return the day of the week
     */
    private static String dayOfWeek(int month, int day, int year) {
        //For Zeller's congruence, January and February are counted as months
        // 13 and 14 of the previous year. We calculate three values (a, b, c)
        // that depend on the date and are used by the congruence to determine
        // the day of the week.
        int a = month;
        if (month < 3) {
            a = month + 12;
            year--;
        }
        int b = year % 100;
        int c = year / 100;
        
        //Zeller's congruence
        int x = (day + 26 * (a+1)/10 + b + b/4 + c/4 + 5*c) % 7;
        
        String dayOfWeek = null;
        if (x == 0) {
            dayOfWeek = "Saturday";
        }
        if (x == 1) {
            dayOfWeek = "Sunday";
        }
        if (x == 2) {
            dayOfWeek = "Monday";
        }
        if (x == 3) {
            dayOfWeek = "Tuesday";
        }
        if (x == 4) {
            dayOfWeek = "Wednesday";
        }
        if (x == 5) {
            dayOfWeek = "Thursday";
        }
        if (x == 6) {
            dayOfWeek = "Friday";
        }
        return null;
    }
}