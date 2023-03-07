package logic;

import java.awt.Color;

import static java.lang.Math.abs;

/**
 * Class that represent a vehicle.
 * @author Ronan PEYREL
 */
public class Vehicle {
    /**
     * The name of the vehicle.
     * Can also give its color.
     */
    private NameColor nameColor;

    /**
     * The origin cell of the vehicle.
     */
    private Cell origin;
    /**
     * The direction of the vehicle.
     * Horizontal = points towards the left
     * Vertical = points towards the bottom
     */
    private final Direction direction;


    /**
     * Constructor of the class Vehicle.
     * @param nameColor The name of the vehicle.
     * @param origin The origin cell of the vehicle.
     * @param direction The direction of the vehicle.
     */
    public Vehicle(NameColor nameColor, Cell origin, Direction direction) {
        this.nameColor = nameColor;
        this.origin = origin;
        this.direction = direction;
    }

    /**
     * Getter of the nameColor attribute.
     * @return
     */
    public NameColor getNameColor() {
        return nameColor;
    }

    /**
     * Getter of the length attribute.
     * @return The length of the vehicle.
     */
    public int getLength() {
        return NameColor.getLenght(nameColor);
    }

    /**
     * Getter of the origin attribute.
     * @return The origin cell of the vehicle.
     */
    public Cell getOrigin() {
        return origin;
    }

    /**
     * Getter of the direction attribute.
     * @return The direction of the vehicle.
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * Setter of the origin attribute.
     * @param origin The new origin cell of the vehicle.
     */
    public void setOrigin(Cell origin) {
        this.origin = origin;
    }

    /**
     * Getter of the color attribute.
     * @return The color of the vehicle.
     */
    public Color getColor() {
        return NameColor.getColor(nameColor);
    }

    /**
     * Method that return the string representation of the vehicle.
     * @return The string representation of the vehicle.
     */
    public String toString() {
        return nameColor +""+direction.toString().charAt(1) + origin.toString();
    }

    /**
     * Methods that set as occupied the cells the Vehicle is on.
     */
    public void setOccupiedCells() {
        if (direction == Direction.HORIZONTAL) {
            for (int i = 0; i < this.getLength(); i++) {
                Cell c = origin.getBoard().getCell(origin.getX() + i, origin.getY());
                c.setVehicle(this);
            }
        } else {
            for (int i = 0; i < this.getLength(); i++) {
                Cell c = origin.getBoard().getCell(origin.getX(), origin.getY() + i);
                c.setVehicle(this);
            }
        }
    }


    /**
     * methods that set as not occupied the cells the vehicle is on.
     */
    private void removeOccupiedCells(){
        if (direction == Direction.HORIZONTAL) {
            for (int i = 0; i < this.getLength(); i++) {
                origin.getBoard().getCell(origin.getX() + i, origin.getY()).setVehicle(null);
            }
        } else{
            for(int i=0; i<this.getLength(); i++){
                origin.getBoard().getCell((origin.getX()), origin.getY() +i).setVehicle(null);
            }
        }
    }

    /**
     * uklv;jebfvlkbn vl;kjsn vl ;j,hfnb ljz,;j,bn pvkzje;l,nfc viajkq,nv ajq /// flemme
     * @param destination
     * @return
     */
    public boolean checkMove(Cell destination) {
        Cell origin = this.getOrigin();
        int[] diff = {abs(origin.getX()-destination.getX()),abs(origin.getY()- destination.getY())};
        if( diff[0] == 0 && diff[1] != 0 && this.getDirection() == Direction.VERTICAL && !destination.isOccupied()){
            return true;
        }else if( diff[0] != 0 && diff[1] == 0 && this.getDirection() == Direction.HORIZONTAL && !destination.isOccupied() ){
            return true;
        }else{
            return false;
        }

    }


    /**
     * Moves the car on the selected case, it must check if the movement is legal
     * @param c
     */
    public void Move(Cell c){

        if(!checkMove(c)){
            // don't move
        }else{
            this.removeOccupiedCells();
            this.setOrigin(c);
            this.setOccupiedCells();

            c.getBoard().placeVehicle(this, c.getX(), c.getY());
        }
    }


}

