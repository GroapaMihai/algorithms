package org.bitwise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinarySearchTest {
    BinarySearch binarySearch = new BinarySearch();

    @Test
    void testEmptyArray() {
        int result = binarySearch.search(new int[]{}, 10);

        Assertions.assertEquals(-1, result);
    }

    @Test
    void testOneElementArrayFound() {
        int result = binarySearch.search(new int[]{10}, 10);

        Assertions.assertEquals(0, result);
    }

    @Test
    void testOneElementArrayNotFound() {
        int result = binarySearch.search(new int[]{10}, 101);

        Assertions.assertEquals(-1, result);
    }

    @Test
    void testTwoElementArrayFoundAtIndex0() {
        int result = binarySearch.search(new int[]{10, 20}, 10);

        Assertions.assertEquals(0, result);
    }

    @Test
    void testTwoElementArrayFoundAtIndex1() {
        int result = binarySearch.search(new int[]{10, 20}, 20);

        Assertions.assertEquals(1, result);
    }

    @Test
    void testTwoElementArrayNotFound() {
        int result = binarySearch.search(new int[]{10, 20}, 15);

        Assertions.assertEquals(-1, result);
    }

    @Test
    void testOddLengthArrayFound() {
        int result = binarySearch.search(new int[]{2, 3, 4, 10, 40}, 3);

        Assertions.assertEquals(1, result);
    }

    @Test
    void testEvenLengthArrayFound() {
        int result = binarySearch.search(new int[]{2, 3, 4, 10, 40, 101}, 40);

        Assertions.assertEquals(4, result);
    }

    @Test
    void testLongerArrayFound() {
        int result = binarySearch.search(new int[]{2, 5, 8, 12, 16, 23, 38, 56, 72, 91}, 91);

        Assertions.assertEquals(9, result);
    }

    @Test
    void testLongerArrayNotFound() {
        int result = binarySearch.search(new int[]{2, 5, 8, 12, 16, 23, 38, 56, 72, 91}, 169);

        Assertions.assertEquals(-1, result);
    }
}
