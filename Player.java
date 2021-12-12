import java.util.*;

public class Player {
    private String name;
    private List<Integer> path;
    private int position;

    public Player(String name){
        this.name = name;
        path = new ArrayList<>();
        position = 0;
    }

    public String getName(){
        return name;
    }

    public int getPosition(){
        return position;
    }

    public void setPosition(int pos){
        position = pos;
        path.add(pos);
    }

    public List<Integer> getPath(){
        return path;
    }
}
