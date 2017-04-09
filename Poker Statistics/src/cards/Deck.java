package cards;

import java.util.ArrayList;

public class Deck {
  
  public ArrayList<Card> deckAL;

  public Deck() {
    deckAL = new ArrayList<Card>();
    for (int suit = 1; suit < 5; suit++) {
      for (int value = 1; value < 14; value++) {
        deckAL.add(new Card(suit, value));
      }
    }
  }
  
  public boolean availableCard(int suitIn, int valueIn) {
    if (suitIn < 1 || suitIn > 4 || valueIn < 1 || valueIn > 13) {
      return false;
    }
    else if (this.aCHelper(suitIn, valueIn) == false) {
      return false;
    }
    else return true;
  }
  
  public boolean aCHelper(int suitIn, int valueIn) {
    boolean answer = false;
    for (int i = 0; i < deckAL.size(); i++) {
      if (deckAL.get(i).getSuit() == suitIn && deckAL.get(i).getValue() == valueIn) {
        answer = true;
      }
    }
    return answer;
  }
  
  public void remove(int suitIn, int valueIn) {
    for (int i = 0; i < deckAL.size() ; i++) {
        if (deckAL.get(i).getSuit() == suitIn && deckAL.get(i).getValue() == valueIn) {
          deckAL.remove(i);
        }
    }
  }
  
  public double chance(int suitIn, int valueIn) {
    double count = 0;
    if (suitIn == 0 && valueIn != 0) {
      for (int i = 0; i < deckAL.size(); i++) {
        if (deckAL.get(i).getValue() == valueIn) {
          count++;
        }
      }
      return count / deckAL.size() * 100;
    }
    else if (valueIn == 0 && suitIn != 0) {
      for (int i = 0; i < deckAL.size(); i++) {
        if (deckAL.get(i).getSuit() == suitIn) {
          count++;
        }
      }
      return count / deckAL.size() * 100;
    }
    else if (suitIn == 0 && valueIn ==0) {
      return count = 100.00;
    }
    else {
      for (int i = 0; i < deckAL.size() ; i++) {
        if (deckAL.get(i).getSuit() == suitIn && deckAL.get(i).getValue() == valueIn) {
          count++;
        }
      }
      return count / deckAL.size() * 100;
    }
  }
  
  public double pairChance(Hand yoursNField, int deckSize, int fieldSize) {
    int count = 0;
    double chance = 0.0;
    for (int i = 0; i < yoursNField.handAL.size(); i++) {
      for (int j = i + 1; j < yoursNField.handAL.size(); j++) {
        if (chance != 100.00 && yoursNField.handAL.get(i).getValue() == yoursNField.handAL.get(j).getValue()) {
          chance = 100.00;
        }
      }
    }
    if (chance != 100.00) {
      for (int i = 0; i < yoursNField.handAL.size(); i++) {
        for (int j = 0; j < deckAL.size(); j++) {
          if (yoursNField.handAL.get(i).getValue() == deckAL.get(j).getValue() && chance != 100.00) {
            count++;
          }
        }
      }
      if (chance != 100.00 && fieldSize == 3) {
        chance = (1.0 - ((1.0 - ((double) count / deckSize)) * (1.0 - ((double) count / (deckSize - 1))))) * 100;
      }
      else if (chance != 100.00 && fieldSize == 4) {
        chance = ((double) count / deckSize) * 100;
      }
    }
    return chance;
  }
  
  public double twoPairChance(Hand yoursNField, int deckSize, int fieldSize) {
    int count = 0;
    double chance = 0.0;
    boolean firstPair = false;
    int firstPairValue = 0;
    
    for (int i = 0; i < yoursNField.handAL.size(); i++) {
      for (int j = i + 1; j < yoursNField.handAL.size(); j++) {
        if (yoursNField.handAL.get(i).getValue() == yoursNField.handAL.get(j).getValue()) {
          firstPair = true;
          firstPairValue = yoursNField.handAL.get(i).getValue();
        }
        if (firstPair == true && firstPairValue != yoursNField.handAL.get(i).getValue() 
            && yoursNField.handAL.get(i).getValue() == yoursNField.handAL.get(j).getValue()) {
          chance = 100.00;
        }
      }
    }
        
    if (chance != 100.00 && firstPair == false) {
      for (int i = 0; i < yoursNField.handAL.size(); i++) {
        for (int j = 0; j < deckAL.size(); j++) {
          if (yoursNField.handAL.get(i).getValue() == deckAL.get(j).getValue()) {
            count++;
          }
        }
      }
    }
    
    if (chance != 100.00 && fieldSize == 3 && firstPair == false) {
      chance = ((double) count / deckSize) * ((double) (count - 3) / (deckSize - 1)) * 100;
    }
    else if (chance != 100.00 && fieldSize == 3 && firstPair == true) {
      chance = (1.0 - ((1.0 - ((double) 9 / deckSize)) * (1.0 - ((double) 12 / (deckSize - 1))))) * 100;
    }
    else if (chance != 100.00 && fieldSize == 4 && firstPair == true) {
      chance = (double) 12 / deckSize; 
    }
    
    return chance;
  }
  
  public double threeChance(Hand yoursNField, int deckSize, int fieldSize) {
  
    double chance = 0.0;
    boolean firstPair = false;
    int firstPairValue = 0;
    
    for (int i = 0; i < yoursNField.handAL.size(); i++) {
      for (int j = i + 1; j < yoursNField.handAL.size(); j++) {
        if (yoursNField.handAL.get(i).getValue() == yoursNField.handAL.get(j).getValue()) {
          if (firstPair == true && firstPairValue == yoursNField.handAL.get(i).getValue() 
              && yoursNField.handAL.get(i).getValue() == yoursNField.handAL.get(j).getValue()) {
            chance = 100.00;
          }
          firstPair = true;
          firstPairValue = yoursNField.handAL.get(i).getValue();
        }
      }
    }
        
    if (chance != 100.00 && fieldSize == 3 && firstPair == false) {
      chance = ((double) 15 / deckSize) * ((double) (2) / (deckSize - 1)) * 100;
    }
    else if (chance != 100.00 && fieldSize == 3 && firstPair == true) {
      chance = (1.0 - ((1.0 - ((double) 2 / deckSize)) * (1.0 - ((double) 2 / (deckSize - 1))))) * 100;
    }
    else if (chance != 100.00 && fieldSize == 4 && firstPair == true) {
      chance = (double) 2 / deckSize;
    }
    return chance;
    
  }

  public double fourChance(Hand yoursNField, int deckSize, int fieldSize) {
    
    double chance = 0.0;
    int count = 0;
    for (int i = 0, j = 1; j < yoursNField.handAL.size(); j++) {
      if(yoursNField.handAL.get(i).getValue() == yoursNField.handAL.get(j).getValue()) {
        count++;
      }
    }
    if(threeChance(yoursNField, deckSize, fieldSize) == 100 && count == 3) {
      chance = 100.00;
    }
    
    if (chance != 100.00 && fieldSize == 3 && pairChance(yoursNField, deckSize, fieldSize) == 100 
        && threeChance(yoursNField, deckSize, fieldSize) != 100) {
      chance = ((double) 2 / deckSize) * ((double) (1) / (deckSize - 1)) * 100;
    }
    else if (chance != 100 && fieldSize == 3 && threeChance(yoursNField, deckSize, fieldSize) != 100 
        && twoPairChance(yoursNField, deckSize, fieldSize) == 100) {
      chance = ((double) 4 / deckSize) * (1 / (deckSize - 1));
    }
    else if(chance != 100 && fieldSize == 3 && threeChance(yoursNField, deckSize, fieldSize) == 100 
            && twoPairChance(yoursNField, deckSize, fieldSize) == 100){
      chance = ((1.0 - ((1.0 - ((double) 1 / deckSize)) * (1.0 - ((double) 1 / (deckSize - 1))))) 
          + ((double) 2 / deckSize) * ((double) (1) / (deckSize - 1))) * 100;
    }
    else if(chance != 100 && fieldSize == 3 && threeChance(yoursNField, deckSize, fieldSize) == 100 
        && twoPairChance(yoursNField, deckSize, fieldSize) != 100){
      chance = (1.0 - ((1.0 - ((double) 1 / deckSize)) * (1.0 - ((double) 1 / (deckSize - 1))))) * 100;
    }
    
    else if(chance != 100 && fieldSize == 4 && threeChance(yoursNField, deckSize, fieldSize) == 100){
      chance = ((double) 1 / deckSize) * 100;
    }
    
    return chance;
    
  }

  public double fullHouseChance(Hand yoursNField, int deckSize, int fieldSize)
  {
     double chance = 0.0;
     boolean firstPair = false;
     int firstPairValue = 0;
     
     for (int i = 0; i < yoursNField.handAL.size(); i++) {
       for (int j = i + 1; j < yoursNField.handAL.size(); j++) {
         if (yoursNField.handAL.get(i).getValue() == yoursNField.handAL.get(j).getValue()) {
           if (firstPair == true && firstPairValue == yoursNField.handAL.get(i).getValue() 
               && yoursNField.handAL.get(i).getValue() == yoursNField.handAL.get(j).getValue()) {
             chance = 100.00;
           }
           firstPair = true;
           firstPairValue = yoursNField.handAL.get(i).getValue();
         }
       }
     }
         
     if (chance != 100.00 && fieldSize == 3 && firstPair == true) {
      chance = ( ((double) 3 / deckSize) * ((double) (2) / (deckSize - 1)) 
          + ((double) (5) / (deckSize)) * ((double) (2) / (deckSize - 1))
          + ((double) (5) / (deckSize)) * ((double) (3) / (deckSize - 1)) ) * 100;
     }
     else if (twoPairChance(yoursNField, deckSize, fieldSize) == 100) {
        chance = (1.0 - ((1.0 - ((double) 4 / deckSize)) * (1.0 - ((double) 4 / (deckSize - 1))))) * 100;
     }
     else if ( fourChance( yoursNField, deckSize, fieldSize) == 100) {
       System.out.println("Four of a kind is better ! ");
     }
     return chance;
     
  }
  
}
