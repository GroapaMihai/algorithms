package org.bitwise.utils;

public class NumberUtils {
    public static int getNumberOfDigits(Integer number) {
        int numberOfDigits = 0;

        while (number != 0) {
            number = number / 10;
            numberOfDigits++;
        }

        return numberOfDigits;
    }

    /**
     * Extracts the digit at the specified position from the given integer.
     * The position is counted from the least significant digit (1-based index).
     *
     * @param number   The integer from which to extract the digit. If {@code null}, the method returns 0.
     * @param position The 1-based position of the digit to extract, starting from the least significant digit.
     *                 If the position is less than or equal to 0, the method returns 0.
     * @return The digit at the specified position, or 0 if the input is {@code null} or the position is invalid.
     *
     * Example:
     * <pre>
     * getDigitValueByPosition(12345, 1); // Returns 5
     * getDigitValueByPosition(12345, 2); // Returns 4
     * getDigitValueByPosition(12345, 6); // Returns 0 (position exceeds the number of digits)
     * </pre>
     */
    public static int getDigitValueByPosition(Integer number, int position) {
        if (number == null || position <= 0) {
            return 0;
        }

        number = number / (int) Math.pow(10, position - 1); // Adjust for 1-based position

        return Math.abs(number % 10); // Ensure the result is positive
    }
}
