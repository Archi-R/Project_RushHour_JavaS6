package logic;

/**
 * Class that represent a vehicle.
 * @author Ronan PEYREL
 */
public class Vehicle {

    private NameColor nameColor;
    private int length;
    private Cell origin;
    private final Direction direction;


    public Vehicle(NameColor nameColor, Cell origin, Direction direction) {
        this.nameColor = nameColor;
        this.length = NameColor.getLenght(nameColor);
        this.origin = origin;
        this.direction = direction;
    }

    public NameColor getNameColor() {
        return nameColor;
    }

    public int getLength() {
        return length;
    }

    public Cell getOrigin() {
        return origin;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setOrigin(Cell origin) {
        this.origin = origin;
    }

    public String getColor() {
        return NameColor.getColor(nameColor);
    }



}

