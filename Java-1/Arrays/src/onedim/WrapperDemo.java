package onedim;

import java.util.ArrayList;

/**
 * Demonstrates wrapper classes and autoboxing.
 *
 * @author John Gibson
 */
public class WrapperDemo {

    public static void main(String[] args) {
        Integer x = new Integer(100);
        System.out.println(x.intValue());
        
        // autoboxing
        Integer y = 23; // means: Integer y = new Integer(23);
        
        // unboxing
        int a = y.intValue();
        int b = y; // means: int b = y.intValue();
        
        ArrayList<Double> list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            list.add(Math.random());
        }
        for (int i = 0; i < 10; i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
        
        list.add(4, 0.0);
        for (int i = 0; i < 10; i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

}