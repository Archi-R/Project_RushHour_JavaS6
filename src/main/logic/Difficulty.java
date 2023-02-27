package logic;

/**
 * @autor Hypolite
 * @version 1.0
 */
public enum Difficulty {

    /**
     * difficulties enumeration
     */
    beginner, intermediate, advanced, expert, grandmaster;

    public static Difficulty todiff(String diff){
        for (Difficulty difficulty : Difficulty.values()) {
            if (String.valueOf(difficulty).equals(diff)) {
                return difficulty;
            }
        }
        return null;
    }
}
