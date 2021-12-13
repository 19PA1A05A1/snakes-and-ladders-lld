import java.util.Random;

public class NormalDice extends Dice{
    public NormalDice(){
        this.r = new Random();
    }

    public int rollDice(){
        return r.nextInt(6)+1;
    }

}
