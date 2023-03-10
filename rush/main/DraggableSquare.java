import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DraggableSquare extends JPanel {

    private int squareSize = 50;
    private Point squareLocation = new Point(100, 100);
    private Point mouseLocation = null;

    public DraggableSquare() {
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(400, 400));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mouseLocation = e.getPoint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                mouseLocation = null;
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (mouseLocation != null) {
                    int deltaX = e.getX() - mouseLocation.x;
                    int deltaY = e.getY() - mouseLocation.y;
                    int newX = squareLocation.x + deltaX;
                    int newY = squareLocation.y + deltaY;
                    if (newX >= 0 && newX <= getWidth() - squareSize) {
                        squareLocation.x = newX;
                    }
                    if (newY >= 0 && newY <= getHeight() - squareSize) {
                        squareLocation.y = newY;
                    }
                    mouseLocation = e.getPoint();
                    repaint();
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillRect(squareLocation.x, squareLocation.y, squareSize, squareSize);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Draggable Square");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new DraggableSquare());
        frame.pack();
        frame.setVisible(true);
    }
}

