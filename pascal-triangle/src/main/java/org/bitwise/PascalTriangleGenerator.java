package org.bitwise;

public class PascalTriangleGenerator {
    public int[][] generatePascalTriangle(final int rows) {
        if (rows <= 0) {
            System.err.println("Number of rows must be positive");
            return null;
        }

        int[][] triangle = new int[rows][rows];

        // iterate only the portion under the Main Diagonal
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    triangle[i][j] = 1;
                } else {
                    triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
                }
            }
        }

        return triangle;
    }
}
