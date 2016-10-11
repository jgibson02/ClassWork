package exceptions;

/**
 * 
 * @author John Gibson
 * @version Apr 25, 2016
 */
public class ExceptionsDemo {

    static final String INDENT = "   ";
    static final String INDENT2 = INDENT + INDENT;

    public static void main(String[] args) throws MyException {
        System.out.println("out");
        System.err.println("err");
        System.out.println("In main: 1");
        f(0);
        System.out.println("In main: 2");
        f(1);
        System.out.println("In main: 3");
    }

    public static void f(int x) throws MyException {
        System.out.println(INDENT + " Entering f with argument " + x);
        try {
            if (x == 0) {
                throw new MyException("x = 0");
            }
            if (x == 1) {
                throw new RuntimeException();  // unchecked
            }
        } catch(Exception e) {
            System.out.println(INDENT2 + "Catching MyException");
        } finally {
            System.out.println(INDENT2 + "Entering finally block.");
        }
        System.out.println("Leaving finally.");
    }
}

class MyException extends Exception { // checked
    public MyException(String msg) {
        super(msg);
        System.err.println(ExceptionsDemo.INDENT + "Construction MyException: " + msg);
    }
}