import java.util.*;

public class NDice extends Dice{
    private int noOfDices;
    public NDice(int n){
        r = new Random();
        noOfDices = n;
        this.setMinVal(n);
        this.setMaxVal(6*n);
    } 

    public int rollDice(){
        return r.nextInt(this.getMaxVal()-this.noOfDices)+noOfDices;
    }

}
