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
                gBoard.sortingHat(getGCell());
            }
        });

    }

    public Cell getCell(){
        return cell;
    }

    public JPanel getSquare(){
        return square;
    }

    public void redraw(){
        if(cell.getVehicle() != null){
            square.setBackground(cell.getVehicle().getColor());
        }
        else{
            square.setBackground(new java.awt.Color(80, 80, 80));
        }
    }

    public G_Cell getGCell(){ //I know, but I Need it
        return this;
    }
}
