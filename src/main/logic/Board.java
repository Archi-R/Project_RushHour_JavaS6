package logic;

public class Board {
    /**
     * Class representing the board object and it's function.
     */

    /**
     * difficulties enumeration
     */
    public enum Difficulty {beginner, intermediate, advanced, expert, grandmaster};

    /**
     * The board size.
     */
    final int boardsize = 6;

    /**
     * Define the difficulty of the current board
     */
    Difficulty difficulty;

    /**
     * Define the configuration of the current board
     */
    Config configuration;

}
