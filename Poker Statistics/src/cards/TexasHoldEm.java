package cards;

import java.util.Scanner;

public class TexasHoldEm {

  public static void main(String[] args) {
    
    Deck deck = new Deck();
    int deckSize = 52;
    int fieldSize = 0;
    RivalPlayerHands rivals = new RivalPlayerHands();
    Hand yours = new Hand();
    Hand field = new Hand();
    Hand yoursNField = new Hand();
    Scanner input = new Scanner(System.in);
  
    System.out.println("How many rivals are there?");
    int numPlayers = input.nextInt();
    for (int i = 0; i < numPlayers; i++) {
      deckSize = deckSize - 2;
    }
    
    System.out.println("Suit of first card in hand? (1 = clubs, 2 = diamonds, 3 = hearts, 4 = spades)");
    int suit1 = input.nextInt();
    System.out.println("Value of first card in hand? (1 = ace, ..., 11 = jack, 12 = queen, 13 = king)");
    int value1 = input.nextInt();
  
    while (deck.availableCard(suit1, value1) == false) {
      System.out.println("Unavailable Card!");
      System.out.println("Suit of first card in hand? (1 = clubs, 2 = diamonds, 3 = hearts, 4 = spades)");
      suit1 = input.nextInt();
      System.out.println("Value of first card in hand? (1 = ace, ..., 11 = jack, 12 = queen, 13 = king)");
      value1 = input.nextInt();
    }
    yours.draw(suit1, value1);
    deck.remove(suit1, value1);
    
    System.out.println("Suit of second card in hand? (1 = clubs, 2 = diamonds, 3 = hearts, 4 = spades)");
    int suit2 = input.nextInt();
    System.out.println("Value of second card in hand? (1 = ace, ..., 11 = jack, 12 = queen, 13 = king)");
    int value2 = input.nextInt();
  
    while (deck.availableCard(suit2, value2) == false) {
      System.out.println("Unavailable Card!");
      System.out.println("Suit of second card in hand? (1 = clubs, 2 = diamonds, 3 = hearts, 4 = spades)");
      suit2 = input.nextInt();
      System.out.println("Value of second card in hand? (1 = ace, ..., 11 = jack, 12 = queen, 13 = king)");
      value2 = input.nextInt();
    }
    yours.draw(suit2, value2);
    deck.remove(suit2, value2);
    deckSize = deckSize - 2;
    
    
    System.out.println("Suit of first card on field? (1 = clubs, 2 = diamonds, 3 = hearts, 4 = spades)");
    int fieldSuit1 = input.nextInt();
    System.out.println("Value of first card on field? (1 = ace, ..., 11 = jack, 12 = queen, 13 = king)");
    int fieldValue1 = input.nextInt();
    while (deck.availableCard(fieldSuit1, fieldValue1) == false) {
      System.out.println("Unavailable Card!");
      System.out.println("Suit of first card on field? (1 = clubs, 2 = diamonds, 3 = hearts, 4 = spades)");
      fieldSuit1 = input.nextInt();
      System.out.println("Value of first card on field? (1 = ace, ..., 11 = jack, 12 = queen, 13 = king)");
      fieldValue1 = input.nextInt();
    }
    field.draw(fieldSuit1, fieldValue1);
    deck.remove(fieldSuit1, fieldValue1);
    
    System.out.println("Suit of second card on field? (1 = clubs, 2 = diamonds, 3 = hearts, 4 = spades)");
    int fieldSuit2 = input.nextInt();
    System.out.println("Value of second card on field? (1 = ace, ..., 11 = jack, 12 = queen, 13 = king)");
    int fieldValue2 = input.nextInt();
    while (deck.availableCard(fieldSuit2, fieldValue2) == false) {
      System.out.println("Unavailable Card!");
      System.out.println("Suit of second card on field? (1 = clubs, 2 = diamonds, 3 = hearts, 4 = spades)");
      fieldSuit2 = input.nextInt();
      System.out.println("Value of second card on field? (1 = ace, ..., 11 = jack, 12 = queen, 13 = king)");
      fieldValue2 = input.nextInt();
    }
    field.draw(fieldSuit2, fieldValue2);
    deck.remove(fieldSuit2, fieldValue2);
    
    System.out.println("Suit of third card on field? (1 = clubs, 2 = diamonds, 3 = hearts, 4 = spades)");
    int fieldSuit3 = input.nextInt();
    System.out.println("Value of third card on field? (1 = ace, ..., 11 = jack, 12 = queen, 13 = king)");
    int fieldValue3 = input.nextInt();
    while (deck.availableCard(fieldSuit3, fieldValue3) == false) {
      System.out.println("Unavailable Card!");
      System.out.println("Suit of third card on field? (1 = clubs, 2 = diamonds, 3 = hearts, 4 = spades)");
      fieldSuit3 = input.nextInt();
      System.out.println("Value of third card on field? (1 = ace, ..., 11 = jack, 12 = queen, 13 = king)");
      fieldValue3 = input.nextInt();
    }
    field.draw(fieldSuit3, fieldValue3);
    deck.remove(fieldSuit3, fieldValue3);
    
    fieldSize = fieldSize + 3;
    deckSize = deckSize - 3;
    
    //adding all cards from yours and field into yoursNField for easier comparisons
    for (int i = 0; i < yours.handAL.size(); i++) {
      yoursNField.handAL.add(yours.handAL.get(i));
    }
    for (int i = 0; i < field.handAL.size(); i++) {
      yoursNField.handAL.add(field.handAL.get(i));
    }
    
    System.out.println("Enter '0' to see your chances or '1' to draw next field card");
    int skip = input.nextInt();
    if (skip != 1) {
      System.out.println("What hand are you going for? ");
      System.out.println("(0 = Royal Flush, 1 = Straight Flush, 2 = Four of a Kind, 3 = Full House, 4 = Flush, "
          + "5 = Straight, 6 = Three of a Kind, 7 = Two Pairs, 8 = Pair)");
      int handChoice = input.nextInt();
      
      if (handChoice == 2) {
        System.out.println(String.format("%.2f", deck.fourChance(yoursNField, deckSize, fieldSize)) + "% chance of a Four of a Kind");
      }
      
      else if (handChoice == 3) {
        System.out.println(String.format("%.2f", deck.fullHouseChance(yoursNField, deckSize, fieldSize)) + "% chance of a Full House");
      }
      
      else if (handChoice == 6) {
        System.out.println(String.format("%.2f", deck.threeChance(yoursNField, deckSize, fieldSize)) + "% chance of a Three of a Kind");
      }
      
      else if (handChoice == 7) {
        System.out.println(String.format("%.2f", deck.twoPairChance(yoursNField, deckSize, fieldSize)) + "% chance of a Two Pair");
      }
      else if (handChoice == 8) {
        System.out.println(String.format("%.2f", deck.pairChance(yoursNField, deckSize, fieldSize)) + "% chance of a Pair");
      }
      
    }
    
    
    System.out.println("Number of cards left in deck = " + deckSize);
    
    
    System.out.println("Suit of fourth card on field? (1 = clubs, 2 = diamonds, 3 = hearts, 4 = spades)");
    int fieldSuit4 = input.nextInt();
    System.out.println("Value of fourth card on field? (1 = ace, ..., 11 = jack, 12 = queen, 13 = king)");
    int fieldValue4 = input.nextInt();
    while (deck.availableCard(fieldSuit4, fieldValue4) == false) {
      System.out.println("Unavailable Card!");
      System.out.println("Suit of fourth card on field? (1 = clubs, 2 = diamonds, 3 = hearts, 4 = spades)");
      fieldSuit4 = input.nextInt();
      System.out.println("Value of fourth card on field? (1 = ace, ..., 11 = jack, 12 = queen, 13 = king)");
      fieldValue4 = input.nextInt();
    }
    field.draw(fieldSuit4, fieldValue4);
    deck.remove(fieldSuit4, fieldValue4);
    
    fieldSize = fieldSize + 1;
    deckSize = deckSize - 1;
    
    for (int i = 3; i < field.handAL.size(); i++) {
      yoursNField.handAL.add(field.handAL.get(i));
    }
    
    System.out.println("Enter '0' to see your chances or '1' to draw next field card");
    int skip2 = input.nextInt();
    if (skip2 != 1) {
      System.out.println("What hand are you going for? ");
      System.out.println("(0 = Royal Flush, 1 = Straight Flush, 2 = Four of a Kind, 3 = Full House, 4 = Flush, "
          + "5 = Straight, 6 = Three of a Kind, 7 = Two Pairs, 8 = Pair)");
      int handChoice = input.nextInt();
      
      if (handChoice == 2) {
        System.out.println(String.format("%.2f", deck.fourChance(yoursNField, deckSize, fieldSize)) + "% chance of a Four of a Kind");
      }
      
      else if (handChoice == 3) {
        System.out.println(String.format("%.2f", deck.fullHouseChance(yoursNField, deckSize, fieldSize)) + "% chance of a Full House");
      }
      
      else if (handChoice == 6) {
        System.out.println(String.format("%.2f", deck.threeChance(yoursNField, deckSize, fieldSize)) + "% chance of a Three of a Kind");
      }
      
      else if (handChoice == 7) {
        System.out.println(String.format("%.2f", deck.twoPairChance(yoursNField, deckSize, fieldSize)) + "% chance of a Two Pair");
      }
      else if (handChoice == 8) {
        System.out.println(String.format("%.2f", deck.pairChance(yoursNField, deckSize, fieldSize)) + "% chance of a Pair");
      }
      
    }
    
    
    System.out.println("Number of cards left in deck = " + deckSize);
    
    yoursNField.viewHand();
    
    
    input.close();
  }
}
