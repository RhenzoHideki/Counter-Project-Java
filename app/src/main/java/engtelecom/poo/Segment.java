package engtelecom.poo;

import edu.princeton.cs.algs4.Draw;
import java.awt.*;

public class Segment {
    private Draw d;
    private double factor;
    private boolean isVertical;
    private Color colorOn;
    private Color colorOff;
    private double[] coordX = new double[6];
    private double[] coordY = new double[6];

    public Segment(double factor, boolean isVertical, Color colorOn, Color colorOff, double coordX, double coordY) {
        this.factor = factor;
        this.isVertical = isVertical;
        this.colorOn = colorOn;
        this.colorOff = colorOff;
        generateCoordinates(coordX, coordY);

    }

    /**
     * Generates the 6 points that form a segment
     * The parameters are the first coordinates passed to create the others
     * For horizontal segments is futherst point in the left
     * For vertical segments it's the bottom point
     * 
     * @param initialX
     * @param initialY
     */

    public void generateCoordinates(double initialX, double initialY) {
        if (isVertical) {
            this.coordX = new double[] { 0.1 * factor + initialX, 0.2 * factor + initialX, 0.2 * factor + initialX,
                    0.1 * factor + initialX, 0 * factor + initialX, 0 * factor + initialX };
            this.coordY = new double[] { 0.2 * factor + initialY, 0.3 * factor + initialY, 1.0 * factor + initialY,
                    1.1 * factor + initialY, 1.0 * factor + initialY, 0.3 * factor + initialY };
        } else {
            this.coordX = new double[] { 0.1 * factor + initialX, 0.2 * factor + initialX, 1.0 * factor + initialX,
                    1.1 * factor + initialX, 1.0 * factor + initialX, 0.2 * factor + initialX };
            this.coordY = new double[] { 0.2 * factor + initialY, 0.3 * factor + initialY, 0.3 * factor + initialY,
                    0.2 * factor + initialY, 0.1 * factor + initialY, 0.1 * factor + initialY };

        }
    }

    public boolean changeSegmentColor() {
        return false;
    }

    public void drawSegmentOn(Draw d) {
        d.setPenColor(this.colorOn);
        d.filledPolygon(coordX, coordY);
    }

    public void drawSegmentOff(Draw d) {
        d.setPenColor(this.colorOff);
        d.filledPolygon(coordX, coordY);
    }
}
