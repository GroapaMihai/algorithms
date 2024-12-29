package org.bitwise;

import java.util.List;
import org.bitwise.model.Item;
import org.bitwise.model.KnapsackSolver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class KnapsackSolverTest {

  private final KnapsackSolver knapsackSolver = new KnapsackSolver();

  @Test
  void testCase1_withCapacity_0() {
    List<Item> items = TestCaseFileUtils.loadItemsFromFile("test-case-1.json");

    int profit = knapsackSolver.solve(items, 0);

    Assertions.assertEquals(0, profit);
  }

  @Test
  void testCase1_withCapacity_10() {
    List<Item> items = TestCaseFileUtils.loadItemsFromFile("test-case-1.json");

    int profit = knapsackSolver.solve(items, 10);

    Assertions.assertEquals(24, profit);
  }

  @Test
  void testCase1_withCapacity_11() {
    List<Item> items = TestCaseFileUtils.loadItemsFromFile("test-case-1.json");

    int profit = knapsackSolver.solve(items, 11);

    Assertions.assertEquals(28, profit);
  }

  @Test
  void testCase2_withCapacity_15() {
    List<Item> items = TestCaseFileUtils.loadItemsFromFile("test-case-2.json");

    int profit = knapsackSolver.solve(items, 15);

    Assertions.assertEquals(42, profit);
  }
}
