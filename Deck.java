//import はmainクラスだけでなくサブクラスでも記載する必要があるみたい
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

class Deck{
  static final int trump_size=52;
  private boolean[] trump;
  public Deck(){
    trump = new boolean[trump_size];
    for(int i =0;i < trump_size;i++){
      trump[i] =true;
    }
  }
  /**
  * deal メソッド
  * ランダムに引いたカードの数を返す
  * 返り値 引いたカードの数
  */
  public int deal(){
    Random rnd1 = new Random();
    int ran1;
    do{
      ran1 = rnd1.nextInt(52);//0~51までの数字がランダムにran1に格納される
    }while(trump[ran1] != true);
    trump[ran1]= false;
    return ran1;
  }
}

