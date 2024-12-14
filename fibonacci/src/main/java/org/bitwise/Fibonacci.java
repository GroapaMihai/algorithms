package org.bitwise;

public class Fibonacci {
    private int[] memo;

    /**
     * Generates the nth Fibonacci number using memoization.
     *
     * Time Complexity: O(n)
     * Each Fibonacci number is computed once and stored in the memo array,
     * resulting in a linear time complexity.
     *
     * Auxiliary Space: O(n)
     * The memo array consumes O(n) space.
     *
     * @param n The position of the Fibonacci number to generate.
     * @return The nth Fibonacci number.
     */
    public int generate(final int n) {
        if (n < 1) {
            throw new RuntimeException("Bad input value " + n);
        }

        fillMemoList(n);
        return generateRecursively(n);
    }

    /**
     * Recursively computes the nth Fibonacci number.
     *
     * @param n The position of the Fibonacci number to compute.
     * @return The nth Fibonacci number.
     */
    private int generateRecursively(int n) {
        // If the value is already computed, return it
        if (memo[n] != -1) {
            return memo[n];
        }

        // Compute the value recursively and store it in the memo array
        memo[n] = generateRecursively(n - 1) + generateRecursively(n - 2);

        return memo[n];
    }

    /**
     * Initializes the memoization array and sets base cases.
     *
     * @param size The size of the memo array (corresponding to the nth Fibonacci number).
     */
    private void fillMemoList(final int size) {
        memo = new int[1 + size];

        // Initialize all elements to -1 (indicating uncomputed values)
        for (int i = 0; i <= size; i++) {
            memo[i] = -1;
        }

        // Base cases for Fibonacci sequence
        memo[1] = 0;
        memo[2] = 1;
    }
}
