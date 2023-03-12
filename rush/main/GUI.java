package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    private Board board;

    public GUI(Board board) {
        this.board = board;
    }

    public void display() {
        JFrame frame = new JFrame("Rush Hour");
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Create a panel to display the game board
        JPanel boardPanel = new JPanel(new GridLayout(board.getSize(), board.getSize()));
        boardPanel.setBackground(board.getBackgroundColor());
        for (int y = 0; y < board.getSize(); y++) {
            for (int x = 0; x < board.getSize(); x++) {
                JLabel label = new JLabel();
                label.setOpaque(true);
                label.setBackground(Color.WHITE);
                boardPanel.add(label);
            }
        }

        // Add the vehicles to the board panel
        for (Vehicle vehicle : board.getVehicles()) {
            JPanel vehiclePanel = new JPanel();
            vehiclePanel.setOpaque(false);
            vehiclePanel.setLayout(null);
            vehiclePanel.setPreferredSize(new Dimension(vehicle.getLength() * 50, 50));

            JButton button = new JButton();
            button.setBounds(vehicle.getPositionX() * 50, vehicle.getPositionY() * 50, vehicle.getLength() * 50, 50);
            button.setBackground(vehicle.getColor());
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Selected vehicle ");
                }
            });
            vehiclePanel.add(button);

            boardPanel.add(vehiclePanel);
        }

        mainPanel.add(boardPanel, BorderLayout.CENTER);
        frame.add(mainPanel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Board board = new Board(6, Color.GRAY);
        Vehicle vehicle = new Vehicle(0, 2, 2, Color.RED);
        board.addVehicle(vehicle);

        GUI gui = new GUI(board);
        gui.display();
    }
}
