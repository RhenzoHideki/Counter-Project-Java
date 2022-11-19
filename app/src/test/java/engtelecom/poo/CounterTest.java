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
        // Manually tested individual value due to Problems that i didn't know how to
        // fix
        int[] aux = c.getClockValue();
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

    }

}
