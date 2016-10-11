package onedim;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 * Implements a list of nouns, verbs, adverbs, and adjectives as arrays of strings, and
 * concatenates random elements of these arrays to form a beautiful and poetic message.
 * 
 * @author John Gibson
 */
public class LoveLetterGenerator2 {

    public static void main(String[] args) {
        String prompt = "Enter the name of your beloved.";
        String name = JOptionPane.showInputDialog(prompt);
        
        String[] verb = {"seek", "watch", "need", "fear", "crave", "envy", "sense", "defenestrate", "arouse", "pillage", "disembowel", "violate"};
        
        String[] adverb = {"dreamily", "ominously", "regretfully", "strangely", "angrily", "maliciously"};
        
        String[] adjective = {"dazzling", "pulsating", "overflowing", "lunar", "planar", "ogretastic", "dank",  "MLG"};
        
        String[] noun = {"moon", "heart", "mist", "life", "ghost", "field", "ath'ete's foot", "Oxycontin", "crabs", "toenails", "peepers", "onions"};
        
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
