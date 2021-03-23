package stringcalc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalcTest {
    StringCalc stringCalc = new StringCalc();

    @Test
    void testAddNoNumber() {

        var actual = stringCalc.add("");
        assertEquals(0, actual);
    }

    @Test
    void testOneNumber() {
        var actual = stringCalc.add("1");
        assertEquals(1, actual);
    }

    @Test
    void testAddTwoNumbers() {
        var actual = stringCalc.add("1,2");
        assertEquals(3, actual);
    }

    @Test
    void testMoreThanTwoNumbers() {
        var actual = stringCalc.add("1,2,3,4,5");
        assertEquals(15, actual);
    }

    @Test
    void testWithMultipleRegEx() {
        var actual = stringCalc.add("1\n2,3");
        assertEquals(6, actual);
    }

}