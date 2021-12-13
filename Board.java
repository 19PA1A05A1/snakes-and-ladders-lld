import java.util.*;

public class Board {
    private int finishPoint;
    private Map<Integer,Jumper> jumpers;

    public Board(){
        finishPoint = 100;
        jumpers = new HashMap<>();
    }

    public Board(int finishPoint){
        this.finishPoint = finishPoint;
        jumpers = new HashMap<>();
    }

    public void initialzeBoard(List<Integer> snakesStart, List<Integer> snakesEnd, List<Integer> laddersStart, List<Integer> laddersEnd){
        //creating snakes objects from given start and end points and adding to hashmap
        for(int i = 0; i < snakesStart.size(); i++){
            Snake snake = new Snake(snakesStart.get(i),snakesEnd.get(i));
            jumpers.put(snake.getStartPoint(),snake);
        }
        //creating ladders objects from given start and end points and adding to hashmap
        for(int i = 0; i < laddersStart.size(); i++){
            Ladder ladder = new Ladder(laddersStart.get(i),laddersEnd.get(i));
            jumpers.put(ladder.getStartPoint(),ladder);
        }
    }

    public int getFinishPoint(){
        return finishPoint;
    }

    public Map<Integer,Jumper> getJumpers(){
        return jumpers;
    }

    public boolean isThereJumper(int pos){
        return jumpers.containsKey(pos);
    }

    public int getJumpVal(int pos){
        if(this.isThereJumper(pos))
            return jumpers.get(pos).getEndPoint();
        else
            return -1;
    }

}
