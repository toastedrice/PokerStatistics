package cards;

import java.util.ArrayList;

public class Hand {

  public ArrayList<Card> handAL;
  
  public Hand() {
    handAL = new ArrayList<Card>();
  }
  
  public void viewHand() {
    String answer = "";
    for (int i = 0; i < handAL.size(); i++) {
      answer = answer + (i + 1) + " (" + handAL.get(i).valueName() + " of "+ handAL.get(i).suitName() + ") ";
    }
    System.out.println(answer);
  }
  
  public void draw(int suitIn, int valueIn) {
    handAL.add(new Card(suitIn, valueIn));
  }
}
