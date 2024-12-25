package org.bitwise;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LongestCommonSubsequenceTest {
    private final LongestCommonSubsequence lcs = new LongestCommonSubsequence();

    @BeforeEach
    void printTestStart() {
        System.out.println("---Test Start---");
    }

    @AfterEach
    void printTestEnd() {
        System.out.println("---Test End---\n");
    }

    @Test
    void test1() {
        int result = lcs.compute("", "");

        lcs.printMemoMatrix();

        Assertions.assertEquals(0, result);
    }

    @Test
    void test2() {
        int result = lcs.compute("", "AGGTAB");

        lcs.printMemoMatrix();

        Assertions.assertEquals(0, result);
    }

    @Test
    void test3() {
        int result = lcs.compute("GXTXAYB", "AGGTAB");

        lcs.printMemoMatrix();

        Assertions.assertEquals(4, result);
    }

    @Test
    void test4() {
        int result = lcs.compute("ABC", "CBA");

        lcs.printMemoMatrix();

        Assertions.assertEquals(1, result);
    }

    @Test
    void test5() {
        int result = lcs.compute("ABC", "ACD");

        lcs.printMemoMatrix();

        Assertions.assertEquals(2, result);
    }
}
