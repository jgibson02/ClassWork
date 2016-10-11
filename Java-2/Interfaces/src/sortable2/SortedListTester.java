package sortable2;

import java.util.Random;

/**
 * Tests the sorted list class.
 * @author jhg95693
 */
public class SortedListTester {

    public static void main(String[] args) {
        SortedList list = new SortedList();
        
        // add 10 random points
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            int x = rand.nextInt(100);
            int y = rand.nextInt(100);
            list.add(new Point(x, y));
        }
        
        // display the points
        for (int i = 0; i < 10; i++) {
            Point p = (Point) list.get(i);
            System.out.println(p + " " + p.distance());
        }
        
        list = new SortedList();
        list.add(new NetworkUser("Jane", "ivy883"));
        list.add(new NetworkUser("Beamer", "sdkjh5"));
        list.add(new NetworkUser("quokka", "FJFJF"));
        list.add(new NetworkUser("barn", "asdkjfl"));
        
        for (int i = 0; i < 4; i++) {
            System.out.println(list.get(i));
        }
        
        list = new SortedList();
        list.add(new Rectangle(5, 7));
        list.add(new Rectangle(4, 8));
        Rectangle r = (Rectangle) list.get(0);
        double area = r.getWidth() * r.getHeight();
        System.out.println(area);
        
//        list = new SortedList();
//        list.add("Carter");
//        list.add("CVS");
//        list.add("$%^&");
//        for (int i = 0; i < 3; i++) {
//            System.out.println(list.get(i));
//        }
    }

}
