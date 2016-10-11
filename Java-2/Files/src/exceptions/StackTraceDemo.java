

package exceptions;

/**
 * Slightly modified version of code in 11.7 of Java SE 8 for Programmers 3e (Deitel & Deitel)
 *
 * @author Drue Coles
 */
public class StackTraceDemo {

    public static void main(String[] args) {
        try {
            f();
        } catch (Exception e) {
            System.err.println(e.getMessage() + "\n");
            e.printStackTrace();
            System.err.println();

            StackTraceElement[] traceElements = e.getStackTrace();
            for (StackTraceElement element : traceElements) {
                System.out.print(element.getClassName() + "\t");
                System.out.print(element.getFileName() + "\t");
                System.out.print(element.getLineNumber() + "\t");
                System.out.println(element.getMethodName());
            }
        }
    }

    private static void f() throws Exception {
        g();
    }

    private static void g() throws Exception {
        h();
    }

    private static void h() throws Exception {
        throw new Exception("Exception thrown in h.");
    }
}