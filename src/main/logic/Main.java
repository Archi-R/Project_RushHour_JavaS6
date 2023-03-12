package logic;

import graphic.G_Board;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Board board = new Board(Difficulty.beginner, new Config(Difficulty.beginner));
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                G_Board w = new G_Board(board);

            }
        });
    }
}