
import java.util.Random;
import java.util.Scanner;

/**
 *
 *
 * @author John Gibson
 */
public class QuokkaSort {
    public static int sizeOfArray = 0;
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Number of values to sort: ");
        int n = in.nextInt();
        while (n > 0) {
            int[] a = getRandomArray(n);
            println(a);
            quokkaSort(a);
            println(a);
            System.out.print("\nNumber of values to sort: ");
            n = in.nextInt();
        }
        System.out.println("Goodbye.");
    }
    
    private static int[] getRandomArray(int n) {
        Random rand = new Random();
        sizeOfArray = n;
        int[] list = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = rand.nextInt(100);
        }
        return list;
    }
    
    private static void println(int[] a) {
        System.out.println();
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
    
    private static void quokkaSort(int[] a) {
        for (int i = 0; i < sizeOfArray; i++) {
            for (int j = 0; j < sizeOfArray - 1; j++) {
            int temp = 0;
            if (a[j] > a[j + 1]) {
                temp = a[j];
                a[j] = a[j + 1];
                a[j + 1] = temp;
                }
            }
        }
        
    }

}
