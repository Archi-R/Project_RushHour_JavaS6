package graphic;
import logic.*;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class G_Cell {
    private Cell cell;
    private JPanel square;

    public G_Cell(Cell c){
        this.cell = c;
        this.square = new JPanel();

        square.addMouseListener(new MouseListener() {

            Vehicle v;
            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseClicked(MouseEvent e) {}
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
}
