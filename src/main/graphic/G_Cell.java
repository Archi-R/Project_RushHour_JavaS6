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
    private G_Board gBoard;


    public G_Cell(Cell c, G_Board gBoard){
        this.cell = c;
        this.square = new JPanel();
        this.gBoard = gBoard;

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
                if(cell.isOccupied()&& !gBoard.isMovingState()){ // before everything
                    System.out.println("clicked on a vehicle");
                    gBoard.setMovingState(true);
                    gBoard.setMovingVehicle(cell.getVehicle());
                    gBoard.setDiff(cell.originDiff());
                } else if (gBoard.isMovingState()               // if we're in moving state(we clicked on a vehicle)
                        && gBoard.getMovingVehicle() != null     // if we're holding a vehicle
                        ) {  // if the cell is empty or occup. by the vehicle we're holding
                    System.out.println("V Holded, clicked on an empty cell");
                    gBoard.setMovingState(false);
                    if(gBoard.getMovingVehicle().getDirection() == Direction.HORIZONTAL) {
                        System.out.println("horiz");
                        int x = cell.getX() - gBoard.getDiff();
                        int y = cell.getY();
                        Cell c = cell.getBoard().getCell(x, y);

                        gBoard.getMovingVehicle().move(c);

                    }else if(gBoard.getMovingVehicle().getDirection() == Direction.VERTICAL){
                        System.out.println("vert");
                        int x = cell.getX();
                        int y = cell.getY() - gBoard.getDiff();
                        Cell c = cell.getBoard().getCell(x, y);

                        gBoard.getMovingVehicle().move(c);
                    }else{
                        System.out.println("Error: Direction not found");
                    }
                    gBoard.setMovingVehicle(null);
                    gBoard.setMovingState(false);
                    gBoard.setDiff(0);
                } else if (!gBoard.isMovingState() && gBoard.getMovingVehicle() == null) { //if the fist click was on an empty cell
                    System.out.println("clicked on an empty cell");
                    gBoard.setMovingState(false);
                } else {
                    System.out.println("else");
                    gBoard.setMovingState(false);
                }
                gBoard.redraw();
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
