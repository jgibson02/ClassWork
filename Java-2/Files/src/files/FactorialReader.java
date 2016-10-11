package files;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * 
 * @author John Gibson
 * @version Apr 25, 2016
 */
public class FactorialReader {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        open();
    }
    
    private static void open() {
        final String FILE_NAME = "factorial.txt";
        Scanner in = null;
        try {
            in = new Scanner(Paths.get(FILE_NAME));
        } catch (IOException e) {
            System.err.println("Could not open file: " + FILE_NAME);
        }
    }

}