package logic;

import java.io.FileReader;
import java.io.IOException;

/**
 * Class that represent the different configuration.
 * @author
 * @version
 */
public class Config {

    /**
     * level number of the configuration
     */
    private int level;


    /**
     * Configuration of the cars on the board, liste of position
     * of the cars on the board
     * AV03 représente la voiture de couleur “light_green” placée
     * verticalement à la position (0,3).
     */
    private String[] config;

    /**
     * Difficulty of the configuration.
     */
    private Difficulty difficulty;

    // methods

    /**
     * create a configuration
      * @param difficulty : the wanted difficulty
     * @param level : the level in the difficulty
     * @throws IOException
     */
    public Config(Difficulty difficulty,int level) throws IOException {
        this.level = level;
        this.config =  parserConfig(difficulty,level);
    }


    /**
     * Go take the level line in the difficulty cfg file and extract the
     * positions of the cars for the current game.
     * @param difficulty : the wanted difficulty
     * @param level : the wanted level
     * @return : an array containing all the cars position of the config
     * @throws IOException
     */
    public String[] parserConfig(Difficulty difficulty, int level) throws IOException {
        file file = new file((String.valueOf(difficulty)+".cfg"));
        FileReader fis = new FileReader(file);
        int nbLine = file.findLine(fis);

        FileReader fis1 = new FileReader(file);
        String[] array= file.readLine(level,nbLine,fis1).split(" ");
        return array;
    }


    /**
     * Set the level number picked from the configuration file
     * @param l : level wanted
     */
    public void setLevel(int l){ this.level =l; }


    /**
     * return the level of the current configuration
     * @return
     */
    public int getLevel() { return level; }

    /**
     * set the configuration
     */
    public void setConfig() { // set config
    }

    /**
     * return the current configuration
     * @return
     */
    public String[] getConfig(){ return config; }


}
