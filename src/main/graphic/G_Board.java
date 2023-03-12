package graphic;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import logic.*;

/**
    * Class that represents the board of the game
    * It contains the set of G_cell and the logic board
    * @author: Ronan PEYREL
 */
public class G_Board implements MouseListener{

    private final int dimension;
    private JFrame frame = new JFrame("Rush Hour");
    private G_Cell[][] graphic_board;
    private Board board;

    private boolean isMovingState = false;

    public Vehicle getMovingVehicle() {
        return movingVehicle;
    }

    public void setMovingVehicle(Vehicle movingVehicle) {
        this.movingVehicle = movingVehicle;
    }

    private Vehicle movingVehicle = null;

    private int diff;


    public G_Board(Board board)
    {
        this.dimension = board.getBoardSize();
        this.graphic_board = new G_Cell[this.dimension][this.dimension];
        this.board = board;
        initFrame();
        frame.addMouseListener(this);
    }

    private void initFrame() {
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout(6,6,2,2));
        frame.setVisible(true);

        this.board.initiate();

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if(graphic_board[i][j] == null)
                {
                    Cell c = board.getCell(j, i);
                    graphic_board[i][j] = new G_Cell(c,this);
                    frame.add(graphic_board[i][j].getSquare());
                }
            }
        }
        this.redraw();
    }

    public void redraw(){
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                graphic_board[i][j].redraw();
            }
        }
        frame.repaint();
    }

    public boolean isMovingState() {
        return this.isMovingState;
    }

    public void setMovingState(boolean isMovingState) {
        this.isMovingState = isMovingState;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }
    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
    }
    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    public void setDiff(int originDiff) {
        this.diff = originDiff;
    }

    public int getDiff() { return this.diff; }

    public void moveVehicle(Vehicle v, G_Cell g_c) {
    }
}