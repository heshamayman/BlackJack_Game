
package blackjack;
import java.util.Random;
import java.util.Scanner;

public class Game {
    public Player players[] = new Player[4];
    public Card deck[] = new Card[52];
    private int max_score = 0;
    Scanner n_scan = new Scanner(System.in);
    //first function that generates the card deck array]

    public void generates() {
        int Counter_Cards = 0;
        for (int suit = 0; suit < 4; suit++) {
            for (int rank = 0; rank < 13; rank++) {
                if (rank <= 9) {
                    deck[Counter_Cards] = new Card(suit, rank, rank + 1);
                } else if (rank >= 10) {
                    deck[Counter_Cards] = new Card(suit, rank, 10);
                }
                Counter_Cards++;
            }
        }
    }

    //end of first function that generates the card deck array]
    public Card Random_Card() {
        Random rand = new Random();
        int randomChoice = rand.nextInt(52);
        if (deck[randomChoice] == null) {
            return this.Random_Card();
        } else {
            Card returned_card = new Card(deck[randomChoice]);
            deck[randomChoice] = null;
            return returned_card;
        }

    }

    public void player_information() {
        for (int i = 0; i < 3; i++) {
            Scanner Scan_Name = new Scanner(System.in);
            String Name_ = Scan_Name.next();
            players[i] = new Player(Name_);
            players[i].Add_Card(Random_Card());
            players[i].Add_Card(Random_Card());
        }
        players[3] = new Player("Dealer");
        players[3].Add_Card(Random_Card());
        players[3].Add_Card(Random_Card());

    }
    public void Max_Score(){
        for(int i =0 ; i<3;i++){
            if(players[i].getScore()>max_score){
                max_score=players[i].getScore();
            }
        }
    }

}


