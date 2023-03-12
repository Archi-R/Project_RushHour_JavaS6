package logic;

import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

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
    private String[] config;
    // methods

    /**
     * create a configuration
      * @param difficulty : the wanted difficulty
     * @throws IOException
     */
    public Config(Difficulty difficulty) throws IOException {
        this.config =  parserConfig(difficulty);
    }


    /**
     * Go take the level line in the difficulty cfg file and extract the
     * positions of the cars for the current game.
     * @param difficulty : the wanted difficulty
     * @return : an array containing all the cars position of the config
     * @throws IOException
     */
    public String[] parserConfig(Difficulty difficulty) throws IOException {
        // -- debut aller chercher le fichier
        FileDialog fd = new FileDialog(new Frame(), "Choose a file", FileDialog.LOAD);
        fd.setDirectory(System.getProperty("user.dir"));
        fd.setFile("*.cfg");
        fd.setVisible(true);

        String filename = fd.getDirectory() + fd.getFile();
        file file = null;
        if (filename == null) {
            System.out.println("You cancelled the choice");
        } else {
            System.out.println("You chose " + filename);
            file = new file(filename);
        }
        //fin aller chercher le fichier

        FileReader fis = new FileReader(file);
        int nbLine = file.findLine(fis);
        System.out.println("What level do you want to play ? (1-"+nbLine+")");
        Scanner sc = new Scanner(System.in);
        int level = Integer.parseInt(sc.nextLine());

        FileReader fis1 = new FileReader(file);
        String[] array = file.readLine(level, nbLine, fis1).split(" ");
        return array;
    }

    /**
     * return the current configuration
     * @return
     */
    public String[] getConfig(){ return config; }


}
