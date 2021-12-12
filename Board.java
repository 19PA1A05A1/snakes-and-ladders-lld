import java.util.*;

public class Board {
    private int finishPoint;
    private Map<Integer,Jumper> jumpers;

    public Board(List<Snake> snakes, List<Ladder> ladders){
        finishPoint = 100;
        jumpers = new HashMap<>();
        for(Snake s: snakes){
            jumpers.put(s.getStartPoint(),s);
        }
        for(Ladder l:ladders){
            jumpers.put(l.getStartPoint(),l);
        }
    }

    public int getFinishPoint(){
        return finishPoint;
    }

    public Map<Integer,Jumper> getJumpers(){
        return jumpers;
    }

}
