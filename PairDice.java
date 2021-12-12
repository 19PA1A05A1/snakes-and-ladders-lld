import java.util.Random;

public class PairDice implements Dice{
    Random r;
    public PairDice(){
         r = new Random();
    }
    public int rollDice(){
        return r.nextInt(11)+2;
    }
    public int getMinRollVal(){
        return 2;
    }
}
