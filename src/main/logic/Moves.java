package logic;


/**
 * describe the movement that can be made by a car to move
 */
public enum Moves {
    UP,DOWN,LEFT,RIGHT;

    /**
     * Give a Moves version from a string version, so it can be used in functions
     * @param str : the move but in type String
     * @return the same move in type Moves
     */
    public static Moves toMoves(String str){
        for(Moves move : Moves.values()){
            if(String.valueOf(move).equals(str)){
                return move;
            }
        }
        return null;
    }
}
