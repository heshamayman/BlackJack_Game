package blackjack;

public class Card {
    private final int suit ,rank,value;
    
    
    // constractor for card 
    public Card(int suit, int rank, int value) { 
        this.suit = suit;
        this.rank = rank;
        this.value = value;
    }
    
    // copy constractour 
    
    public Card ( Card Copy_Card){
        this.suit = Copy_Card.suit;
        this.rank = Copy_Card.rank;
        this.value = Copy_Card.value;
    }
//get all private values 
    public int getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    public int getValue() {
        return value;
    }


}

