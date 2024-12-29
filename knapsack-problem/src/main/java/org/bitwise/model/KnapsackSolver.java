package org.bitwise.model;

import java.util.List;

/**
 * A solver for the 0/1 Knapsack problem, which aims to maximize the value of items in a knapsack
 * without exceeding its capacity. This implementation uses memoization to optimize recursive
 * computation.
 */
public class KnapsackSolver {

  private int[][] memo;

  /**
   * Solves the 0/1 Knapsack problem for the given list of items and knapsack capacity.
   *
   * @param items            A list of items, where each item has a weight and a value.
   * @param knapsackCapacity The maximum weight capacity of the knapsack.
   * @return The maximum profit that can be achieved without exceeding the knapsack capacity.
   */
  public int solve(final List<Item> items, final int knapsackCapacity) {
    fillMemo(items.size(), knapsackCapacity);

    return solveRecursively(items, knapsackCapacity, 0, 0);
  }

  /**
   * A helper method to recursively solve the 0/1 Knapsack problem.
   *
   * @param items                 A list of items, where each item has a weight and a value.
   * @param knapsackCapacity      The maximum weight capacity of the knapsack.
   * @param currentItemIndex      The current index of the item being considered.
   * @param currentKnapsackWeight The current total weight of the knapsack.
   * @return The maximum profit that can be achieved from the current state onward.
   */
  private int solveRecursively(final List<Item> items,
      final int knapsackCapacity,
      int currentItemIndex,
      int currentKnapsackWeight) {
    if (currentItemIndex == items.size() || knapsackCapacity <= 0) {
      return 0;
    } else if (memo[currentItemIndex][currentKnapsackWeight] != -1) {
      // this case was already computed, return the profit directly
      return memo[currentItemIndex][currentKnapsackWeight];
    }

    int currentItemWeight = items.get(currentItemIndex).getWeight();
    int currentItemValue = items.get(currentItemIndex).getValue();

    // current item cannot be added in the knapsack
    if (currentItemWeight + currentKnapsackWeight > knapsackCapacity) {
      memo[currentItemIndex][currentKnapsackWeight] = solveRecursively(items, knapsackCapacity,
          1 + currentItemIndex, currentKnapsackWeight);
    } else {
      // Move to the next item without adding the current one
      int value1 = solveRecursively(items, knapsackCapacity, 1 + currentItemIndex,
          currentKnapsackWeight);

      // Move to the next item and add the current one
      int value2 =
          currentItemValue + solveRecursively(items, knapsackCapacity, 1 + currentItemIndex,
              currentKnapsackWeight + currentItemWeight);

      memo[currentItemIndex][currentKnapsackWeight] = Math.max(value1, value2);
    }

    return memo[currentItemIndex][currentKnapsackWeight];
  }

  /**
   * Initializes the memoization table used to store intermediate results.
   *
   * @param nbOfItems        The total number of items.
   * @param knapsackCapacity The maximum weight capacity of the knapsack.
   */
  private void fillMemo(final int nbOfItems, final int knapsackCapacity) {
    memo = new int[nbOfItems][1 + knapsackCapacity];

    for (int i = 0; i < nbOfItems; i++) {
      for (int j = 0; j <= knapsackCapacity; j++) {
        memo[i][j] = -1;
      }
    }
  }
}
