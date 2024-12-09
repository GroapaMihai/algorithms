package org.bitwise.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumberUtilsTest {
    @Test
    void testDigit_1_Of_12345_Is_5() {
        int digit = NumberUtils.getDigitValueByPosition(12345, 1);

        Assertions.assertEquals(5, digit);
    }

    @Test
    void testDigit_2_Of_12345_Is_4() {
        int digit = NumberUtils.getDigitValueByPosition(12345, 2);

        Assertions.assertEquals(4, digit);
    }

    @Test
    void testDigit_5_Of_12345_Is_1() {
        int digit = NumberUtils.getDigitValueByPosition(12345, 5);

        Assertions.assertEquals(1, digit);
    }

    @Test
    void testDigit_6_Of_12345_Is_0() {
        int digit = NumberUtils.getDigitValueByPosition(12345, 6);

        Assertions.assertEquals(0, digit);
    }

    @Test
    void testDigit_1_Of_Negative12345_Is_5() {
        int digit = NumberUtils.getDigitValueByPosition(-12345, 1);

        Assertions.assertEquals(5, digit);
    }

    @Test
    void testDigit_2_Of_Negative12345_Is_4() {
        int digit = NumberUtils.getDigitValueByPosition(-12345, 2);

        Assertions.assertEquals(4, digit);
    }

    @Test
    void testDigit_5_Of_Negative12345_Is_1() {
        int digit = NumberUtils.getDigitValueByPosition(-12345, 5);

        Assertions.assertEquals(1, digit);
    }

    @Test
    void testDigit_6_Of_Negative12345_Is_0() {
        int digit = NumberUtils.getDigitValueByPosition(-12345, 6);

        Assertions.assertEquals(0, digit);
    }
}
