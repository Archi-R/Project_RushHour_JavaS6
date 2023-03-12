package main;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Board {
    private int size;
    private Color backgroundColor;
    private List<Vehicle> vehicles;

    public Board(int size, Color backgroundColor) {
        this.size = size;
        this.backgroundColor = backgroundColor;
        this.vehicles = new ArrayList<Vehicle>();
    }

    public int getSize() {
        return size;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public boolean canMoveLeft(Vehicle vehicle) {
        int newX = vehicle.getPositionX() - 1;
        if (newX < 0) {
            return false;
        }
        for (Vehicle other : vehicles) {
            if (vehicle != other && vehicle.intersects(other)) {
                return false;
            }
        }
        return true;
    }

    public boolean canMoveRight(Vehicle vehicle) {
        int newX = vehicle.getPositionX() + 1;
        if (newX + vehicle.getLength() > size) {
            return false;
        }
        for (Vehicle other : vehicles) {
            if (vehicle != other && vehicle.intersects(other)) {
                return false;
            }
        }
        return true;
    }

    public boolean canMoveUp(Vehicle vehicle) {
        int newY = vehicle.getPositionY() - 1;
        if (newY < 0) {
            return false;
        }
        for (Vehicle other : vehicles) {
            if (vehicle != other && vehicle.intersects(other)) {
                return false;
            }
        }
        return true;
    }

    public boolean canMoveDown(Vehicle vehicle) {
        int newY = vehicle.getPositionY() + 1;
        if (newY + vehicle.getLength() > size) {
            return false;
        }
        for (Vehicle other : vehicles) {
            if (vehicle != other && vehicle.intersects(other)) {
                return false;
            }
        }
        return true;
    }

    public void moveLeft(Vehicle vehicle) {
        if (canMoveLeft(vehicle)) {
            vehicle.setPositionX(vehicle.getPositionX() - 1);
        }
    }

    public void moveRight(Vehicle vehicle) {
        if (canMoveRight(vehicle)) {
            vehicle.setPositionX(vehicle.getPositionX() + 1);
        }
    }

    public void moveUp(Vehicle vehicle) {
        if (canMoveUp(vehicle)) {
            vehicle.setPositionY(vehicle.getPositionY() - 1);
        }
    }

    public void moveDown(Vehicle vehicle) {
        if (canMoveDown(vehicle)) {
            vehicle.setPositionY(vehicle.getPositionY() + 1);
        }
    }

    public boolean isWon() {
          Vehicle redCar = null;
//        for (Vehicle vehicle : vehicles) {
//            if (vehicle.getType() == VehicleType.RED_CAR) {
//                redCar = vehicle;
//                break;
//            }
//        }
        if (redCar == null) {
            return false;
        }
        return redCar.getPositionX() + redCar.getLength() == size;
    }
}