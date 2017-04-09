package cards;

import java.util.Scanner;

public class DrawChance {

  public static void main(String[] args) {
    
    Deck deck = new Deck();
    Hand hand = new Hand();
    Scanner input = new Scanner(System.in);
    
    
    while (deck.deckAL.size() != 0) {
      System.out.println("Cards left in deck: " + deck.deckAL.size());
      System.out.println("Cards in hand: " + hand.handAL.size());
    
      System.out.println("Enter '0' to skip drawing or '1' to draw a card");
      int skip = input.nextInt();
      if (skip != 0) {
        System.out.println("Drawn suit? (1 = clubs, 2 = diamonds, 3 = hearts, 4 = spades)");
        int suit = input.nextInt();
        System.out.println("Drawn value? (1 = ace, ..., 11 = jack, 12 = queen, 13 = king)");
        int value = input.nextInt();
      
        while (deck.availableCard(suit, value) == false) {
          System.out.println("Unavailable Card!");
          System.out.println("Drawn suit? (1 = clubs, 2 = diamonds, 3 = hearts, 4 = spades)");
          suit = input.nextInt();
          System.out.println("Drawn value? (1 = ace, ..., 11 = jack, 12 = queen, 13 = king)");
          value = input.nextInt();
        }
        
        hand.draw(suit, value);
        deck.remove(suit, value);
      }
      
      System.out.println("View Hand? (y = yes, n = no)");
      String viewHand = input.next();
      if (viewHand.equals("y")) {
        hand.viewHand();
      }
    
      System.out.println("Would you like to know your chances of drawing a specific card? (y = yes, n = no)");
      String cardChance = input.next();
      if (cardChance.equals("y")) {
        
        System.out.println("Which suit? (0 = all, 1 = clubs, 2 = diamonds, 3 = hearts, 4 = spades)");
        int suitChance = input.nextInt();
        System.out.println("Which Value? (0 = all, 1 = ace, ..., 11 = jack, 12 = queen, 13 = king)");
        int valueChance = input.nextInt();
        System.out.println(String.format("%.2f", deck.chance(suitChance, valueChance)) + "%");
        
      }
      
      System.out.println();
    }
    input.close();
    
  }

}
