package main;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class GamePanel extends JPanel {

    //Screen Settings
    final int originalCellsize = 16; // 16 x 16 Cell
    final int scale = 3;

    final int CellSize = originalCellsize * scale;
    final int maxScreenCol = 6;
    final int maxScreenRow = 6;
    final int screenWidth = CellSize * maxScreenCol;
    final int screenHeight = CellSize * maxScreenRow;

    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
    }
}