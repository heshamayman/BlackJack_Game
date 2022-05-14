
package blackjack;

public class Player {
    private final String Name;
    private int Score = 0 ;
    public int count = 0 ;
    public Card player_cards[]=new Card[11];
 
    //put player's name 
        public Player(String Name) {
        this.Name = Name;
    }
    //get private value 
    public String getName() {
        return Name;
    }
    public int getScore() {
        return Score;
    }
    //add new card to the player from his 11 card and add card value to his score 
    public void Add_Card(Card m){
        player_cards[count]= new Card (m);
        count++;
        Score += m.getValue();
    }
}
