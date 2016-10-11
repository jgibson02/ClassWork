package demo;

import java.text.DecimalFormat;
import java.util.Arrays;

/**
 *
 * @author jhg95693
 */
public class ComparableDemo {

    public static void main(String[] args) {
        // populates an array of doubles with 5 random numbers
        double[] d = new double[5];
        for (int i = 0; i < 5; i++) {
            d[i] = Math.random();
        }
        
        // sort and display
        Arrays.sort(d);
        for (int i = 0; i < 5; i++) {
            System.out.println(d[i]);
        }
        
        MilePace[] paces = new MilePace[3];
        paces[0] = new MilePace(6, 47);
        paces[1] = new MilePace(5, 17);
        paces[2] = new MilePace(7, 24);
        
        // sort and display
        Arrays.sort(paces);
        for (int i = 0; i < 3; i++) {
            System.out.println(paces[i]);
        }
    }

}

/**
 * 
 * @author jhg95693
 */
class MilePace implements Comparable {
    private final int min;
    private final int sec;
    
    public MilePace(int min, int sec) {
        this.min = min;
        this.sec = sec;
    }
    
    @Override
    public String toString() {
        DecimalFormat f = new DecimalFormat("00");
        return min + ":" + f.format(sec);
    }

    @Override
    public int compareTo(Object o) {
        MilePace otherPace = (MilePace) o;
        if (this.min < otherPace.min) {
            return -1;
        }
        if (this.min > otherPace.min) {
            return 1;
        }
        
        // minutes are the same
        if (this.sec < otherPace.sec) {
            return -1;
        }
        if (this.sec > otherPace.sec) {
            return 1;
        }
        
        return 0;
    }
}
