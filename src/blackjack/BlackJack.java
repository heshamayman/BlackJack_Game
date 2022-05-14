
package blackjack;


import java.util.Scanner;

public class BlackJack {
    static int num;
    static Game game1 = new Game();

    public static void main(String[] args) {

        game1.generates();
        game1.player_information();
        for (int i = 0; i < 4; i++) {
            if (i != 3) {
                System.out.println( game1.players[i].getName()+ ",Please Enter Your Choice :");
                System.out.println("1-Hit");
                System.out.println("2-Stand");
                Scanner n_scan = new Scanner(System.in);
                num = n_scan.nextInt();
                while (num != 1 && num != 2) {
                    System.out.println("NOT VALIED");
                    System.out.println("----------------------");
                    System.out.println(game1.players[i].getName()+ ",Please Enter Your Choice :");
                    System.out.println("1-Hit");
                    System.out.println("2-Stand");

                    num = n_scan.nextInt();
                }
                while (num == 1) {
                    game1.players[i].Add_Card(game1.Random_Card());


                    if (game1.players[i].getScore() < 21) {
                        System.out.println( game1.players[i].getName()+ ",Please Enter Your Choice :");
                        System.out.println("1-Hit");
                        System.out.println("2-Stand");

                        num = n_scan.nextInt();
                    } else {
                        break;
                    }
                }
            }
        }
    }
}
