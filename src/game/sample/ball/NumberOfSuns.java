package game.sample.ball;

public class NumberOfSuns {

    public static int amount = 350 ;

     public NumberOfSuns(){}

     public void increment(int num){
        amount += num;
    }

    public void decrement(int num){
        amount -= num;
    }
}
