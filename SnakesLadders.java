import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Random;

public class SnakesLadders {
    private int position;
    Map<Integer, Integer> snakes = new HashMap<>();
    Map<Integer, Integer> ladders = new HashMap<>();

    Random random = new Random();

//    @desc: constructor for initialising positions
    public SnakesLadders(){
        this.position=0;
    }

//    @desc: generate snakes
//    @params: no. of snakes to be generated
    public void setSnakes(int cnt){
        for (int i = 0; i < cnt ; i++){
            int v1 = random.nextInt(100)+1;
            int v2 = random.nextInt(100)+1;
            if(v1>v2){
                snakes.put(v1,v2);
            }
            else{
                snakes.put(v2,v1);
            }
        }
    }

//    @desc: generate snakes
//    @params: no. of ladders to be generated
    public void setLadders(int cnt){
        for (int i = 0; i < cnt ; i++) {
            int v1 = random.nextInt(100)+1;
            int v2 = random.nextInt(100)+1;
            if(v1>v2){
                ladders.put(v2,v1);
            }
            else{
                ladders.put(v1,v2);
            }
        }
    }

//    @desc: provide roll dice
//    @params: none
//    @return: int
    public int rollDice(){
        return random.nextInt(6)+1;
    }

//    @desc: player moves or not
//    @params: none
//    @return: void
    public void playerMove(){
        int val=random.nextInt(2);
        if(val==0){
            System.out.println("Player Decided not to move");
        }
        else{
            int dice = rollDice();
            position = position + dice;
            if(snakes.containsKey(position)){
                System.out.print("Snake: ");
                position = snakes.get(position);
            }
            else if(ladders.containsKey(position)){
                System.out.print("Ladder: ");
                position = ladders.get(position);
            }
            else{
                System.out.print("Normal: ");
            }
            System.out.println("Position = "+this.position);
        }
    }
}
