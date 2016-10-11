package project2;

/**
 * Represents a standard playing card, holding a suit of HEART, CLUB, SPADE, or
 * DIAMOND, and holding a numeric value of some integer from 1 - 13 (inclusive),
 * treating a value of 1 as an ace.
 * @author jhg95693
 */
public class Card implements Comparable<Card>
{

    public enum Suit
    {
        HEARTS, CLUBS, SPADES, DIAMONDS
    }

    private final int VALUE;
    private final Suit SUIT;
    
    public Card(int value, Suit suit) {
        VALUE = value;
        SUIT = suit;
    }

    public int getValue()
    {
        return VALUE;
    }

    public Suit getSuit()
    {
        return SUIT;
    }
    
    @Override
    public int compareTo(Card c)
    {
        int value = c.getValue();
        
        if (this.VALUE > value) {
            return 1;
        } else if (this.VALUE == value) {
            return 0;
        } else {
            return -1;
        }
    }

}
