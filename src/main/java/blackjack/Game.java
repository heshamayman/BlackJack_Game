package blackjack;

import java.util.Random;
import java.util.Scanner;

public class Game {

    public Player players[] = new Player[4];                                    // array object from player calss which has 4 player 
    public Card deck[] = new Card[52];                                          // array object from  card class with 52 card 
    public int max_score = 0;                                                   // initial value to max_score = 0
    Scanner n_scan = new Scanner(System.in);                                    // object from scanner class

    //first function that put suit and rand and value for each card 
    public void generates() {
        int Counter_Cards = 0;                                                  //count num of cards deck[counter] >> 52 
        for (int suit = 0; suit < 4; suit++) {                                  // loop to put the 4 suit                    
            for (int rank = 0; rank < 13; rank++) {                             // rank from 0 to 12 // 0  to ace 12 to king 
                if (rank <= 9) {
                    deck[Counter_Cards] = new Card(suit, rank, rank + 1);
                } else if (rank >= 10) {                                        // any card equal or above 10 the value = 10 
                    deck[Counter_Cards] = new Card(suit, rank, 10);
                }
                Counter_Cards++;
            }
        }
    }

    //end of first function that generates the card deck array]
    public Card Random_Card() {                                                  //function to get a random card 
        Random rand = new Random();                                              //  new object from Random 
        int randomChoice = rand.nextInt(52);                                     // random card for [0,52) 
        if (deck[randomChoice] == null) {                                        // put the random num in index of deck and check if it = null
            return this.Random_Card();                                           // if it equal null repeat the function 
        } else {
            Card returned_card = new Card(deck[randomChoice]);                   // card take the copy card which choised and but it in real card 
            deck[randomChoice] = null;                                           // make the chosen card =  null
            return returned_card;
        }

    } //end of random_card function

// function to get player name and the first 2 card with random_card function
// player[3] >> dealer
    public void player_information() {
        for (int i = 0; i < 3; i++) {
            Scanner Scan_Name = new Scanner(System.in);

            System.out.println("Please Enter Player " + (i + 1) + " Name :");
            String Name_ = Scan_Name.next();
            players[i] = new Player(Name_);
            players[i].Add_Card(Random_Card());
            players[i].Add_Card(Random_Card());

        }
        players[3] = new Player("Dealer");
        players[3].Add_Card(Random_Card());
        players[3].Add_Card(Random_Card());

    }

    // function to check the max  score
    // check every player's score to get the max_score
    // update the max score
    public void Max_Score() {
        for (int i = 0; i < 4; i++) {
            if (players[i].getScore() > max_score && players[i].getScore() <= 21) {
                max_score = players[i].getScore();
            }
        }

    }
}
