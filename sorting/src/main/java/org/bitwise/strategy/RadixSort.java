package org.bitwise.strategy;

import org.bitwise.ISortingAlgorithm;
import org.bitwise.utils.ListUtils;
import org.bitwise.utils.NumberUtils;
import org.bitwise.utils.SortingOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class RadixSort implements ISortingAlgorithm {
    private static final Logger LOGGER = LoggerFactory.getLogger(RadixSort.class);

    private final Map<Integer, List<Integer>> buckets;

    public RadixSort() {
        this.buckets = new HashMap<>();

        for (int bucketIndex = 0; bucketIndex < 10; bucketIndex++) {
            buckets.put(bucketIndex, new ArrayList<>());
        }
    }

    /**
     * Sorts the given list of integers using the Radix Sort algorithm.
     *
     * @param list          The list of integers to be sorted.
     *                      If the list is empty, the method exits early.
     * @param sortingOrder  The order in which to sort the list (ascending or descending).
     */
    @Override
    public void sort(List<Integer> list, SortingOrder sortingOrder) {
        Integer minValue = ListUtils.getMinElement(list);
        Integer maxValue = ListUtils.getMaxElement(list);

        // the list is empty
        if (minValue == null || maxValue == null) {
            LOGGER.debug("The list is empty. No need to sort.");
            return;
        }

        int maxNumberOfDigits = Integer.max(NumberUtils.getNumberOfDigits(minValue),
                NumberUtils.getNumberOfDigits(maxValue));

        LOGGER.debug("Max number of digits: {}", maxNumberOfDigits);

        for (int digitPosition = 1; digitPosition <= maxNumberOfDigits; digitPosition++) {
            populateBucketsByDigitPosition(list, digitPosition);
            populateListUsingBuckets(list);
        }

        shiftLeftNegativeNumbers(list);

        if (sortingOrder == SortingOrder.DESCENDING) {
            ListUtils.reverseList(list);
        }
    }

    /**
     * Groups the elements of the input list into buckets based on the digit at the specified position.
     * Each bucket corresponds to a digit value (0-9). The method uses the specified digit position
     * to determine the bucket for each element and updates the bucket structure accordingly.
     *
     * @param list          The list of integers to be grouped into buckets.
     *                      This list is processed element by element.
     * @param digitPosition The 1-based position of the digit to use for bucket assignment.
     *                      For example, if {@code digitPosition} is 1, the least significant digit is used.
     *
     * Precondition:
     * - The buckets structure must be initialized and contain 10 lists (one for each digit 0-9).
     * - The input list must contain integers.
     *
     * Postcondition:
     * - Each element in the input list is added to the appropriate bucket based on its digit value
     *   at the specified position.
     */
    private void populateBucketsByDigitPosition(final List<Integer> list, final int digitPosition) {
        for (Integer element : list) {
            int bucketIndex = NumberUtils.getDigitValueByPosition(element, digitPosition);

            buckets.get(bucketIndex).add(element);
        }
    }

    /**
     * Populates the input list by extracting elements from the buckets in order
     * and clears the buckets after processing. The list is updated in-place with
     * the sorted order derived from the bucket contents.
     *
     * @param list The list to be populated with elements from the buckets.
     *             The list is modified in-place.
     *
     * Precondition:
     * - The `buckets` structure must be initialized with 10 lists (one for each digit 0-9).
     * - Each bucket contains elements grouped from a previous sorting step.
     *
     * Postcondition:
     * - The input list is updated in-place with elements in the order they appear in the buckets.
     * - All buckets are cleared after processing.
     */
    private void populateListUsingBuckets(List<Integer> list) {
        int indexInsideList = 0;

        for (int bucketIndex = 0; bucketIndex < 10; bucketIndex++) {
            for (Integer element : buckets.get(bucketIndex)) {
                list.set(indexInsideList++, element);
            }

            buckets.put(bucketIndex, new ArrayList<>());
        }
    }

    /**
     * Modifies the input list by moving all negative numbers to the beginning,
     * sorted in ascending order, while preserving the relative order of non-negative numbers.
     *
     * @param list The list of integers to be modified. The list is updated in-place.
     */
    private void shiftLeftNegativeNumbers(final List<Integer> list) {
        List<Integer> negatives = new ArrayList<>();
        Iterator<Integer> iterator = list.iterator();

        // Extract negative numbers
        while (iterator.hasNext()) {
            Integer element = iterator.next();

            if (element < 0) {
                negatives.add(0, element);
                iterator.remove();
            }
        }

        // Add sorted negative numbers back at the start
        list.addAll(0, negatives);
    }
}
