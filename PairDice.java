import java.util.Random;

public class PairDice extends Dice{
    public PairDice(){
        r = new Random();
    }
    public int rollDice(){
        return r.nextInt(11)+2;
    }
}
