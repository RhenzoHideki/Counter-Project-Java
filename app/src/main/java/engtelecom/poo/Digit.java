package engtelecom.poo;

import edu.princeton.cs.algs4.Draw;
import java.awt.*;

public class Digit {

    /*
     * Segment[] are saved in alphabetical order
     */
    private Segment[] segments = new Segment[7];

    public Digit(double factor, Color colorOn, Color colorOff, double coordX, double coordY) {
        // Segment D
        segments[3] = new Segment(factor, false, colorOn, colorOff, coordX, coordY);

        // Segment E
        segments[4] = new Segment(factor, true, colorOn, colorOff, coordX, coordY + 0.1 * factor);

        // Segment C
        segments[2] = new Segment(factor, true, colorOn, colorOff, coordX + factor, coordY + 0.1 * factor);

        // Segment G
        segments[6] = new Segment(factor, false, colorOn, colorOff, coordX, coordY + 1.1 * factor);

        // Segment F
        segments[5] = new Segment(factor, true, colorOn, colorOff, coordX, coordY + 1.2 * factor);

        // Segment B
        segments[1] = new Segment(factor, true, colorOn, colorOff, coordX + factor, coordY + 1.2 * factor);

        // Segment A
        segments[0] = new Segment(factor, false, colorOn, colorOff, coordX, coordY + 2.2 * factor);
    }

    /**
     * Method that call segments and draws in the canvas
     * 
     * @param number - number that is wanted to draw
     * @param d      - canvas used to draw
     */
    public void showNumber(int number, Draw d) {
        switch (number) {
            case 0:
                segments[0].drawSegmentOn(d);
                segments[1].drawSegmentOn(d);
                segments[2].drawSegmentOn(d);
                segments[3].drawSegmentOn(d);
                segments[4].drawSegmentOn(d);
                segments[5].drawSegmentOn(d);
                segments[6].drawSegmentOff(d);
                break;
            case 1:
                segments[0].drawSegmentOff(d);
                segments[1].drawSegmentOn(d);
                segments[2].drawSegmentOn(d);
                segments[3].drawSegmentOff(d);
                segments[4].drawSegmentOff(d);
                segments[5].drawSegmentOff(d);
                segments[6].drawSegmentOff(d);
                break;
            case 2:
                segments[0].drawSegmentOn(d);
                segments[1].drawSegmentOn(d);
                segments[2].drawSegmentOff(d);
                segments[3].drawSegmentOn(d);
                segments[4].drawSegmentOn(d);
                segments[5].drawSegmentOff(d);
                segments[6].drawSegmentOn(d);
                break;
            case 3:
                segments[0].drawSegmentOn(d);
                segments[1].drawSegmentOn(d);
                segments[2].drawSegmentOn(d);
                segments[3].drawSegmentOn(d);
                segments[4].drawSegmentOff(d);
                segments[5].drawSegmentOff(d);
                segments[6].drawSegmentOn(d);
                break;

            case 4:
                segments[0].drawSegmentOff(d);
                segments[1].drawSegmentOn(d);
                segments[2].drawSegmentOn(d);
                segments[3].drawSegmentOff(d);
                segments[4].drawSegmentOff(d);
                segments[5].drawSegmentOn(d);
                segments[6].drawSegmentOn(d);
                break;
            case 5:
                segments[0].drawSegmentOn(d);
                segments[1].drawSegmentOff(d);
                segments[2].drawSegmentOn(d);
                segments[3].drawSegmentOn(d);
                segments[4].drawSegmentOff(d);
                segments[5].drawSegmentOn(d);
                segments[6].drawSegmentOn(d);
                break;
            case 6:
                segments[0].drawSegmentOn(d);
                segments[1].drawSegmentOff(d);
                segments[2].drawSegmentOn(d);
                segments[3].drawSegmentOn(d);
                segments[4].drawSegmentOn(d);
                segments[5].drawSegmentOn(d);
                segments[6].drawSegmentOn(d);
                break;
            case 7:
                segments[0].drawSegmentOn(d);
                segments[1].drawSegmentOn(d);
                segments[2].drawSegmentOn(d);
                segments[3].drawSegmentOff(d);
                segments[4].drawSegmentOff(d);
                segments[5].drawSegmentOff(d);
                segments[6].drawSegmentOff(d);
                break;
            case 8:
                segments[0].drawSegmentOn(d);
                segments[1].drawSegmentOn(d);
                segments[2].drawSegmentOn(d);
                segments[3].drawSegmentOn(d);
                segments[4].drawSegmentOn(d);
                segments[5].drawSegmentOn(d);
                segments[6].drawSegmentOn(d);
                break;

            case 9:
                segments[0].drawSegmentOn(d);
                segments[1].drawSegmentOn(d);
                segments[2].drawSegmentOn(d);
                segments[3].drawSegmentOn(d);
                segments[4].drawSegmentOff(d);
                segments[5].drawSegmentOn(d);
                segments[6].drawSegmentOn(d);
                break;
            default:
                break;
        }
    }

}
