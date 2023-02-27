package logic;

import java.awt.*;
import java.io.FileReader;
import java.io.IOException;

/**
 * Class that represent the different configuration.
 * @author Hypolite
 * @version 1.0
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
    public String[] config;

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
        // -- debut aller chercher le fichier
        FileDialog fd = new FileDialog(new Frame(), "Choose a file", FileDialog.LOAD);
        fd.setDirectory(System.getProperty("user.dir"));
        fd.setFile("*.cfg");
        fd.setVisible(true);

        String filename = fd.getDirectory()+fd.getFile();
        if (filename == null)
            System.out.println("You cancelled the choice");
        else
            System.out.println("You chose " + filename);
        // -- fin aller chercher le fichier

        //h file file = new file(("C:\\Users\\lagou\\Documents\\Cours\\POO\\projet\\resources\\"+String.valueOf(difficulty)+".cfg"));
        file file = new file((filename));
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
