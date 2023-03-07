package logic;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Class that represent the different configuration.
 * @author Hypolite, Houda
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
    public String[] configs;

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
        configs =  parserConfig(difficulty,level);
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
        
        File file = new File("/home/houda/eclipse-workspace/RushHour/src/Ressources/"+String.valueOf(difficulty)+".cfg");
        Scanner scanner = new Scanner(file);
        int i = 1;
        String lineLevel = "";
        while (i <= level && scanner.hasNextLine()) {
            lineLevel = scanner.nextLine();
        }
        
        String[] configs = lineLevel.split(" "); // séparation de chaque ligne en configurations individuelles  
        scanner.close();
        return configs;
    }



    /**
     * Set the level number picked from the configuration file
     * @param l : level wanted
     */
    public void setLevel(int l){
    	this.level = l; 
    }


    /**
     * return the level of the current configuration
     * @return
     */
    public int getLevel() { 
    	return level; 
    }



    /**
     * return the current configuration
     * @return
     */
    public String[] getConfig(){ 
    	return configs; 
    }


}
