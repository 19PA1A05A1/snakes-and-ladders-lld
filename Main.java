import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        //input for snakes with their starting and ending points
        int noOfSnakes = scanner.nextInt();
        List<Integer> snakesStart = new ArrayList<>();
        for(int i = 0; i < noOfSnakes; i++)
            snakesStart.add(scanner.nextInt());
        List<Integer> snakesEnd = new ArrayList<>();
        for(int i = 0; i < noOfSnakes; i++)
            snakesEnd.add(scanner.nextInt());

        //input for ladders with their starting and ending points
        int noOfLadders = scanner.nextInt();   
        List<Integer> laddersStart = new ArrayList<>();
        for(int i = 0; i < noOfLadders; i++)
            laddersStart.add(scanner.nextInt());
        List<Integer> laddersEnd = new ArrayList<>();
        for(int i = 0; i < noOfLadders; i++)
            laddersEnd.add(scanner.nextInt());


        //Taking input for number of players and their details
        //Storing all PlayersNames in a list 
        int p = scanner.nextInt();
        List<String> playersNames = new ArrayList<>();
        for(int i = 0; i < p; i++)
            playersNames.add(scanner.next());

        Game g = new Game(snakesStart,snakesEnd,laddersStart,laddersEnd,playersNames);
        g.startGame();


        scanner.close();
    }
}
