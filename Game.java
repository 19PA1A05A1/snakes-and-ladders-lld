import java.util.*;

public class Game {
    private Queue<Player> players;
    private int noOfPlayers;
    private Board b;
    private Dice d;
    public Game(int n){
        //initialsing queue of Players
        players = new LinkedList<>();
        //creating a board
        b = new Board();
        //creating a dice
        d = new NDice(n);
        
    }

    public void setSnakesAndLadders(List<Integer> snakesStart, List<Integer> snakesEnd,List<Integer> laddersStart, List<Integer> laddersEnd){
        b.initialzeBoard(snakesStart, snakesEnd, laddersStart, laddersEnd);
    }

    public void setPlayers(List<String> playersNames){
        for(int i = 0; i < playersNames.size(); i++){
            Player p = new Player(playersNames.get(i));
            players.add(p);
        }
        noOfPlayers = playersNames.size();
    }

    public int getNoOfPlayers(){
        return noOfPlayers;
    }

    boolean isGameOver(){
        return players.size() == 1;
    }

    public void startGame(){
        int rolledVal, oldPosition, newPosition, finishPoint;
        Player curr;
        finishPoint = b.getFinishPoint();
        while(!isGameOver()){
            //Getting a player from the queue whose turn it is
            curr = players.poll();
            //getting a value by rolling dice
            rolledVal = d.rollDice();
            //adding the value obtained by rolling a dice to player's current position
            oldPosition = curr.getPosition();
            newPosition = oldPosition+rolledVal;

            //Printing what happened in the current move

            if(newPosition > finishPoint){
                System.out.println("Rolled "+rolledVal +" couldnot move");
                players.add(curr);
                continue;
            }
            else if(newPosition < finishPoint){
                //setting the players position to new cell if new position is not more than finishPoint
                curr.setPosition(newPosition);
                //adding the player back to the queue if not reached finishPoint
                System.out.println("Player "+curr.getName()+" rolled "+rolledVal+" and moved from "+oldPosition+" to "+newPosition);
                players.add(curr);
            }
            else{
                System.out.println("Player "+curr.getName()+" rolled "+rolledVal+" and moved from "+oldPosition+" to "+newPosition);
                System.out.println("Player "+curr.getName()+" won the game.");
                System.out.println(curr.getPath());
            }


            //checking if there is a jumper at new position so that we can update it
            int jumpVal = b.getJumpVal(newPosition);
            while(jumpVal != -1){
                if(jumpVal < newPosition)
                    System.out.println("Oops! Swallowed by a snake, going down from "+newPosition+" to "+jumpVal);
                else
                    System.out.println("Hurray! Climbing ladder from "+newPosition+" to "+jumpVal);
                newPosition = jumpVal;
                curr.setPosition(newPosition);
                jumpVal = b.getJumpVal(newPosition);
            }

            
        }
        System.out.println("Game is over!");
    }
}