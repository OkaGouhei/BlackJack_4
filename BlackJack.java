import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class BlackJack{

  public static void main(String[] args) {

    Deck a;
    a = new Deck();

    Card player;
    player = new Card();
    Card dealer;
    dealer = new Card();

    System.out.println("playerのカード");
    player.card.add(a.deal());
    player.card.add(a.deal());

    player.show_card();

    System.out.println("dealerのカード");
    dealer.card.add(a.deal());
    dealer.card.add(a.deal());

    dealer.dealer_show_card();

    int draw;
    Scanner scan = new Scanner(System.in);
    do{
      System.out.print("カードを引きますか？ (yes 0/no 1)");
      draw = scan.nextInt();
      if (draw == 0){
        System.out.println("カードを引きます");
        int i = a.deal();
        player.card.add(i);
        player.card_no_mark(i);//引いたカードを表示
      } else if(draw == 1){
        System.out.println("カードを引きません");
      }
      else {
        System.out.println("もう一度お願いします");
      }
    }while(draw != 1 && player.point_card() <= 21);//1 を選択しない限り繰り返します

    scan.close();//scanner は閉じる習慣をつける
    //現在のカードを見せる
    System.out.println("playerのカードは");
    player.show_card();
    if (player.point_card() > 21){
      System.out.println("playerはバーストしました");
    }else{
      System.out.println("playerのポイントは"+player.point_card());
    }
    //dealer のカード 17以上になるまでカードを引く
    while(dealer.point_card() < 17){
      dealer.card.add(a.deal());
    }
    System.out.println("dealerのカードは");
    dealer.show_card();
    if (dealer.point_card() > 21){
      System.out.println("dealerはバーストしました");
    }else{
      System.out.println("dealerのポイントは"+dealer.point_card());
    }
    //勝敗を決定する
    if(player.point_card() > 21){
      System.out.println("dealer の勝ちです");
    }else if (dealer.point_card()>21 || player.point_card()> dealer.point_card()){
      System.out.println("player の勝ちです");
    }else if (player.point_card()< dealer.point_card()){
      System.out.println("dealer の勝ちです");
    }else{
      System.out.println("引き分けです");
    }

  }

}
