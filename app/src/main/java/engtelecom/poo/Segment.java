package engtelecom.poo;

import edu.princeton.cs.algs4.Draw;
import java.awt.*;

public class Segment {
    /**
     * Factor represents the size of the segment
     */
    private double factor;
    /**
     * indicates segment direction
     */
    private boolean isVertical;
    /*
     * color used when segment is on
     */
    private Color colorOn;
    /**
     * color used when segment is off
     */
    private Color colorOff;
    /*
     * initial X coordinate that will build the other 5 X
     * coordinates of the segment
     */
    private double[] coordX = new double[6];
    /*
     * initial Y coordinate that will build the other 5 Y
     * coordinates of the segment
     */
    private double[] coordY = new double[6];

    /**
     * // * The constructor method receive attributes from what is declared
     * 
     * @param factor     - factor represents the size of the segment
     * @param isVertical - indicates segment direction
     * @param colorOn    - color used when segment is on
     * @param colorOff   - color used when segment is off
     * @param coordX     - initial X coordinate that will build the other 5 X
     *                   coordinates of the segment
     * @param coordY-    initial Y coordinate that will build the other 5 Y
     *                   coordinates of the segment
     */
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
     * @param initialX - position indicating initial coordinate in X
     * @param initialY - position indicating initial coordinate in Y
     */
    private void generateCoordinates(double initialX, double initialY) {
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

    /**
     * Method to draw in the canvas with the color indicated as Segment On
     * 
     * @param d Display used
     */
    public void drawSegmentOn(Draw d) {
        d.setPenColor(this.colorOn);
        d.filledPolygon(coordX, coordY);
    }

    /**
     * Method to draw in the canvas with the color indicated as Segment Off
     * 
     * @param d Display used
     */
    public void drawSegmentOff(Draw d) {
        d.setPenColor(this.colorOff);
        d.filledPolygon(coordX, coordY);
    }
}
