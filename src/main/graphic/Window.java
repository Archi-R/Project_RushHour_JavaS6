package graphic;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import logic.*;
/*

public class Fenetre implements MouseListener{

    private final int dimension = 6;
    private JFrame frame = new JFrame("Rush Hour");
    private Board board;


    public Fenetre()
    {
        initChessboard();
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
    }

    private void initChessboard()
    {
        for(int j = dimension -1; j >= 0; j--)// boucle ordonnées
        {
            for(int i = 0; i < dimension ; i++) // boucle abscisses
            {
                if((i + j) % 2 == 0) // permet d'obtenir un vrai 1/2 ce que  (j%2) ne permettait pas
                {
                    chessboard[i][j] = new Square(i, j, true, false);
                    chessboard[i][j].getSquare().setBackground(new Color(128, 64, 0));
                }
                else
                {
                    chessboard[i][j] = new Square(i, j, false, false);
                    chessboard[i][j].getSquare().setBackground(new Color(250,224,124));
                }
                chessboard[i][j].getSquare().setPreferredSize(new Dimension(50,50));
                chessboard[i][j].getSquare().setBorder(BorderFactory.createLineBorder(Color.BLACK));
                final int x = i, l = j;

                chessboard[i][j].getSquare().addMouseListener(new MouseListener() {

                    Piece p;
                    @Override
                    public void mouseReleased(MouseEvent e) {}

                    @Override
                    public void mousePressed(MouseEvent e) {}

                    @Override
                    public void mouseExited(MouseEvent e) {}

                    @Override
                    public void mouseEntered(MouseEvent e) {}

                    @Override
                    public void mouseClicked(MouseEvent e)
                    {
                        if(p == null)
                        {
                            p = chessboard[x][l].getPiece();
                        }
                        else
                        {
                            try
                            {
                                if(chessboard[x][l].getPiece() == null)
                                {
                                    System.out.println("ok");
                                    chessboard[x][l].getPiece().deplacer(chessboard, x, l, x, l+1);
                                    frame.revalidate();
                                    p = null;
                                }
                                else
                                {
                                    System.out.println("case non vide");
                                }
                            }
                            catch(Exception ex){
                                System.out.println("case vide");
                                System.out.println("x : " + x + " y : " + l);
                            }
                        }
                    }
                });
                frame.add(chessboard[i][j].getSquare());
            }
        }
    }

    public void displayPiece(Piece piece)
    {
        chessboard[piece.getPositionX()][piece.getPositionY()].getSquare().add(new JLabel(new ImageIcon("Images/pionBlanc.jpg")));
        frame.revalidate();
    }

    public Square getASquare(int i, int j) // ne retourne qu'une case de notre tableau, utilise pour set une piece
    {
        return chessboard[i][j];
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
}
public class Window {
}
*/