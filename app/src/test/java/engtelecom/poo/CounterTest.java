package engtelecom.poo;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CounterTest {

    @Test
    void counterAttributesTest() {
        int[] timeRef = { 0, 0, 0 };
        // Pass invalid values for the Counter
        int[] timeTest = { -1, -5, 60 };
        Counter c = new Counter(1, timeTest);

        // Test case parameters for Counter are incorrect and reajust
        // For negative numbers
        // Manually tested individual value due to Problems that i didn't know how to
        // fix
        int[] aux = c.getClockValue();
        assertTrue(timeRef[0] == aux[0]);
        assertTrue(timeRef[1] == aux[1]);
        assertTrue(timeRef[2] == aux[2]);

        timeRef = new int[] { 0, 0, 0 };
        // Pass invalid values for the Counter
        timeTest = new int[] { 100, 100, 100 };
        c = new Counter(1, timeTest);

        // Test case parameters for Counter are incorrect and reajust
        // For over the limite
        // Manually tested individual value due to Problems that i didn't know how to
        // fix
        aux = c.getClockValue();
        assertTrue(timeRef[0] == aux[0]);
        assertTrue(timeRef[1] == aux[1]);
        assertTrue(timeRef[2] == aux[2]);

        timeRef = new int[] { 2, 50, 40 };
        // Pass valid values for the Counter
        timeTest = new int[] { 2, 50, 40 };
        c = new Counter(-1, timeTest);

        // Test case parameters for Counter are Correct
        // Testing with a regressive because it starts with the number it was passed
        // Manually tested individual value due to Problems that i didn't know how to
        // fix
        aux = c.getClockValue();
        assertTrue(timeRef[0] == aux[0]);
        assertTrue(timeRef[1] == aux[1]);
        assertTrue(timeRef[2] == aux[2]);

    }

    @Test
    void counterRunTest() {
        int[] timeRef = { 0, 0, 0 };
        int[] timeTest = { 0, 0, 0 };
        Counter c = new Counter(1, timeTest);

        c = new Counter(-1, timeTest);
        c.runCounter();
        // Testing if time won't be negative
        int[] aux = c.getClockValue();
        assertTrue(timeRef[0] == aux[0]);
        assertTrue(timeRef[1] == aux[1]);
        assertTrue(timeRef[2] == aux[2]);
        // -------------------------------------------

        timeRef = new int[] { 0, 0, 0 };
        // Pass invalid values for the Counter
        timeTest = new int[] { 100, 100, 100 };
        c = new Counter(1, timeTest);
        // Test if will be stuck in 0 0 0 clock for invalid arguments
        c.runCounter();

        aux = c.getClockValue();
        assertTrue(timeRef[0] == aux[0]);
        assertTrue(timeRef[1] == aux[1]);
        assertTrue(timeRef[2] == aux[2]);

        // ---------------------------------------------

        timeRef = new int[] { 0, 0, 1 };
        // Pass valid values for the Counter
        timeTest = new int[] { 2, 50, 40 };
        c = new Counter(1, timeTest);
        c.runCounter();
        // Testing if the running clock is working as expected
        aux = c.getClockValue();
        assertTrue(timeRef[0] == aux[0]);
        assertTrue(timeRef[1] == aux[1]);
        assertTrue(timeRef[2] == aux[2]);

        // ---------------------------------------------

        timeRef = new int[] { 2, 59, 59 };
        // Pass valid values for the Counter
        timeTest = new int[] { 3, 00, 00 };
        c = new Counter(-1, timeTest);
        c.runCounter();
        // Testing if the clock changes correctly
        aux = c.getClockValue();
        assertTrue(timeRef[0] == aux[0]);
        assertTrue(timeRef[1] == aux[1]);
        assertTrue(timeRef[2] == aux[2]);

    }

}
