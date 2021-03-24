package stringcalc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalcTest {
    StringCalc stringCalc = new StringCalc();

    @Test
    void testingAddNoNumber() {

        var actual = stringCalc.add("");
        assertEquals(0, actual);
    }

    @Test
    void testingOneNumber() {
        var actual = stringCalc.add("1");
        assertEquals(1, actual);
    }

    @Test
    void testingAddTwoNumbers() {
        var actual = stringCalc.add("1,2");
        assertEquals(3, actual);
    }

    @Test
    void testingMoreThanTwoNumbers() {
        var actual = stringCalc.add("1,2,3,4,5");
        assertEquals(15, actual);
    }

    @Test
    void testingWithMultipleRegEx() {
        var actual = stringCalc.add("1\n2,3");
        assertEquals(6, actual);
    }

    @Test
    void testingWithNewDelimiterMethod() {
        var actual = stringCalc.add("//;\n1;2");
        assertEquals(3, actual);
    }

    @Test
    void testNegativeNumbersNotAccepted() {
      var answer = assertThrows(IllegalArgumentException.class, () -> stringCalc.add("1,5,10,-5,-80"));
      assertEquals("Negatives not allowed [-5, -80]", answer.getMessage());
    }
    @Test
    void testingNumberBiggerThanThousand() {
        var actual = stringCalc.add("2,1001");
        assertEquals(2, actual);
    }

    @Test
    void testingDelimiterOfAnyLength() {
        var actual = stringCalc.add("//[***]\n1***2***3");
        assertEquals(6, actual);
    }

    @Test
    void testingMutlipleDelimiters() {
        var actual = stringCalc.add("//[*][%]\n1*2%3");
        assertEquals(6, actual);
    }

    @Test
    void testingMutlipleDelimitersWithAnyLength() {
        var actual = stringCalc.add("//[*&¤/%%/][%¤&/(%]\n1/&((*2*(%(%3");
        assertEquals(6, actual);
    }



}