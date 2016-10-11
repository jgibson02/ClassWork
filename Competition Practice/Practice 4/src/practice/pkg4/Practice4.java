/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.pkg4;

/**
 *
 * @author jhg95693
 */
public class Practice4
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        System.out.println(isSubstring("waterbottle", "erbottlewat"));
        System.out.println(memes("Mr John Smith   ", 13));
        System.out.println(memes("Two to the One from the One to the Three                 ", 420));
    }
    
    public static boolean isSubstring(String word, String x) {
        if (word.length() == 1) {
            return false;
        } else {
            boolean isInWord = false;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == x.charAt(0)) {
                    isInWord = true;
                }
            }
            return isInWord && ((x.length() == 1) || isSubstring(word, x.substring(1)));
        }
    }
    
    public static char[] memes(String input, int space) {
        return input.replace(" ", "%20").substring(0, input.length() + 1).toCharArray();
    }
    
}
