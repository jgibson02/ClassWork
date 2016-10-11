package onedim;

/**
 * This program illustrates the for-each loop and the array clone method.
 * 
 * @author John Gibson
 */
public class ForEachDemo {

    public static void main(String[] args) {
        int[] fib = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34};
        for (int i = 0; i < fib.length; i++) {
            System.out.println(fib[i]);
        }
        
        for (int k : fib) {
            System.out.println(k);
        }
        
        // what is the difference?
        int[] fib2 = fib;
        int[] fib3 = fib.clone();
    }

}
