package logic;
/**
 * Class that represent a direction where a Vehicle is pointing.
 * @author Ronan PEYREL
 */
public enum Direction {
    Horizontal, Vertical;

    public static Direction todirect(String letter){
        if(letter.equals("H")){
            return Horizontal;
        }else if(letter.equals("V")){
            return Vertical;
        }else{
            return null;
        }
    }
}
