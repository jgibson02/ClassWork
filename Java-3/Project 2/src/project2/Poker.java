package project2;

/**
 * 
 * @author jhg95693
 */
public class Poker {
    
    private static Card[] hand = new Card[5];
    private static Deck deck;
    
    public static void main(String[] args) {
        
        deck = new Deck();
        deck.shuffle();
        getHand();
        printHand();
        
        //System.out.println(deck);
    }
    
    public static void getHand() {
        for (int i = 0; i < 5; i++) {
            Card c = deck.get(0);
            hand[i] = c;
            deck.remove(c);
        }
    }
    
    public static void printHand() {
        System.out.print("Your hand: ");
        for (int i = 0; i < 5; i++) {
            if (i != 4) {
                System.out.print(hand[i].getValue() + " of " + hand[i].getSuit() + ", ");
            } else {
                System.out.print(hand[i].getValue() + " of " + hand[i].getSuit() + ".");
            }
        }
        System.out.println();
    }
    
}
