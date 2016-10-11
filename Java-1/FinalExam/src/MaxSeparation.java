
import java.util.Scanner;

/**
 *
 *
 * @author John Gibson
 */
public class MaxSeparation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.next();
        System.out.println("Maximum separation: " + findMaxSeparation(input));
    }
    
    public static int findMaxSeparation(String input) {
        int inputLength = input.length();
        int greatestSeparation = 0;
        
        for (int i = 0; i < inputLength; i++) {
            char c = input.charAt(i);
            int n = 0;
            for (int j = i + 1; j < inputLength; j++) {
                if (c == input.charAt(j)) {
                    n = j - i;
                }
            }
            if (n > greatestSeparation) {
                greatestSeparation = n;
            }
        }
        
        return greatestSeparation;
    }

}
