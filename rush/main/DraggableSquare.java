import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DraggableSquare extends JPanel {

    private final int ROWS = 6;
    private final int COLS = 6;
    private final int SQUARE_SIZE = 50;
    private Point squareLocation;
    private Point mouseLocation;

    public DraggableSquare() {
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(COLS * SQUARE_SIZE, ROWS * SQUARE_SIZE));

        squareLocation = new Point(SQUARE_SIZE, SQUARE_SIZE);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (isInsideSquare(e.getPoint())) {
                    mouseLocation = e.getPoint();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                mouseLocation = null;
                snapToGrid();
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
                    int gridWidth = getWidth() - SQUARE_SIZE;
                    int gridHeight = getHeight() - SQUARE_SIZE;
                    if (newX < SQUARE_SIZE) {
                        newX = SQUARE_SIZE;
                    } else if (newX > gridWidth) {
                        newX = gridWidth;
                    }
                    if (newY < SQUARE_SIZE) {
                        newY = SQUARE_SIZE;
                    } else if (newY > gridHeight) {
                        newY = gridHeight;
                    }
                    squareLocation.setLocation(newX, newY);
                    mouseLocation = e.getPoint();
                    repaint();
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                g.setColor((i + j) % 2 == 0 ? Color.WHITE : Color.LIGHT_GRAY);
                g.fillRect(j * SQUARE_SIZE, i * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
            }
        }
        g.setColor(Color.RED);
        g.fillRect(squareLocation.x, squareLocation.y, SQUARE_SIZE, SQUARE_SIZE);
    }

    private void snapToGrid() {
        int x = squareLocation.x / SQUARE_SIZE * SQUARE_SIZE + SQUARE_SIZE;
        int y = squareLocation.y / SQUARE_SIZE * SQUARE_SIZE + SQUARE_SIZE;
        squareLocation.setLocation(x, y);
        repaint();
    }

    private boolean isInsideSquare(Point point) {
        return point.x >= squareLocation.x && point.x < squareLocation.x + SQUARE_SIZE
                && point.y >= squareLocation.y && point.y < squareLocation.y + SQUARE_SIZE;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Draggable Square");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new DraggableSquare());
        frame.pack();
        frame.setVisible(true);
    }
}
