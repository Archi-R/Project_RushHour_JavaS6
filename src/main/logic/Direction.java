package logic;
/**
 * Class that represent a direction where a Vehicle is pointing.
 * @author Ronan PEYREL
 */
public enum Direction {
    HORIZONTAL, VERTICAL;

    public static Direction todirect(String letter){
        if(letter.equals("H")){
            return HORIZONTAL;
        }else if(letter.equals("V")){
            return VERTICAL;
        }else{
            return null;
        }
    }
}
