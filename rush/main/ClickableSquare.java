package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ClickableSquare extends JPanel {

    private final int ROWS = 6;
    private final int COLS = 6;
    private final int SQUARE_SIZE = 50;
    private Point squareLocation;

    public ClickableSquare() {
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(COLS * SQUARE_SIZE, ROWS * SQUARE_SIZE));

        squareLocation = new Point(SQUARE_SIZE, SQUARE_SIZE);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int newX = e.getX() / SQUARE_SIZE * SQUARE_SIZE ;
                int newY = e.getY() / SQUARE_SIZE * SQUARE_SIZE ;
                squareLocation.setLocation(newX, newY);
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
                g.fillRect(j * SQUARE_SIZE, i * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
            }
        }
        g.setColor(Color.RED);
        g.fillRect(squareLocation.x, squareLocation.y, SQUARE_SIZE, SQUARE_SIZE);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Clickable Square");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new ClickableSquare());
        frame.pack();
        frame.setVisible(true);
    }
}
