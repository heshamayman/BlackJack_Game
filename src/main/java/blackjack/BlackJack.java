package blackjack;
import java.util.Scanner;
public class BlackJack {
    static int num;
    static int count_blac_jack = 0;
    static int count_maxscore = 0;
    static Game game1 = new Game();
    public static void main(String[] args) {
        game1.generates();
        game1.player_information();
        game1.Max_Score();
        GUI gui = new GUI();
        gui.runGUI(game1.deck, game1.players[0].player_cards, game1.players[1].player_cards, game1.players[2].player_cards, game1.players[3].player_cards);
        for (int i = 0; i < 4; i++) {
            if (i != 3) {
                System.out.println(game1.players[i].getName() + ",Please Enter Your Choice :");
                System.out.println("1-Hit");
                System.out.println("2-Stand");
                Scanner n_scan = new Scanner(System.in);
                num = n_scan.nextInt();
                while (num != 1 && num != 2) {
                    System.out.println("NOT VALIED");
                    System.out.println("----------------------");
                    System.out.println(game1.players[i].getName() + ",Please Enter Your Choice :");
                    System.out.println("1-Hit");
                    System.out.println("2-Stand");
                    num = n_scan.nextInt();}
                while (num == 1) {
                    game1.players[i].Add_Card(game1.Random_Card());
                    game1.Max_Score();
                    gui.updatePlayerHand(game1.players[i].player_cards[game1.players[i].count - 1], i);
                    if (game1.players[i].getScore() < 21) {
                        System.out.println(game1.players[i].getName() + " , Please Enter Your Choice :");
                        System.out.println("1-Hit");
                        System.out.println("2-Stand");
                        num = n_scan.nextInt();
                    } else {
                        break;}}}
            if (i == 3) {
                System.out.println(" Dealar is run ");
                while (true) {
                    if (game1.players[3].getScore() < 21 && game1.players[3].getScore() < game1.max_score) {
                        System.out.println("ok");
                        game1.players[i].Add_Card(game1.Random_Card());
                        gui.updateDealerHand(game1.players[i].player_cards[game1.players[i].count - 1], game1.deck);} 
                    else {
                        break;}}}
        } game1.Max_Score();
        for (int c = 0; c < 4; c++) {
            if (game1.players[c].getScore() == 21) {
                count_blac_jack++;
            } else if (game1.players[c].getScore() == game1.max_score) {
                count_maxscore++; }}
        if (count_blac_jack == 0 && game1.players[0].getScore() == game1.max_score && count_maxscore == 1) {
            System.out.println(game1.players[0].getName() + " WIN !");
        } else if (count_blac_jack == 0 && game1.players[1].getScore() == game1.max_score && count_maxscore == 1) {
            System.out.println(game1.players[1].getName() + " WIN !");
        } else if (count_blac_jack == 0 && game1.players[2].getScore() == game1.max_score && count_maxscore == 1) {
            System.out.println(game1.players[2].getName() + " WIN !");
        } else if (count_blac_jack == 0 && game1.players[3].getScore() == game1.max_score && count_maxscore == 1) {
            System.out.println(game1.players[3].getName() + " WIN !");} //////////////////////// black jack
        else if (count_blac_jack == 1 && game1.players[0].getScore() == 21) {
            System.out.println(game1.players[0].getName() + " Black Jack !");
        } else if (count_blac_jack == 1 && game1.players[1].getScore() == 21) {
            System.out.println(game1.players[1].getName() + " Black Jack !");
        } else if (count_blac_jack == 1 && game1.players[2].getScore() == 21) {
            System.out.println(game1.players[2].getName() + " Black Jack !");
        } else if (count_blac_jack == 1 && game1.players[3].getScore() == 21) {
            System.out.println(game1.players[3].getName() + " Black Jack !");
        } else if (count_blac_jack > 1 || count_maxscore > 1) {
            System.out.println(" TIE ");
        } else {
            System.out.println("  No One Win !!  ");}}}
