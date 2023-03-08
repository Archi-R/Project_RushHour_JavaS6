package logic;

/**
 * Class that represent the object cell.
 * @author Hypolite, Houda
 * 
 * @inv 0 <= getX() <= Board.SIZE
 * @inv 0 <= getY() <= Board.SIZE
 * @inv : vehicle = null => isOccupied() = false
 */

public class Cell {

    /**
     * Represent the position of the case on the x axis
     */
    private int x;

    /**
     * Represent the position of the case on the y axis
     */
    private int y;

    /**
     * The car that is on the current cell
     */
    private Vehicle vehicle;

    /**
     * The board that contains the current cell
     */
    private Board board;

    //CONSTRUCTEURS
    /**
     * Create a cell
     * @param x : the position on the x axis
     * @param y : the position on the y axis
     * @param vehicle : the vehicle which is on the cell
     */
    Cell(Board b, int x, int y, Vehicle vehicle){
        board = b;
        this.x = x;
        this.y = y;
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
        return x;
    }

    /**
     * return the value of the position of the cell on the
     * y axis
     * @return
     */
    public int getY(){
        return y;
    }


    /**
     * set the state of the cell
     * @return
     */
    public boolean isOccupied(){
        return vehicle != null;
    }

    /**
     * Déplacement du vehicule en spécifiant la différance
     * @param dx
     */
    public void setX(int dx){
        x += dx;
    }

    /**
     * set the position of the cell on the y ax is
     * @param dy
     */
    public void setY(int dy){
        y += dy;
    }

    /**
     * set the vehicle that is on the cell
     * @param v
     */
    public void setVehicle(Vehicle v){
        vehicle = v;
    }


    /**
     * return the board that contains the current cell
     * @return
     */
    public Board getBoard() {
    	return board;
    }

    /**
     * Give the difference between the cell and the origin cell of the car which is on this cell.
     *
     * @return the difference of position between the cell and origin, depending on the car orientation.
     */
    public int originDiff(){
        NameColor nc = this.vehicle.getNameColor(); // color
        Direction dir = this.vehicle.getDirection(); // direction of the car
        int x = this.getX(); // x position of the cell
        int y = this.getY(); // y position of the cell
        int diff = 0; // result
        if(dir == Direction.HORIZONTAL){
            for(int i=1;i<2;i++){
                // check the cell (x-1,y) to see if it is the same color
                if(this.getBoard().getCell(x-i,y).getVehicle().getNameColor() == nc){
                    // if it is, then it is the origin
                    diff ++;
                }
            }
            return diff;
        }else if(dir == Direction.VERTICAL){
            for(int i=1;i<2;i++){
                // check the cell (x;y-1) to see if it is the same color
                if(this.getBoard().getCell(x,y-i).getVehicle().getNameColor() == nc){
                    diff ++;
                }
            }
            return diff;
        }
        return diff;
    }
}
