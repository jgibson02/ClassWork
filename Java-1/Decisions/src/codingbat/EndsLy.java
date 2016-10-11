package codingbat;

/**
 *
 * @author John Gibson
 */
public class EndsLy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(endsLy("only"));
        System.out.println(endsLy("onyx"));
    }
    
    public static boolean endsLy(String str) {
        int n = str.length();
        if (n < 2) {
            return false;
        }
        String lastTwo = str.substring(n-2, n);
        if (lastTwo.equals("ly")) {
            return true;
        }
        return false;
    }
}
