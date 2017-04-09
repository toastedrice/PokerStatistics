package cards;

public class Card {

  public int suit;
  public int value;
  
  //for suits, 1 = clubs, 2 = diamonds, 3 = hearts, 4 = spades
  //for value 1 = ace, ..., 11 = jack, 12 = queen, 13 = king
  public Card(int suitIn, int valueIn) {
    suit = suitIn;
    value = valueIn;
  }
  
  public int getSuit() {
    return suit;
  }
  
  public int getValue() {
    return value;
  }
  
  public String suitName() {
    String answer = "";
    if (suit == 1) {
      answer = "Clubs";
    }
    else if (suit == 2) {
      answer = "Diamonds";
    }
    else if (suit == 3) {
      answer = "Hearts";
    }
    else {
      answer = "Spades";
    }
    return answer;
  }
  
  public String valueName() {
    String answer = "";
    if (value == 1) {
      answer = "Ace";
    }
    else if (value == 11) {
      answer = "Jack";
    }
    else if (value == 12) {
      answer = "Queen";
    }
    else if (value == 13) {
      answer = "King";
    }
    else {
      answer = "" + this.getValue();
    }
    return answer;
  }
  
}
