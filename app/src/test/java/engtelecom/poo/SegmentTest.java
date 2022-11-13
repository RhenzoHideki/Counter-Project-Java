package engtelecom.poo;

import org.junit.jupiter.api.Test;

import edu.princeton.cs.algs4.Draw;

//Using this Class only for debugging
// Maintaining Class App more clean so i can test other implemantation that involve the Draw class
public class SegmentTest {
    @Test
    void creatingSegments() {

        Draw desenho = new Draw();
        // Canvas (800x800)
        int dimension = 800;
        desenho.setXscale(0, dimension);
        desenho.setYscale(0, dimension);

        desenho.enableDoubleBuffering();

        double factor = 50;

        // initial points (300,180)
        double x = 400;
        double y = 200;
        Segment d = new Segment(factor, false, desenho.RED, desenho.ORANGE, x, y);
        d.drawSegmentOn(desenho);

        Segment e = new Segment(factor, true, desenho.RED, desenho.ORANGE, x, y + 0.1 * factor);
        e.drawSegmentOff(desenho);

        Segment c = new Segment(factor, true, desenho.RED, desenho.ORANGE, x + factor, y + 0.1 * factor);
        c.drawSegmentOff(desenho);

        Segment g = new Segment(factor, false, desenho.RED, desenho.ORANGE, x, y + 1.1 * factor);
        g.drawSegmentOff(desenho);

        Segment f = new Segment(factor, true, desenho.RED, desenho.ORANGE, x, y + 1.2 * factor);
        f.drawSegmentOn(desenho);

        Segment b = new Segment(factor, true, desenho.RED, desenho.ORANGE, x + factor, y + 1.2 * factor);
        b.drawSegmentOff(desenho);

        Segment a = new Segment(factor, false, desenho.RED, desenho.ORANGE, x, y + 2.2 * factor);
        a.drawSegmentOff(desenho);

        desenho.show();
    }
}
