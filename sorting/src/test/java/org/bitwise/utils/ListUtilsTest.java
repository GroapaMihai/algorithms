package org.bitwise.utils;

import org.bitwise.testcase.TestCase;
import org.bitwise.testcase.TestCaseConstants;
import org.bitwise.testcase.TestCaseFileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ListUtilsTest {
    @Test
    void givenUnsortedList_whenIsSortedAscending_thenReturnFalse() {
        TestCase unsortedShortTC = TestCaseFileUtils.loadTestCaseFromFile(TestCaseConstants.SHORT_1);

        boolean result = ListUtils.isSorted(unsortedShortTC.getList(), SortingOrder.ASCENDING);

        Assertions.assertFalse(result);
    }

    @Test
    void givenUnsortedList_whenIsSortedDescending_thenReturnFalse() {
        TestCase unsortedShortTC = TestCaseFileUtils.loadTestCaseFromFile(TestCaseConstants.SHORT_1);

        boolean result = ListUtils.isSorted(unsortedShortTC.getList(), SortingOrder.DESCENDING);

        Assertions.assertFalse(result);
    }

    @Test
    void givenSortedAscendingList_whenIsSortedAscending_thenReturnTrue() {
        TestCase sortedAscendingTC = TestCaseFileUtils.loadTestCaseFromFile(TestCaseConstants.SORTED_ASC_2);

        boolean result = ListUtils.isSorted(sortedAscendingTC.getList(), SortingOrder.ASCENDING);

        Assertions.assertTrue(result);
    }

    @Test
    void givenSortedAscendingList_whenIsSortedDescending_thenReturnFalse() {
        TestCase sortedAscendingTC = TestCaseFileUtils.loadTestCaseFromFile(TestCaseConstants.SORTED_ASC_2);

        boolean result = ListUtils.isSorted(sortedAscendingTC.getList(), SortingOrder.DESCENDING);

        Assertions.assertFalse(result);
    }

    @Test
    void givenSortedDescendingList_whenIsSortedDescending_thenReturnTrue() {
        TestCase sortedDescendingTC = TestCaseFileUtils.loadTestCaseFromFile(TestCaseConstants.SORTED_DESC_3);

        boolean result = ListUtils.isSorted(sortedDescendingTC.getList(), SortingOrder.DESCENDING);

        Assertions.assertTrue(result);
    }

    @Test
    void givenSortedDescendingList_whenIsSortedAscending_thenReturnFalse() {
        TestCase sortedDescendingTC = TestCaseFileUtils.loadTestCaseFromFile(TestCaseConstants.SORTED_DESC_3);

        boolean result = ListUtils.isSorted(sortedDescendingTC.getList(), SortingOrder.ASCENDING);

        Assertions.assertFalse(result);
    }
}
