package engtelecom.poo;

import edu.princeton.cs.algs4.Draw;
import java.awt.*;

public class Clock {
    /**
     * clockPairs are used as
     * clockPairs[0] - hour
     * clockPairs[1] - minutes
     * clockPairs[2] - seconds
     */
    private DigitPair[] clockPairs = new DigitPair[3];
    private int[] clockValue = new int[3];

    private Counter c;

    public Clock(double factor, Color colorOn, Color colorOff, double coordX, double coordY, int isProgressive,
            int[] time) {
        clockPairs[0] = new DigitPair(factor, colorOn, colorOff, coordX, coordY); // Hours
        clockPairs[1] = new DigitPair(factor, colorOn, colorOff, coordX + 3.5 * factor, coordY);
        clockPairs[2] = new DigitPair(factor, colorOn, colorOff, coordX + 7 * factor, coordY);
        c = new Counter(isProgressive, time);

    }

    void runClock(Draw d) {
        c.runCounter();
        DrawClock(c.getClockValue(), d);
    }

    /**
     * Method that Draws the 3 pairs of Numbers
     * 
     * @param time - time used
     * @param d
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
