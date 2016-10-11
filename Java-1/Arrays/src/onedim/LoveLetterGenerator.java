package onedim;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 * Implements a list of nouns, verbs, adverbs, and adjectives as arrays of strings, and
 * concatenates random elements of these arrays to form a beautiful and poetic message.
 * 
 * @author John Gibson
 */
public class LoveLetterGenerator {

    public static void main(String[] args) {
        String prompt = "Enter the name of your beloved.";
        String name = JOptionPane.showInputDialog(prompt);
        
        String[] verb = {"seek", "watch", "need", "fear", "crave", "envy", "sense"};
        
        String[] adverb = {"dreamily", "ominously", "regretfully", "strangely"};
        
        String[] adjective = {"dazzling", "pulsating", "overflowing", "lunar"};
        
        String[] noun = {"moon", "heart", "mist", "life", "ghost", "field"};
        
        String letter = "Dear " + name + ". I " + getRandom(verb) + " your " + 
                getRandom(adverb) + " " + 
                getRandom(adjective) + " " +
                getRandom(noun) + " forever!";
        JOptionPane.showMessageDialog(null, letter);
    }
    
    private static String getRandom(String[] s) {
        Random rand = new Random();
        int k = rand.nextInt(s.length);
        return s[k];
    }

}
