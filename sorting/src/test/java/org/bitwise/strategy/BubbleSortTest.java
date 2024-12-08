package org.bitwise.strategy;

import org.bitwise.testcase.TestCase;
import org.bitwise.testcase.TestCaseConstants;
import org.bitwise.testcase.TestCaseFileUtils;
import org.bitwise.utils.ListUtils;
import org.bitwise.utils.SortingOrder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class BubbleSortTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(BubbleSortTest.class);

    private final BubbleSort bubbleSort = new BubbleSort();

    @Test
    void testDigitsOnlyList() {
        TestCase digitsOnlyTC = TestCaseFileUtils.loadTestCaseFromFile(TestCaseConstants.DIGITS_ONLY_4);

        LOGGER.info("[START] BubbleSort - {}", digitsOnlyTC.getDescription());
        bubbleSort.sort(digitsOnlyTC.getList(), SortingOrder.ASCENDING);
        LOGGER.info("[END] BubbleSort - {}", digitsOnlyTC.getDescription());

        Assertions.assertTrue(ListUtils.isSorted(digitsOnlyTC.getList(), SortingOrder.ASCENDING));
    }
}
