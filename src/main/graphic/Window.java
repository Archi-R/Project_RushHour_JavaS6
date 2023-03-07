package graphic;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import logic.*;

/**
    * Class that represents the window of the game
    * It contains the graphic board and the logic board
    * @author: Ronan PEYREL
 */
public class Window implements MouseListener{

    private final int dimension = 6;
    private JFrame frame = new JFrame("Rush Hour");
    private G_Cell[][] graphic_board = new G_Cell[dimension][dimension];
    private Board board;

    private boolean isMovingState = false;


    public Window(Board board)
    {
        this.board = board;
        initFrame();
        frame.addMouseListener(this);
    }

    private void initFrame()
    {
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

    private void redraw()
    {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                graphic_board[i][j].redraw();
            }
        }
    }

    public boolean isMovingState() {
        return this.isMovingState;
    }

    public void setMovingState(boolean isMovingState) {
        this.isMovingState = isMovingState;
    }

    /*
    public void displayPiece(Piece piece)
    {
        graphic_board[piece.getPositionX()][piece.getPositionY()].getSquare().add(new JLabel(new ImageIcon("Images/pionBlanc.jpg")));
        frame.revalidate();
    }

    public Square getASquare(int i, int j) // ne retourne qu'une case de notre tableau, utilise pour set une piece
    {
        return graphic_board[i][j];
    }

    */
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

}