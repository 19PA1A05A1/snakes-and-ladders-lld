import java.util.Random;

public class NormalDice implements Dice{
    Random r;
    public NormalDice(){
        r = new Random();
    }

    public int rollDice(){
        return r.nextInt(6)+1;
    }

    public int getMinRollVal(){
        return 1;
    }
}
