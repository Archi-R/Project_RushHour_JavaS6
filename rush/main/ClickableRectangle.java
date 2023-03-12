
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ClickableRectangle extends JPanel {

    private final int ROWS = 6;
    private final int COLS = 6;
    private final int RECT_WIDTH = 100;
    private final int RECT_HEIGHT = 50;
    private final int CASE_SIZE = 50;
    private Point rectLocation;

    public ClickableRectangle() {
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(COLS * CASE_SIZE, ROWS * CASE_SIZE));

        rectLocation = new Point(RECT_WIDTH, RECT_HEIGHT);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int newX = e.getX() / CASE_SIZE * CASE_SIZE;
                rectLocation.setLocation(newX, rectLocation.y);
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                g.setColor((i + j) % 2 == 0 ? Color.WHITE : Color.LIGHT_GRAY);
                g.fillRect(j * CASE_SIZE, i * CASE_SIZE, RECT_WIDTH, RECT_HEIGHT);
            }
        }
        g.setColor(Color.RED);
        g.fillRect(rectLocation.x, rectLocation.y, RECT_WIDTH, RECT_HEIGHT);
    }



    public static void main(String[] args) {
        JFrame frame = new JFrame("Clickable Rectangle");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new ClickableRectangle());
        frame.pack();
        frame.setVisible(true);
    }
}
