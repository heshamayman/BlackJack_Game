
package blackjack;

public class Player {
    private final String Name;
    private int Score = 0 ;
    private int count = 0 ;
    public Card player_cards[]=new Card[11];

    public Player(String Name) {
        this.Name = Name;
    }
    public String getName() {
        return Name;
    }
    public int getScore() {
        return Score;
    }
    public void Add_Card(Card m){
        player_cards[count]= new Card (m);
        count++;
        Score += m.getValue();
    }
}
