import java.util.Random;

abstract public class Dice {
    private int minVal;
    private int maxVal;
    Random r;
    public int getMinVal(){
        return minVal;
    }

    public int getMaxVal(){
        return maxVal;
    }

    public void setMinVal(int minVal){
        this.minVal = minVal;
    }

    public void setMaxVal(int maxVal){
        this.maxVal = maxVal;
    }

    abstract public int rollDice();
}
