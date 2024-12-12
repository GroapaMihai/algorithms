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

public class MergeSortTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MergeSortTest.class);

    private final MergeSort mergeSort = new MergeSort();

    @Test
    void testShortList() {
        TestCase shortListTC = TestCaseFileUtils.loadTestCaseFromFile(TestCaseConstants.SHORT_1);
        int listSize = shortListTC.getList().size();

        LOGGER.info("[START] MergeSort - {}", shortListTC.getDescription());
        mergeSort.sort(shortListTC.getList(), SortingOrder.ASCENDING);
        LOGGER.info("[END] MergeSort - {}", shortListTC.getDescription());

        Assertions.assertEquals(listSize, shortListTC.getList().size());
        Assertions.assertTrue(ListUtils.isSorted(shortListTC.getList(), SortingOrder.ASCENDING));
    }

    @Test
    void test10KList() {
        TestCase mediumListTC = TestCaseFileUtils.loadTestCaseFromFile(TestCaseConstants.MEDIUM_10K_5);
        int listSize = mediumListTC.getList().size();

        LOGGER.info("[START] MergeSort - {}", mediumListTC.getDescription());
        mergeSort.sort(mediumListTC.getList(), SortingOrder.ASCENDING);
        LOGGER.info("[END] MergeSort - {}", mediumListTC.getDescription());

        Assertions.assertEquals(listSize, mediumListTC.getList().size());
        Assertions.assertTrue(ListUtils.isSorted(mediumListTC.getList(), SortingOrder.ASCENDING));
    }

    @Test
    void test100KList() {
        TestCase bigListTC = TestCaseFileUtils.loadTestCaseFromFile(TestCaseConstants.BIG_100K_6);
        int listSize = bigListTC.getList().size();

        LOGGER.info("[START] MergeSort - {}", bigListTC.getDescription());
        mergeSort.sort(bigListTC.getList(), SortingOrder.ASCENDING);
        LOGGER.info("[END] MergeSort - {}", bigListTC.getDescription());

        Assertions.assertEquals(listSize, bigListTC.getList().size());
        Assertions.assertTrue(ListUtils.isSorted(bigListTC.getList(), SortingOrder.ASCENDING));
    }
}
