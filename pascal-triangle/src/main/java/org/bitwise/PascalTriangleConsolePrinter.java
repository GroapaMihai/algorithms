package org.bitwise;

public class PascalTriangleConsolePrinter {
    public void printPascalTriangle(final int[][] triangle) {
        final int rows = triangle.length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(triangle[i][j] + " ");
            }

            System.out.println();
        }
    }
}
