package decisions;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * Computes a day of the week for a given date. We use Zeller's congruence,
 * which maps the date to an integer in the range [0, 6] corresponding to the
 * day of the week.
 * 
 * @author John Gibson
 */
public class DayOfWeekCalculator {

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
        
        if (x == 0) {
            JOptionPane.showMessageDialog(null, "Saturday");
        }
        if (x == 1) {
            JOptionPane.showMessageDialog(null, "Sunday");
        }
        if (x == 2) {
            JOptionPane.showMessageDialog(null, "Monday");
        }
        if (x == 3) {
            JOptionPane.showMessageDialog(null, "Tuesday");
        }
        if (x == 4) {
            JOptionPane.showMessageDialog(null, "Wednesday");
        }
        if (x == 5) {
            JOptionPane.showMessageDialog(null, "Thursday");
        }
        if (x == 6) {
            JOptionPane.showMessageDialog(null, "Friday");
        }
    }
}