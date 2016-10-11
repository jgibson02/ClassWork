package date;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * 
 * 
 * @author John Gibson
 */
public class DayOfWeekCalculator {

    public static void main(String[] args) {
        String prompt = "Enter month, day, and year.\n";
        prompt += "Format: MM/DD/YYYY or MM DD YYYY";
        String input = JOptionPane.showInputDialog(prompt);
        input = input.replaceAll("/", " ");
        
        Scanner sc = new Scanner(input);
        int m = sc.nextInt();
        int d = sc.nextInt();
        int y = sc.nextInt();
        
        Date date = new Date(m, d, y);
        String msg = "Your date: " + date.toString();
        
        Date now = new Date();
        now.tick(25000); // go forward 25,000 days into the future
        
        msg += "\n" + 25000 + " days from today: " + now;
        JOptionPane.showMessageDialog(null, msg);
    }

}