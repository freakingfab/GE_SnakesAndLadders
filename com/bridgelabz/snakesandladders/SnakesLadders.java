package com.bridgelabz.snakesandladders;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SnakesLadders {
    private int position;
    private int diceCount;
    private int playerNo;
    Map<Integer, Integer> snakes = new HashMap<>();
    Map<Integer, Integer> ladders = new HashMap<>();

    Random random = new Random();

//    @desc: constructor for initialising positions
//    @params: player number
//    @return: none
    public SnakesLadders(int val){
        this.position=0;
        this.diceCount=0;
        this.playerNo=val;
    }

    /*
    @desc: getter for the variables
    @params: none
    @return int
     */
    public int getPosition(){
        return position;
    }
    public int getDiceCount(){
        return diceCount;
    }

//    @desc: generate snakes
//    @params: no. of snakes to be generated
    public void setSnakes(int cnt){
        for (int i = 0; i < cnt ; i++){
            int v1 = random.nextInt(100)+1;
            int v2 = random.nextInt(100)+1;
            if(v1>v2 && v1!=100){
                snakes.put(v1,v2);
            }
            else if(v2>v1 && v2!=100){
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
        diceCount= diceCount + 1;
        if(val==0){
            System.out.println("Player " + this.playerNo +  ": Decided not to move");
        }
        else{
            int dice = rollDice();
            if(!checkMove(dice)){
                System.out.println("Player " + this.playerNo +  ": Invalid Dice Roll");
                return;
            }
            position = position + dice;
            if(snakes.containsKey(position)){
                System.out.print("Player " + this.playerNo +  ": Snake: ");
                position = snakes.get(position);
            }
            else if(ladders.containsKey(position)){
                System.out.print("Player " + this.playerNo +  ": Ladder: ");
                position = ladders.get(position);
            }
            else{
                System.out.print("Player " + this.playerNo +  ": Normal: ");
            }
            System.out.println("Position = "+this.position);
        }
    }

//    @desc: check feasibility for movement
//    @params: dice val(int)
//    @return: boolean
    public boolean checkMove(int dice){
        if(this.position + dice >100 || this.position<0){
            return false;
        }
        return true;
    }


}
