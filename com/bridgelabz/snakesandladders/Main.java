package com.bridgelabz.snakesandladders;

public class Main {
    public static void main(String[] args){
        System.out.println("Welcome to Snakes and Ladders Game");

        SnakesLadders player1 = new SnakesLadders(1);
        player1.setLadders(15);
        player1.setSnakes(15);

        SnakesLadders player2 = new SnakesLadders(2);
        player2.snakes=player1.snakes;
        player2.ladders=player1.ladders;

        while(player1.getPosition()!=100 && player2.getPosition()!=100){
            player1.playerMove();
            if(player1.getPosition()==100){
                break;
            }
            player2.playerMove();
        }
        if(player1.getPosition()==100){
            System.out.println("Player 1 Wins");
        }
        else{
            System.out.println("Player 2 Wins");
        }

        System.out.println("Player 1 Dice Count: "+ player1.getDiceCount());
        System.out.println("Player 2 Dice Count: "+ player2.getDiceCount());
    }
}
