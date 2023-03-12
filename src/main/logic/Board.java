package logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.abs;

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
            Cell c = getCell(x,y);
            this.placeVehicle(v,c);
        }
    }

    public void placeVehicle(Vehicle v, Cell destination) {
        //temporarily removing the vehicle off the board
        // in order to check if the destination is free
        // without considering the vehicle itself
        v.removeOccupiedCells(); //satisfying the precondition of isWayFree and isOnBoard.

        boolean isok = this.isWayFree(v, destination) && this.isOnBoard(v,destination);
        boolean isonTrack = this.isOnTrack(v,destination); //this one's special, bc it just cannot move off the track
        if (isok && isonTrack){
            // the way is free, so we move the vehicle to the destination
            v.move(destination);
        }else if(!isonTrack){
            //just replace the vehicle back on the board
            v.setOccupiedCells();
        }else if (!isok){

            // there is a problem, so we try to move the vehicle to the previous cell

            if (v.getDirection() == Direction.HORIZONTAL) { // if the vehicle is horizontal
                if (v.getOrigin().getX() > destination.getX()) { // if the vehicle is moving left
                    if (!isok) {
                        Cell previonsCell = this.getCell(destination.getX()+1, destination.getY()); // we try to the cell on the right
                        this.placeVehicle(v, previonsCell);
                    }
                } else if (v.getOrigin().getX() < destination.getX()) { // if the vehicle is moving right
                    if (!isok) {
                        Cell previonsCell = this.getCell(destination.getX()-1, destination.getY()); // we try to the cell on the left
                        this.placeVehicle(v, previonsCell);
                    }
                } else {
                    System.out.println("There is a fucking problem WTF");
                    System.out.println("Error : the vehicle is already on this cell");
                }
            } else { // if the vehicle is vertical
                if (v.getOrigin().getY() > destination.getY()) { // if the vehicle is moving up
                    if (!isok) {
                        Cell previonsCell = this.getCell(destination.getX(), destination.getY()+1); // we try to the cell on the bottom
                        this.placeVehicle(v, previonsCell);
                    }
                } else if (v.getOrigin().getY() < destination.getY()) { // if the vehicle is moving down
                    if(!isok) {
                        Cell previonsCell = this.getCell(destination.getX(), destination.getY()-1); // we try to the cell on the top
                        this.placeVehicle(v, previonsCell);
                    }
                } else {
                    System.out.println("There is a fucking problem WTF");
                    System.out.println("Error : the vehicle is already on this cell");
                }
            }
        }
    }

    /**
     * Method to check if the way is free for the vehicle to move
     * @pre : the board doesn't contain this vehicle
     * @pre : the destination is the where the origin of the vehicle will be after the move
     * @param v : Vehicle , the vehicle to move
     * @param destination : Cell , the destination of the vehicle
     */
    private boolean isWayFree(Vehicle v, Cell destination){

        int dest_x = destination.getX();
        int dest_y = destination.getY();
        boolean isok = true;
        if (v.getDirection() == Direction.HORIZONTAL) { // if the vehicle is horizontal
            if(v.getOrigin().getX()>dest_x) { // if the vehicle is moving to the left
                for(int ix = dest_x; ix < v.getOrigin().getX(); ix++) { // all the cells FROM DESTINATION TO ORIGIN
                    for (int i = 0; i < v.getLength(); i++) { // all the cells occupied by the vehicle
                        if (getCell(ix+i, dest_y).isOccupied()) {
                            isok = false;
                        }
                    }
                }
            }
            else if(v.getOrigin().getX()<dest_x) { // if the vehicle is moving to the right
                for(int ix = v.getOrigin().getX(); ix <= dest_x; ix++) { // all the cells FROM ORIGIN TO DESTINATION
                    for (int i = 0; i < v.getLength(); i++) { // all the cells occupied by the vehicle
                        if (getCell(ix+i, dest_y).isOccupied()) {
                            isok = false;
                        }
                    }
                }
            }
        } else { // if the vehicle is vertical
            if(v.getOrigin().getY()>dest_y) { // if the vehicle is moving up
                for(int iy = dest_y; iy < v.getOrigin().getY(); iy++) { // all the cells FROM DESTINATION TO ORIGIN
                    for (int i = 0; i < v.getLength(); i++) { // all the cells occupied by the vehicle
                        if (getCell(dest_x, iy+i).isOccupied()) {
                            isok = false;
                        }
                    }
                }
            }
            else if(v.getOrigin().getY()<dest_y) { // if the vehicle is moving down
                for(int iy = v.getOrigin().getY(); iy <= dest_y; iy++) { // all the cells FROM ORIGIN TO DESTINATION
                    for (int i = 0; i < v.getLength(); i++) { // all the cells occupied by the vehicle
                        if (getCell(dest_x, iy+i).isOccupied()) {
                            isok = false;
                        }
                    }
                }
            }
        }
        return isok;
    }

    /**
     * Method to check if the vehicle will stay on the board
     * @pre : the board doesn't contain this vehicle
     * @pre : the destination is the where the origin of the vehicle will be after the move
     * @param v : Vehicle , the vehicle to move
     * @param destination : Cell , the destination of the vehicle
     */
    private boolean isOnBoard(Vehicle v, Cell destination) {
        int dest_x = destination.getX();
        int dest_y = destination.getY();
        boolean isok = true;
        if (v.getDirection() == Direction.HORIZONTAL) { // if the vehicle is horizontal
            if (dest_x + v.getLength() > this.boardSize) { // if the front of the vehicle is out of the board on the right
                isok = false;
            } else if (dest_x < 0) { // if the back of the vehicle is out of the board on the left
                isok = false;
            }
        } else { // if the vehicle is vertical
            if (dest_y + v.getLength() > this.boardSize) { // if the vehicle is out of the board on the bottom
                isok = false;
            } else if (dest_y < 0) { // if the back of the vehicle is out of the board on the top
                isok = false;
            }
        }
        return isok;
    }

    /**
     * Method to check if the vehicle is moving the same way as its direction
     * @pre : the board doesn't contain this vehicle
     * @pre : the destination is the where the origin of the vehicle will be after the move
     * @param v : Vehicle , the vehicle to move
     * @param destination : Cell , the destination of the vehicle
     */
    private boolean isOnTrack(Vehicle v, Cell destination) {
        boolean isok = false;
        Cell origin = v.getOrigin();
        int diff_x = abs(origin.getX() - destination.getX());
        int diff_y = abs(origin.getY() - destination.getY());
        int[] diff = {abs(origin.getX() - destination.getX()), abs(origin.getY() - destination.getY())};

        if (v.getDirection() == Direction.VERTICAL && diff_x == 0) { // were moving vertically, on a column
            isok = true;
        } else if (v.getDirection() == Direction.HORIZONTAL && diff_y == 0) { // were moving horizontally, on a row
            isok = true;
        } /* I know this can be reducted, but I prefer to keep it like this for the readability */
        else{
            isok = false;
            System.out.println("Error : the vehicle is not on the right track");
        }
        return isok;
    }

    /**
     * Method to check if the player has won
     * @return : boolean , true if the player has won, false otherwise
     */
    public boolean hasWon() {
        return this.getCell(this.boardSize - 1, 2).getVehicle().getNameColor() == NameColor.X;
    }
}



