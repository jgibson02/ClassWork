package forloops;

import java.util.Random;

/**
 *
 *
 * @author John Gibson}
 */
public class AsciiDemo {

    public static void main(String[] args) {
        String s = "!@#$%^&*()_+";
        int n = s.length();
        
        Random rand = new Random();
        char c1 = s.charAt(rand.nextInt(n));
        char c2 = s.charAt(rand.nextInt(n));
        
        if (c1 < c2) {
            System.out.println(c1 + " is before " + c2);
        } else {
            System.out.println(c2 + " is before " + c1);
        }
    }

}
