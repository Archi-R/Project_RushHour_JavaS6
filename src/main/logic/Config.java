package logic;

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

    // methods


    //public String[] parserConfig(String conf) {
    //    // parse
    //}

    public void setLevel(int l){ this.level =l; }


    public int getLevel() { return level; }

    public void setConfig() { // set config
    }

    public String[] getConfig(){ return config; }


}
