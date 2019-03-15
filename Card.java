import java.util.Random;
import java.util.ArrayList;
import java.util.List;
//player_card ,dealer_card 両方に使えるクラスを作る
class Card{
  List<Integer> card;
  public Card(){
    card = new ArrayList<Integer>();//playerのカードが格納されるList
  }

  public void show_card(){
    for(int i =0; i < card.size() ; i++){
      card_no_mark(card.get(i));
    }
  }

  /**
  * dealer_show_card メソッド
  * dealer の持ちカードを表示する
  * ただし Hole Card は表示しない
  */
  public void dealer_show_card(){
    System.out.println("Hole Card");
    for(int i =1; i < card.size() ; i++){//i = 1 と
      card_no_mark(card.get(i));
    }
  }

  /**
  * card_no_mark メソッド
  * トランプのナンバー、マークを表示する
  *  number には 1-13 までが格納される
  *  mark_num には 0-3までが格納される
  */
  public void card_no_mark(int card_no_mark){
    int number = card_no_mark % 13 +1;
    int mark_num = card_no_mark % 4;
    String mark[] = {"❤️ ", "♣️ ", "♦️ ","♠️ "};
    System.out.println(mark[mark_num ]+":"+number);
  }

  /**
  * point_card メソッド
  * 持ちカードのポイントを表示する
  * とりあえずAは1とカウント(後で場合分けして修正)
  * 返り値はポイント数
  */
  public int point_card(){
    int point = 0;
    for(Integer i : card){
      int mark_num =  i % 13 + 1;
      if(mark_num < 10){
        point += mark_num;
      }else{
        point += 10;
      }
    }
    return point;
  }
}
