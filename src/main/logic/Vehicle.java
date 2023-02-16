package logic;

import javax.lang.model.util.Elements;
import java.awt.*;

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

    public Color getColor() {
        return Color.getColor(NameColor.getColorName(nameColor));
    }



}

