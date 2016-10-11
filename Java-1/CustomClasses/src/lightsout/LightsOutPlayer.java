package lightsout;

import java.util.Scanner;

/**
 * This program uses the LightsOut class as a backend for playing the game.
 * 
 * @author John Gibson
 */
public class LightsOutPlayer {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number of rows and columns: ");
        int r = in.nextInt();
        int c = in.nextInt();
        System.out.println();
        
        LightsOut game = new LightsOut(r, c);
        System.out.println(game);
        
        while(!game.isOver()) {
            System.out.println("What is your next move?");
            r = in.nextInt();
            c = in.nextInt();
            System.out.println();
            game.move(r, c);
            System.out.println(game);
        }
        System.out.println("Lights Out!");
        System.out.println("Number of turns: " + game.turns);
    }

}
