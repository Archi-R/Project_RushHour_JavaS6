package logic;

import java.awt.Color;

import static java.lang.Math.abs;

/**
 * Class that represent a vehicle.
 * @author Ronan PEYREL & Hypolite LAGOUTTE
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
    public void removeOccupiedCells(){
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
        boolean res = true;
        Cell origin = this.getOrigin();
        int[] diff = {abs(origin.getX()-destination.getX()),abs(origin.getY()- destination.getY())};

        if(diff[0] == 0 && diff[1] != 0 && this.getDirection() == Direction.VERTICAL){ // vertical
            for(int i=0;i<=this.getLength();i++){
                Cell dest = destination.getBoard().getCell(destination.getX(),destination.getY()+i);
                if(dest.isOccupied() && destination.getVehicle()!=this){ // if the dest is occupied, and it's not this vehicle
                    System.out.println("Is occ:"+dest.isOccupied());
                    System.out.println("save V:"+(destination.getVehicle()==this));
                    System.out.println("VERTICAL destination is occupied");
                    res = false;                         /* I know this code can be reduced, but this is clearer */
                }else{
                    System.out.println("dest: "+destination.getVehicle()+" |this: "+this+" |res: "+(destination.getVehicle()==this));
                }
            }

        }else if(diff[0] != 0 && diff[1] == 0 && this.getDirection() == Direction.HORIZONTAL){ // horizontal
            for(int i=0;i<=this.getLength();i++){
                Cell dest = destination.getBoard().getCell(destination.getX()+i,destination.getY());
                if(dest.isOccupied() && destination.getVehicle()!=this){ // if the dest is occupied, and it's not this vehicle
                    System.out.println("Is occ:"+dest.isOccupied());
                    System.out.println("save V:"+(destination.getVehicle()==this));
                    System.out.println("HORIZONTAL destination is occupied");
                    res = false;                         /* I know this code can be reduced, but this is clearer */
                }else{
                    System.out.println("dest: "+destination.getVehicle()+" |this: "+this+" |res: "+(destination.getVehicle()==this));
                }
            }
        }
        else{
            res = false;
            System.out.println("WRONG DIR");
        }
        return res;
    }


    /**
     * Moves the car on the selected case, it must check if the movement is legal
     * @param destination : Cell where the car will be moved
     */
    public void move(Cell destination){

        //placing the origin of the vehicle
        this.setOrigin(destination);
        //placing the vehicle on the board (therefore, on the cells)
        this.setOccupiedCells();

        /* old move
        if(!checkMove(c)){
            // don't move
            System.out.println("Can't move");
        }else{
            this.removeOccupiedCells();
            this.setOrigin(c);
            this.setOccupiedCells();

            c.getBoard().placeVehicle(this,c);
        }
        */
    }


}

