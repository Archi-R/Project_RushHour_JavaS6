package logic;

import java.util.ArrayList;
import java.util.HashMap;

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
     */
    private HashMap<int[], Cell> cells = new HashMap<int[], Cell>();

    /////////////////// methods

    /**
     * Create a board with the given difficulty and configuration
     * @param difficulty : the wanted difficulty
     * @param configuration : the wanted configuration
     */
    Board(Difficulty difficulty, Config configuration){
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
    	return cells.get(pos);
    }

    public Difficulty getDifficulty(){
        return this.difficulty;
    }
}
