package logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Class representing the board object and it's function.
 * @author Hypolite LAGOUTTE & Ronan PEYREL
 * @version 1.0
 */

public class Board {

    /**
     * The board size
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
                Cell c = new Cell(this, i, j, null);
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
    public HashMap<int[], Cell> getCells() {
        return cells;
    }

    public Difficulty getDifficulty(){
        return this.difficulty;
    }


    /**
     * Initiate the game board by placing all the cars loaded from configuration
     *
     */
    public void initiate(){
        String[] conf = this.configuration.getConfig();
        for(int i =0;i<conf.length;i++) {
            int x = Integer.parseInt(conf[i].substring(2,3));
            int y = Integer.parseInt(conf[i].substring(3,4));
            NameColor name = NameColor.getNameColor(conf[i].substring(0,1));
            Direction dir = Direction.todirect(conf[i].substring(1,2));

            Vehicle v = new Vehicle(name,getCell(x,y),dir);
            this.placeVehicle(v,x,y);
        }
    }

    public void placeVehicle(Vehicle v, int x, int y) {
        boolean isok = true;
        if (v.getDirection() == Direction.HORIZONTAL) {
            //board limit
            if (x + v.getLength() > this.boardSize) { // if the vehicle is out of the board
                isok = false;
                placeVehicle(v,x-1,y); // modifying the destination x to place the vehicle fully on the board
            } else if (x < 0) {
                isok = false;
                placeVehicle(v,x+1,y); // modifying the destination x to place the vehicle fully on the board
            }
            //collision
            if(v.getOrigin().getX()>x) { // if the vehicle is moving to the left
                for (int i = 0; i < v.getLength(); i++) {
                    if (getCell(x + i, y).isOccupied()) {
                        isok = false;
                        System.out.println("collision");
                        placeVehicle(v, x - 1, y);
                    }
                }
            }
            else if(v.getOrigin().getX()<x) { // if the vehicle is moving to the right
                for (int i = 0; i < v.getLength(); i++) {
                    if (getCell(x + i, y).isOccupied()) {
                        isok = false;
                        System.out.println("collision");
                        placeVehicle(v, x + 1, y);
                    }
                }
            }
        } else {
            //board limit
            if (y + v.getLength() > this.boardSize) { // if the vehicle is out of the board
                isok = false;
                placeVehicle(v,x,y-1); // modifying the destination y to place the vehicle fully on the board
            } else if (y < 0) {
                isok = false;
                placeVehicle(v,x,y+1); // modifying the destination y to place the vehicle fully on the board
            }
            //collision
            if(v.getOrigin().getY()>y) { // if the vehicle is moving up
                for (int i = 0; i < v.getLength(); i++) {
                    if (getCell(x, y + i).isOccupied()) {
                        isok = false;
                        System.out.println("collision");
                        placeVehicle(v, x, y - 1);
                    }
                }
            }
            else if(v.getOrigin().getY()<y) { // if the vehicle is moving down
                for (int i = 0; i < v.getLength(); i++) {
                    if (getCell(x, y + i).isOccupied()) {
                        isok = false;
                        System.out.println("collision");
                        placeVehicle(v, x, y + 1);
                    }
                }
            }
        }

        if (isok) {
            //placing the origin of the vehicle
            v.setOrigin(getCell(x, y));
            //placing the vehicle on the board (therefore, on the cells)
            v.setOccupiedCells();
        }
    }

}



