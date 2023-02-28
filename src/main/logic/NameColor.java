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
    private static HashMap<NameColor, Color> colornameMap = new HashMap<NameColor, Color>();

    static {
        colornameMap = new HashMap<NameColor, Color>();
        colornameMap.put(X, Color.RED);
        colornameMap.put(A, new Color(144, 238, 144));
        colornameMap.put(B, Color.ORANGE);
        colornameMap.put(C, Color.BLUE);
        colornameMap.put(D, Color.PINK);
        colornameMap.put(E, new Color(128, 0, 128));
        colornameMap.put(F, Color.green);
        colornameMap.put(G, Color.darkGray);
        colornameMap.put(H, Color.green);
        colornameMap.put(I, new Color(255, 237, 131));
        colornameMap.put(J, new Color(101, 67, 33));
        colornameMap.put(K, new Color(1, 50, 32));

        colornameMap.put(O, Color.yellow);
        colornameMap.put(P, new Color(106, 13, 173));
        colornameMap.put(Q, new Color(2, 7, 93));
        colornameMap.put(R, Color.green);
    }

    public static Color getColor(NameColor nc) {
        return colornameMap.get(nc);
    }

    public static int getLenght(NameColor color) {
        return color.ordinal() < 12 ? 2 : 3;
    }

    public static NameColor getNameColor(String color) {
        for (NameColor nameColor : NameColor.values()) {
            if (String.valueOf(nameColor).equals(color)) {
                return nameColor;
            }
        }
        return null;
    }

}
