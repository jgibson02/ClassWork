package forloops;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 *
 * @author John Gibson}
 */
public class Blackjack {
    public static ArrayList playerHand = new ArrayList();
    public static ArrayList dealerHand = new ArrayList();
    public static Scanner sc = new Scanner(System.in);
    public static int cardsDealtToPlayer = -1;
    public static int cardsDealtToDealer = -1;
    
    public static void main(String[] args) {
                
        playerHand.add(dealCardToPlayer());
        playerHand.add(dealCardToPlayer());
        playerHand.trimToSize();
        
        dealerHand.add(dealCardToDealer());
        dealerHand.add(dealCardToDealer());
        dealerHand.trimToSize();
        
        System.out.println("The dealer deals you 2 cards: " + playerHand.get(0) + " " + playerHand.get(1));
        System.out.println("The dealer's face up card is: " + dealerHand.get(0));
        
        boolean gameOver = false;
        boolean playersTurn = true;
        if (playerHandSum() > 21) {
            System.out.println("Bust. Your hand was a total of " + playerHandSum() + ".");
        } else if (dealerHandSum() > 21) {
            System.out.println("You win! The dealer busted. Their total was " + dealerHandSum());
        } else {
            System.out.print("Enter STAND or HIT: ");
            if ("STAND".equals(sc.next())) {
                    System.out.println("The dealer's hole is: " + dealerHand.get(cardsDealtToDealer));
                    playersTurn = false;
            } else if ("HIT".equals(sc.next())) {
                    playerHand.ensureCapacity(cardsDealtToPlayer + 1);
                    playerHand.add(dealCardToPlayer());
                    System.out.print("Your next card is " + playerHand.get(cardsDealtToPlayer));
            }
        }
        /*
        if (!playersTurn) {
            if ((int) dealerHand.get(1) >= 17) {
                
            }
        */
        }
    
    private static int dealCardToPlayer() {
        Random rand = new Random();
        cardsDealtToPlayer++;
        return 1 + rand.nextInt(10);
    }
    
    private static int dealCardToDealer() {
        Random rand = new Random();
        cardsDealtToDealer++;
        dealerHand.ensureCapacity(cardsDealtToDealer);
        return 1 + rand.nextInt(10);
    }
    
    private static int playerHandSum() {
        int playerHandSum = 0;
        for (int i = 0; i < playerHand.size(); i++) {
            playerHandSum += (int) playerHand.get(i);
        }
        return playerHandSum;
    }
    
    private static int dealerHandSum() {
        int dealerHandSum = 0;
        for (int i = 0; i < playerHand.size(); i++) {
            dealerHandSum += (int) playerHand.get(i);
        }
        return dealerHandSum;
    }

}
