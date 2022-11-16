package engtelecom.poo;

import edu.princeton.cs.algs4.Draw;
import java.awt.*;

public class DigitPair {
    /**
     * trackingValue is an attribute made to track the value is meant to show
     */
    /**
     * digits is an attribute made to create a tens , created left to right
     */
    private Digit[] digits = new Digit[2];

    public DigitPair(double factor, Color colorOn, Color colorOff, double coordX, double coordY) {
        this.digits = createDigits(factor, colorOn, colorOff, coordX, coordY);
    }

    private Digit[] createDigits(double factor, Color colorOn, Color colorOff, double coordX, double coordY) {
        digits[0] = new Digit(factor, colorOn, colorOff, coordX, coordY);
        digits[1] = new Digit(factor, colorOn, colorOff, coordX + 1.5 * factor, coordY);
        return digits;
    }

    /**
     * Displays the lest signicant number
     * 
     * @param ones - number going to be displayed
     * @param d    - canvas used in the display
     */
    public void showOnes(int ones, Draw d) {
        digits[1].showNumber(ones, d);
    }

    /**
     * Display the most signicant number
     * 
     * @param tens - number going to be displayed
     * @param d    - canvas used in the display
     */
    public void showTens(int tens, Draw d) {
        digits[0].showNumber(tens, d);
    }
}
