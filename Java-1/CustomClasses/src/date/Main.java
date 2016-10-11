package date;

/**
 *
 *
 * @author John Gibson
 */
public class Main {

    public static void main(String[] args) {
        Date d = new Date(10, 17, 2011);
        System.out.println(d);
        
        d.tick(25000);
        System.out.println(d);
    }

}
