package graphic;
import logic.*;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author: Ronan PEYREL
 * Class that represents a cell in the graphic interface
 */
public class G_Cell{
    private Cell cell;
    private JPanel square;
    private Window window;
    private Vehicle movingVehicle = null;

    public G_Cell(Cell c, Window window){
        this.cell = c;
        this.square = new JPanel();
        this.window = window;

        //always set the color as grey
        square.setBackground(new java.awt.Color(80, 80, 80));

        //add the mouse listener
        this.square.addMouseListener(new MouseListener() {

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                if(cell.isOccupied()&& !window.isMovingState()){
                    window.setMovingState(true);
                    setMovingVehicle(cell.getVehicle());
                } else if (false) {
                    
                }
            }
        });

    }

    public Cell getCell(){
        return cell;
    }

    public void setCell(Cell cell){
        this.cell = cell;
    }

    public JPanel getSquare(){
        return square;
    }

    public void setSquare(JPanel square){
        this.square = square;
    }

    public Vehicle getMovingVehicle(){
        return movingVehicle;
    }

    public void setMovingVehicle(Vehicle movingVehicle){
        this.movingVehicle = movingVehicle;
    }

    public void redraw(){
        if(cell.getVehicle() != null){
            square.setBackground(cell.getVehicle().getColor());
        }
        else{
            square.setBackground(new java.awt.Color(80, 80, 80));
        }
    }
}
