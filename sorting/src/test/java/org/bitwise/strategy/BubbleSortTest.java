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

    @Test
    void test10KList() {
        TestCase mediumListTC = TestCaseFileUtils.loadTestCaseFromFile(TestCaseConstants.MEDIUM_10K_5);
        int listSize = mediumListTC.getList().size();

        LOGGER.info("[START] BubbleSort - {}", mediumListTC.getDescription());
        bubbleSort.sort(mediumListTC.getList(), SortingOrder.ASCENDING);
        LOGGER.info("[END] BubbleSort - {}", mediumListTC.getDescription());

        Assertions.assertEquals(listSize, mediumListTC.getList().size());
        Assertions.assertTrue(ListUtils.isSorted(mediumListTC.getList(), SortingOrder.ASCENDING));
    }

    @Test
    void test100KList() {
        TestCase bigListTC = TestCaseFileUtils.loadTestCaseFromFile(TestCaseConstants.BIG_100K_6);
        int listSize = bigListTC.getList().size();

        LOGGER.info("[START] BubbleSort - {}", bigListTC.getDescription());
        bubbleSort.sort(bigListTC.getList(), SortingOrder.ASCENDING);
        LOGGER.info("[END] BubbleSort - {}", bigListTC.getDescription());

        Assertions.assertEquals(listSize, bigListTC.getList().size());
        Assertions.assertTrue(ListUtils.isSorted(bigListTC.getList(), SortingOrder.ASCENDING));
    }
}
