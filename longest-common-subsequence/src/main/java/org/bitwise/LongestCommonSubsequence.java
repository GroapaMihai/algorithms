package org.bitwise;

public class LongestCommonSubsequence {
    private int[][] memo;

    private String str1;

    private String str2;

    public int compute(final String str1, final String str2) {
        this.str1 = str1;
        this.str2 = str2;

        fillMemoMatrix();

        return computeRecursively(str1, str2, str1.length() - 1, str2.length() - 1);
    }

    private int computeRecursively(final String str1,
                                   final String str2,
                                   int row,
                                   int column) {
        if (row < 0 || column < 0) {
            return 0;
        }

        if (memo[row][column] != -1) {
            return memo[row][column];
        }

        boolean charactersMatch = (str1.charAt(row) == str2.charAt(column));

        if (charactersMatch) {
            memo[row][column] = 1 + computeRecursively(str1, str2, row - 1, column - 1);
        } else {
            memo[row][column] = Math.max(
                computeRecursively(str1, str2, row - 1, column),
                computeRecursively(str1, str2, row, column - 1)
            );
        }

        return memo[row][column];
    }

    public void printMemoMatrix() {
        System.out.print("  ");

        for (int j = 0; j < str2.length(); j++) {
            System.out.print(str2.charAt(j) + " ");
        }

        System.out.println();

        for (int i = 0; i < memo.length; i++) {
            System.out.print(str1.charAt(i) + " ");

            for (int j = 0; j < memo[i].length; j++) {
                if (memo[i][j] == -1) {
                    System.out.print("_ ");
                } else {
                    System.out.print(memo[i][j] + " ");
                }
            }

            System.out.println();
        }
    }

    private void fillMemoMatrix() {
        memo = new int[str1.length()][str2.length()];

        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                memo[i][j] = -1;
            }
        }
    }
}
