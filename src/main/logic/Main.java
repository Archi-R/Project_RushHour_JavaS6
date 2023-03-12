package logic;

import graphic.G_Board;

import java.io.IOException;

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
                G_Board w = new G_Board(board);

            }
        });


//        while(!(board.getCell(5, 2).getVehicle().getNameColor() == NameColor.X;)) //while the car on the "win" cell isn't the red car
//        {
//            // main game
//        }
    }
}