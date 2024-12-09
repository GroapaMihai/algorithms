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

public class RadixSortTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(RadixSortTest.class);

    private final RadixSort radixSort = new RadixSort();

    @Test
    void testShortList() {
        TestCase shortListTC = TestCaseFileUtils.loadTestCaseFromFile(TestCaseConstants.SHORT_1);
        int listSize = shortListTC.getList().size();

        LOGGER.info("[START] RadixSort - {}", shortListTC.getDescription());
        radixSort.sort(shortListTC.getList(), SortingOrder.ASCENDING);
        LOGGER.info("[END] RadixSort - {}", shortListTC.getDescription());

        Assertions.assertEquals(listSize, shortListTC.getList().size());
        Assertions.assertTrue(ListUtils.isSorted(shortListTC.getList(), SortingOrder.ASCENDING));
    }

    @Test
    void testDigitsOnlyList() {
        TestCase digitsOnlyTC = TestCaseFileUtils.loadTestCaseFromFile(TestCaseConstants.DIGITS_ONLY_4);
        int listSize = digitsOnlyTC.getList().size();

        LOGGER.info("[START] RadixSort - {}", digitsOnlyTC.getDescription());
        radixSort.sort(digitsOnlyTC.getList(), SortingOrder.ASCENDING);
        LOGGER.info("[END] RadixSort - {}", digitsOnlyTC.getDescription());

        Assertions.assertEquals(listSize, digitsOnlyTC.getList().size());
        Assertions.assertTrue(ListUtils.isSorted(digitsOnlyTC.getList(), SortingOrder.ASCENDING));
    }

    @Test
    void test10KList() {
        TestCase mediumListTC = TestCaseFileUtils.loadTestCaseFromFile(TestCaseConstants.MEDIUM_10K_5);
        int listSize = mediumListTC.getList().size();

        LOGGER.info("[START] RadixSort - {}", mediumListTC.getDescription());
        radixSort.sort(mediumListTC.getList(), SortingOrder.ASCENDING);
        LOGGER.info("[END] RadixSort - {}", mediumListTC.getDescription());

        Assertions.assertEquals(listSize, mediumListTC.getList().size());
        Assertions.assertTrue(ListUtils.isSorted(mediumListTC.getList(), SortingOrder.ASCENDING));
    }

    @Test
    void test100KList() {
        TestCase bigListTC = TestCaseFileUtils.loadTestCaseFromFile(TestCaseConstants.BIG_100K_6);
        int listSize = bigListTC.getList().size();

        LOGGER.info("[START] RadixSort - {}", bigListTC.getDescription());
        radixSort.sort(bigListTC.getList(), SortingOrder.ASCENDING);
        LOGGER.info("[END] RadixSort - {}", bigListTC.getDescription());

        Assertions.assertEquals(listSize, bigListTC.getList().size());
        Assertions.assertTrue(ListUtils.isSorted(bigListTC.getList(), SortingOrder.ASCENDING));
    }
}
