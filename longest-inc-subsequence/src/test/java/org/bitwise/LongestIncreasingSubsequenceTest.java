package org.bitwise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LongestIncreasingSubsequenceTest {
    private final LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();

    @Test
    void test1() {
        int listLength = lis.compute(Arrays.asList(3, 10, 2, 1, 20));

        Assertions.assertEquals(3, listLength);
    }
}
