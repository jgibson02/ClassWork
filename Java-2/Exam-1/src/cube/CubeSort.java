package cube;

import java.util.Arrays;
import java.util.Random;

/**
 * 
 * @author John Gibson
 */
public class CubeSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random rand = new Random();
        Cube[] cubes = new Cube[20];
        for (int i = 0; i < 20; i++) {
            int l = rand.nextInt(5) + 1;
            int w = rand.nextInt(5) + 1;
            int h = rand.nextInt(5) + 1;
            cubes[i] = new Cube(l, w, h);
        }
        
        Arrays.sort(cubes);
        
        for (Cube c : cubes) {
            System.out.println(c);
        }
    }

}