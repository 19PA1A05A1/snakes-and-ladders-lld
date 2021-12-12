import java.util.*;

public class Game {
    private Queue<Player> players;
    private int noOfPlayers;
    private List<Snake> snakes;
    private List<Ladder> ladders;
    private Board b;
    private Dice d;
    public Game(List<Integer> snakesStart, List<Integer> snakesEnd,List<Integer> laddersStart, List<Integer> laddersEnd, List<String> playersNames){
        snakes = new ArrayList<>();
        //creating a list of snakes from given start and end points
        for(int i = 0; i < snakesStart.size(); i++){
            Snake snake = new Snake(snakesStart.get(i),snakesEnd.get(i));
            snakes.add(snake);
        }

        //creating a list of ladders from given start and end points
        ladders = new ArrayList<>();
        for(int i = 0; i < laddersStart.size(); i++){
            Ladder ladder = new Ladder(laddersStart.get(i),laddersEnd.get(i));
            ladders.add(ladder);
        }

        //creating list of Players
        players = new LinkedList<>();
        for(int i = 0; i < playersNames.size(); i++){
            Player p = new Player(playersNames.get(i));
            players.add(p);
        }
        noOfPlayers = playersNames.size();

        //creating a board
        b = new Board(snakes, ladders);
        //creating a dice
        d = new NormalDice();
    }

    public int getNoOfPlayers(){
        return noOfPlayers;
    }

    public void startGame(){
        Map<Integer,Jumper> jumpers = b.getJumpers();
        int rolledVal, oldPosition, newPosition, finishPoint;
        Player curr;
        finishPoint = b.getFinishPoint();
        while(players.size() != 1){
            //Getting a player from the queue whose turn it is
            curr = players.poll();
            //getting a value by rolling dice
            rolledVal = d.rollDice();
            //adding the value obtained by rolling a dice to player's current position
            oldPosition = curr.getPosition();
            newPosition = oldPosition+rolledVal;

            //checking if there is a jumper at new position so that we can update it
            while(jumpers.containsKey(newPosition)){
                if(jumpers.get(newPosition) instanceof Snake)
                    System.out.println("Oops! Swallowed by a snake");
                else
                    System.out.println("Hurray! Climbing ladder");
                newPosition = jumpers.get(newPosition).getEndPoint();
            }

            //Printing what happened in the current move

            if(newPosition > finishPoint){
                System.out.println("Rolled "+rolledVal +" couldnot move");
                players.add(curr);
            }
            else if(newPosition <= finishPoint){
                //setting the players position to new cell if new position is not more than finishPoint
                curr.setPosition(newPosition);
                //adding the player back to the queue if not reached finishPoint
                System.out.println("Player "+curr.getName()+" rolled "+rolledVal+" and moved from "+oldPosition+" to "+newPosition);
                if(newPosition != finishPoint)
                    players.add(curr);
            }
            if(newPosition == finishPoint){
                System.out.println("Player "+curr.getName()+" won the game.");
                System.out.println(curr.getPath());
            }

        }
        System.out.println("Game is over!");
    }
}
