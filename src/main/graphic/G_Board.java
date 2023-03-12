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

    private G_Cell originG_Cell = null;
    private G_Cell destinationG_Cell = null;

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


    public void sortingHat(G_Cell g_c) {
        Cell c = g_c.getCell();
        if(this.originG_Cell == null && c.isOccupied()) { //if we don't have an origin
            System.out.println("clicked on an occupied cell");
            this.originG_Cell = g_c;                //we set the origin
            this.movingVehicle = c.getVehicle();   //we set the vehicle we're moving
            this.destinationG_Cell = null;        //we reset the destination
        } else if (this.destinationG_Cell == null) { //if we have an origin but no destination
            System.out.println("2nd click");
            this.destinationG_Cell = g_c;                                                    //we set the destination
            this.board.placeVehicle(this.movingVehicle, this.destinationG_Cell.getCell());  //we place the vehicle
            this.originG_Cell = null;                                                      //we reset the origin & destination
            this.destinationG_Cell = null;
        } else {                                //if we have an origin and a destination, this is an error, we reset
            System.out.println("WTF ????????????");
            this.originG_Cell = null;
            this.destinationG_Cell = null;
        }
        this.redraw();
    }
    public void moveVehicle(Vehicle v, G_Cell g_c) {

        // TODO on abandonne ça ?
        Cell cell = g_c.getCell();


        if(cell.isOccupied()&& !this.isMovingState()){ // before everything
            System.out.println("clicked on a vehicle");
            this.setMovingState(true);
            this.setMovingVehicle(cell.getVehicle());
            this.setDiff(cell.originDiff());
        } else if (this.isMovingState()               // if we're in moving state(we clicked on a vehicle)
                && this.getMovingVehicle() != null     // if we're holding a vehicle
        ) {  // if the cell is empty or occup. by the vehicle we're holding
            System.out.println("V Holded, clicked on an empty cell");
            this.setMovingState(false);
            if(this.getMovingVehicle().getDirection() == Direction.HORIZONTAL) {
                System.out.println("horiz");
                int x = cell.getX() - this.getDiff();
                int y = cell.getY();
                Cell c = cell.getBoard().getCell(x, y);

                this.getMovingVehicle().move(c);

            }else if(this.getMovingVehicle().getDirection() == Direction.VERTICAL){
                System.out.println("vert");
                int x = cell.getX();
                int y = cell.getY() - this.getDiff();
                Cell c = cell.getBoard().getCell(x, y);

                this.getMovingVehicle().move(c);
            }else{
                System.out.println("Error: Direction not found");
            }
            this.setMovingVehicle(null);
            this.setMovingState(false);
            this.setDiff(0);
        } else if (!this.isMovingState() && this.getMovingVehicle() == null) { //if the fist click was on an empty cell
            System.out.println("clicked on an empty cell");
            this.setMovingState(false);
        } else {
            System.out.println("else");
            this.setMovingState(false);
        }
        this.redraw();
    }
}