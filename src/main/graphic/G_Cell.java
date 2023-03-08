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
                if(cell.isOccupied()&& !window.isMovingState()){ // before everything
                    window.setMovingState(true);
                    window.setMovingVehicle(cell.getVehicle());
                    window.setDiff(cell.originDiff());
                } else if (window.isMovingState()                                                                       // if we're in moving state(we clicked on a vehicle)
                        &&window.getMovingVehicle() != null                                                             // if we're holding a vehicle
                        ) {  // if the cell is empty or occup. by the vehicle we're holding
                    window.setMovingState(false);
                    if(window.getMovingVehicle().getDirection() == Direction.HORIZONTAL) {
                        window.getMovingVehicle().move(cell.getBoard().getCell(cell.getX() - window.getDiff(), cell.getY()));
                    }else if(window.getMovingVehicle().getDirection() == Direction.VERTICAL){
                        window.getMovingVehicle().move(cell.getBoard().getCell(cell.getX(), cell.getY()- window.getDiff()));
                    }
                    window.setMovingVehicle(null);
                    window.setDiff(0);
                } else if (window.isMovingState() && window.getMovingVehicle() == null) { //if the fist click was on an empty cell
                    window.setMovingState(false);
                }
                window.redraw();
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

    public void redraw(){
        if(cell.getVehicle() != null){
            square.setBackground(cell.getVehicle().getColor());
        }
        else{
            square.setBackground(new java.awt.Color(80, 80, 80));
        }
    }
}
