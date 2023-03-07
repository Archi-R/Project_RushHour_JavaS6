package graphic;

import logic.*;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class G_Vehicle{
    private Vehicle vehicle;
    private Cell targetCell = null;

    private JPanel rectangle = new JPanel();

    public G_Vehicle(Vehicle vehicle) {
        this.vehicle = vehicle;

        this.rectangle.setBackground(vehicle.getColor());

        //add the mouse listener
        this.rectangle.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println(getVehicle().toString());
            }

            @Override
            public void mouseClicked(MouseEvent e) {}
        });
    }

    public Vehicle getVehicle(){
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
    }

    public Cell getTargetCell(){
        return targetCell;
    }

    public void setTargetCell(Cell targetCell){
        this.targetCell = targetCell;
    }

    public JPanel getSquare(){
        return rectangle;
    }

    public void setSquare(JPanel square){
        this.rectangle = square;
    }

}
