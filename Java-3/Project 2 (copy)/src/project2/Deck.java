package project2;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 
 * @author jhg95693
 */
public class Deck {
    
    private static ArrayList<Card> deck;
    
    public Deck() {
        deck = new ArrayList<>();
        
        for (int i = 1; i <= 13; i++)
        {
            for (int j = 1; j <= 4; j++)
            {
                switch (j) {
                    case 1: 
                        deck.add(new Card(i, Card.Suit.SPADES));
                        break;
                    case 2:
                        deck.add(new Card(i, Card.Suit.HEARTS));
                        break;
                    case 3:
                        deck.add(new Card(i, Card.Suit.DIAMONDS));
                        break;
                    case 4:
                        deck.add(new Card(i, Card.Suit.CLUBS));
                        break;
                }
            }
        }
    }
    
    public Card get(int index) {
        return deck.get(index);
    }
    
    public void remove(Card c) {
        deck.remove(c);
    }
    
    public void shuffle() {
        Collections.shuffle(deck);
    }
    
    public String toString() {
        String s = "";
        for (Card c : deck) {
            s += c.getValue() + " of " + c.getSuit() + ", ";
        }
        return s;
    }
    
}
