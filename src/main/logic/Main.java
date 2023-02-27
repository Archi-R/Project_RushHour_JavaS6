package logic;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("Rush hour game");
        System.out.println("Choose a difficulty : (beginner,intermediate,advanced,expert,grandmaster)");
        Difficulty difficulty = Difficulty.beginner; // default difficulty
        //TODO : wait for user input and add it in difficulty

        System.out.println("Choose a level"); //TODO : return the level number in the selected difficulty for the player
        int level = 1; //default level
        //TODO : wait for user input and add it in level

        Config config = new Config(difficulty,level);
        Board board = new Board(difficulty,config);
        board.initiate(); // load the configuration

    }
}