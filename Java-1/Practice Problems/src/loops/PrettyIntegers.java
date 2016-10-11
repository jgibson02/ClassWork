package loops;

import java.util.Scanner;

/**
 *
 * @author John Gibson
 */
public class PrettyIntegers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        String input = sc.next();
        int length = input.length();
        String s = "";
        int marker = 0;
        
        for (int i = 0; i < length; i++) {
            if ((length - i) % 3 == 0) {
                s += input.substring(marker, i) + "," + input.substring(i, length);
                marker = i;
            }
        }
        System.out.println(s);
    }

}
