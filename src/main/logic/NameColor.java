package logic;

import java.awt.*;
import java.util.HashMap;

/**
 * Class that represent the unique name a vehicle can have.
 * It is also representing its unique color
 * It is also representing its type (Car or Truck)
 *
 * @author Ronan PEYREL
 */
public enum NameColor {
    //Cars (12)
    X, A, B, C, D, E, F, G, H, I, J, K,

    //Trucks (4)
    O, P, Q, R;
    private String color;
    /*X red A light_green B orange C blue
    Voitures D pink E dark_purple F green G dark_grey
    H grey I light_yellow J dark_brown K dark_green
    Camions O yellow P purple Q dark_blue R green
    */
    private static HashMap<NameColor, String> colornameMap = new HashMap<NameColor, String>();

    static {
        colornameMap = new HashMap<NameColor, String>();
        colornameMap.put(X, "red");
        colornameMap.put(A, "light_green");
        colornameMap.put(B, "orange");
        colornameMap.put(C, "blue");
        colornameMap.put(D, "pink");
        colornameMap.put(E, "dark_purple");
        colornameMap.put(F, "green");
        colornameMap.put(G, "dark_grey");
        colornameMap.put(H, "grey");
        colornameMap.put(I, "light_yellow");
        colornameMap.put(J, "dark_brown");
        colornameMap.put(K, "dark_green");

        colornameMap.put(O, "yellow");
        colornameMap.put(P, "purple");
        colornameMap.put(Q, "dark_blue");
        colornameMap.put(R, "green");
    }

    public static String getColor(NameColor color) {
        return colornameMap.get(color);
    }

    public static int getLenght(NameColor color) {
        return color.ordinal() < 12 ? 2 : 3;
    }

    public NameColor getNameColor(String color) {
        for (NameColor nameColor : NameColor.values()) {
            if (nameColor.color.equals(color)) {
                return nameColor;
            }
        }
        return null;
    }


}
