package engtelecom.poo;

import edu.princeton.cs.algs4.Draw;
import java.awt.*;

public class Clock {
    /**
     * clockPairs are used as
     * clockPairs[0] - hour
     * clockPairs[1] - minutes
     * clockPairs[2] - seconds
     * used for drawing
     */
    private DigitPair[] clockPairs = new DigitPair[3];
    /**
     * clockValue are used as
     * clockValue[0] - hour
     * clockValue[1] - minutes
     * clockValue[2] - seconds
     * used for calculus
     */
    private int[] clockValue = new int[3];
    private final int[] FACTOR_LIMITS = { 20, 100 };
    private final int FACTOR_DEFAULT = 40;

    private Counter c;

    public Clock(double factor, Color colorOn, Color colorOff, double coordX, double coordY, int isProgressive,
            int[] time) {
        factor = checkFactor(factor);
        // Doing the number of the clock
        clockPairs[0] = new DigitPair(factor, colorOn, colorOff, coordX, coordY); // Hours
        clockPairs[1] = new DigitPair(factor, colorOn, colorOff, coordX + 3.5 * factor, coordY); // Minutes
        clockPairs[2] = new DigitPair(factor, colorOn, colorOff, coordX + 7 * factor, coordY); // Seconds

        c = new Counter(isProgressive, time);

    }

    /**
     * Method that checks the factor
     * 
     * @param factor - factor passed by user
     * @return - factor inside the desired values
     */
    private double checkFactor(double factor) {
        if (factor < FACTOR_LIMITS[0] || factor > FACTOR_LIMITS[1]) {
            return FACTOR_DEFAULT;
        }
        return factor;
    }

    /**
     * Method that runs the unit timer and Draws in canvas
     * 
     * @param d Canvas that will be drawn
     */
    public void runClock(Draw d) {
        c.runCounter();
        DrawClock(c.getClockValue(), d);
    }

    /**
     * Method that Draws the 3 pairs of Numbers
     * 
     * @param time - value time used to draw
     * @param d    - Canvas
     */
    public void DrawClock(int[] time, Draw d) {
        clockPairs[0].showTens(time[0] / 10, d);
        clockPairs[0].showOnes(time[0] % 10, d);

        clockPairs[1].showTens(time[1] / 10, d);
        clockPairs[1].showOnes(time[1] % 10, d);

        clockPairs[2].showTens(time[2] / 10, d);
        clockPairs[2].showOnes(time[2] % 10, d);
    }

}
