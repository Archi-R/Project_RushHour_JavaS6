package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Box;
import javax.swing.BoxLayout;

public class GamePanel extends JPanel implements ActionListener {

    // Screen Settings
    final int originalCellsize = 16; // 16 x 16 Cell
    final int scale = 3;

    final int CellSize = originalCellsize * scale;
    final int maxScreenCol = 6;
    final int maxScreenRow = 6;
    final int screenWidth = CellSize * maxScreenCol;
    final int screenHeight = CellSize * maxScreenRow;

    // Difficulty buttons
    private JButton easyButton;
    private JButton mediumButton;
    private JButton hardButton;

    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);

        // Create difficulty buttons
        easyButton = new JButton("Easy");
        easyButton.setFont(new Font("Arial", Font.PLAIN, 16));
        easyButton.setBackground(Color.GREEN);
        easyButton.addActionListener(this);
        mediumButton = new JButton("Medium");
        mediumButton.setFont(new Font("Arial", Font.PLAIN, 16));
        mediumButton.setBackground(Color.YELLOW);
        mediumButton.addActionListener(this);
        hardButton = new JButton("Hard");
        hardButton.setFont(new Font("Arial", Font.PLAIN, 16));
        hardButton.setBackground(Color.RED);
        hardButton.addActionListener(this);

        // Create a new JPanel to hold the buttons and center them
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setAlignmentX(CENTER_ALIGNMENT);
        buttonPanel.add(Box.createVerticalGlue());
        buttonPanel.add(easyButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        buttonPanel.add(mediumButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        buttonPanel.add(hardButton);
        buttonPanel.add(Box.createVerticalGlue());

        // Add the button panel to the GamePanel
        this.add(buttonPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO: Handle difficulty selection
    }
}
