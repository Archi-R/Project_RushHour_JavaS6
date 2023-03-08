package logic;

import graphic.Window;

import javax.lang.model.element.Name;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        Scanner sc = new Scanner(System.in);
        System.out.println("Rush hour game");
        System.out.println("Choose a difficulty : (beginner,intermediate,advanced,expert,grandmaster)");
        Difficulty difficulty = Difficulty.todiff(sc.nextLine());
        System.out.println(difficulty);

        System.out.println("Choose a level"); //TODO : return the level number in the selected difficulty for the player
        int level = Integer.parseInt(sc.nextLine());

        Config config = new Config(difficulty,level);
        Board board = new Board(difficulty,config);
        board.initiate(); // load the configuration
        */
        Board board = new Board(Difficulty.beginner, new Config(Difficulty.beginner, 1));
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Window w = new Window(board);

            }
        });

//        boolean victory = board.getCell(2, 5).getVehicle().getNameColor() == NameColor.X;
//        while(!victory) //while the car on the "win" cell isn't the red car
//        {
//            // main game
//        }
    }
}