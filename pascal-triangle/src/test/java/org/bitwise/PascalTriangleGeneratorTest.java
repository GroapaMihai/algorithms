package org.bitwise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class PascalTriangleGeneratorTest {
    private static PascalTriangleGenerator generator;

    private static PascalTriangleConsolePrinter consolePrinter;

    @BeforeAll
    static void beforeAll() {
        generator = new PascalTriangleGenerator();
        consolePrinter = new PascalTriangleConsolePrinter();
    }

    @Test
    void testBadNumberOfRows() {
        int[][] triangle = generator.generatePascalTriangle(-1);

        Assertions.assertNull(triangle);
    }

    @Test
    void testGeneratePascalTriangle() {
        int[][] triangle = generator.generatePascalTriangle(8);

        consolePrinter.printPascalTriangle(triangle);

        Assertions.assertEquals(1, triangle[0][0]);
        Assertions.assertEquals(2, triangle[2][1]);
        Assertions.assertEquals(10, triangle[5][2]);
        Assertions.assertEquals(1, triangle[7][7]);
    }
}
