package implementingclasses;

import java.util.Scanner;

/**
 *
 * @author jhg95693
 */
public class StringTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyString string = new MyString(10);
        
        string.add('A');
        string.add('B');
        string.add('C');
        string.add('D');
        System.out.println(string);
        
        string.reverse();
        string.removeLast();
        string.add('X');
        string.add('Y');
        
        System.out.println(string);
    }
    
}
