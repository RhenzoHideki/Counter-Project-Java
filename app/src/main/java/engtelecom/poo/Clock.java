package engtelecom.poo;

import edu.princeton.cs.algs4.Draw;
import java.awt.*;

public class Clock {
    /**
     * cloakPairs are used as
     * cloakPairs[0] - hour
     * cloakPairs[1] - minutes
     * cloackPairs[2] - seconds
     */
    private DigitPair[] cloakPairs = new DigitPair[3];

    public Clock(double factor, Color colorOn, Color colorOff, double coordX, double coordY) {
        cloakPairs[0] = new DigitPair(factor, Draw.BLACK, Draw.GRAY, coordX, coordY); // Hours
        cloakPairs[1] = new DigitPair(factor, colorOn, colorOff, coordX + 2 * factor, coordY);
        cloakPairs[2] = new DigitPair(factor, colorOn, colorOff, coordX + 4 * factor, coordY);
    }

}
