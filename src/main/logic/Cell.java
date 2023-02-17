package logic;

/**
 * Class that represent the object cell.
 * @author Hypolite
 * @version 1.0
 */

public class Cell {

    /**
     * Represent the position of the case on the x axis
     */
    private int X;

    /**
     * Represent the position of the case on the y axis
     */
    private int Y;


    /**
     * Determine if the current cell is occupied by a vehicle or
     * not
     */
    private boolean isOccupied;

    /**
     * The car that is on the current cell
     */
    private Vehicle vehicle;

    /**
     * The board that contains the current cell
     */
    private Board board;

    ///////////// methods

    /**
     * Create a cell
     * @param X : the position on the x axis
     * @param Y : the position on the y axis
     * @param isOccupied : if the cell is occupied or not
     * @param vehicle : the vehicle which is on the cell
     */
    Cell(Board b, int X, int Y, boolean isOccupied, Vehicle vehicle){
        this.board = b;
        this.X = X;
        this.Y = Y;
        this.isOccupied = isOccupied;
        this.vehicle = vehicle;
    }

    /**
     * Give the vehicle that is on the cell
     * @return vehicle
     */
    public Vehicle getVehicle(){
        return vehicle;
    }


    /**
     * return the value of the position of the cell on the
     * x axis
     * @return
     */
    public int getX(){
        return X;
    }

    /**
     * return the value of the position of the cell on the
     * y axis
     * @return
     */
    public int getY(){
        return Y;
    }


    /**
     * set the state of the cell
     * @return
     */
    public boolean getIsOccupied(){
        return isOccupied;
    }

    /**
     * set the position of the cell on the x axis
     * @param x
     * @inv x <= 5
     * @inv x >= 0
     */
    public void setX(int x){
        this.X = x;
    }

    /**
     * set the position of the cell on the y axis
     * @param y
     * @inv y <= 5
     * @inv y >= 0
     */
    public void setY(int y){
        this.Y = y;
    }

    /**
     * set if the cell is occupied
     * @param iO
     * @inv : vehicle = null => isOccupied = false
     */
    public void setOccupied(boolean iO){
        this.isOccupied = iO;
    }

    /**
     * set the vehicle that is on the cell
     * @param v
     */
    public void setVehicle(Vehicle v){
        this.vehicle = v;
    }


    /**
     * return the board that contains the current cell
     * @return
     */
    public Board getBoard() {return this.board;}
}
