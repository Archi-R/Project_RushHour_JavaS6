package logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Class representing the board object and it's function.
 * @author Hypolite
 * @version 1.0
 */

public class Board {

    /**
     * The board size, initialized to 6.
     */
    private final int boardSize = 6;

    /**
     * Define the difficulty of the current board
     */
    private Difficulty difficulty;

    /**
     * Define the configuration of the current board
     */
    private Config configuration;

    /**
     * The board of the game
     * int[] contain the position x and y
     */
    private HashMap<int[], Cell> cells = new HashMap<int[], Cell>();

    /////////////////// methods

    /**
     * Create a board with the given difficulty and configuration
     * @param difficulty : the wanted difficulty
     * @param configuration : the wanted configuration
     */
    public Board(Difficulty difficulty, Config configuration){
        this.difficulty = difficulty;
        this.configuration = configuration;

        // Create the cells
        for(int i = 0; i < boardSize; i++){
            for(int j = 0; j < boardSize; j++){
                Cell c = new Cell(this, i, j, false, null);
                int[] pos = {i, j};
                cells.put(pos, c);
            }
        }
    }



    /**
     * Method which return the value of the size of the board
     * @return int : boardSize
     * @inv : boardSize = 6
     */
    public int getBoardSize(){
        return this.boardSize;
    }


    /**
     * Method which set the difficulty of the current board
     * @return null
     * @param d : Difficulty , the wanted difficulty
     */
    public void setDifficulty(Difficulty d){
        this.difficulty = d;
    }


    /**
     * Method which set the board configuration
     * @param c : Config , the wanted configuration
     * @return null
     */
    public void setConfiguration(Config c){
        this.configuration = c;
    }

    public Cell getCell(int x, int y) {
    	int[] pos = {x, y};
        for(Map.Entry<int[], Cell> entry : cells.entrySet()) {
            if(entry.getKey()[0] == pos[0] && entry.getKey()[1] == pos[1]) {
                return entry.getValue();
            }
        }
        return null;
    }

    public Difficulty getDifficulty(){
        return this.difficulty;
    }


    /**
     * Initiate the game board by placing all the cars loaded from configuration
     *
     */
    public void initiate(){
        for(int i =0;i<this.configuration.config.length;i++) {
            int x = Integer.parseInt(this.configuration.config[i].substring(2,3));
            int y = Integer.parseInt(this.configuration.config[i].substring(3,4));
            NameColor name = NameColor.getNameColor(this.configuration.config[i].substring(0,1));
            Direction dir = Direction.todirect(this.configuration.config[i].substring(1,2));

            Vehicle v = new Vehicle(name,getCell(x,y),dir);
            this.getCell(x,y).setVehicle(v);
        }
    }

}



