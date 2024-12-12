package org.bitwise.strategy;

import org.bitwise.ISortingAlgorithm;
import org.bitwise.utils.ListUtils;
import org.bitwise.utils.SortingOrder;

import java.util.List;

public class MergeSort implements ISortingAlgorithm {
    @Override
    public void sort(List<Integer> list, SortingOrder sortingOrder) {
        mergeSort(list);

        if (SortingOrder.DESCENDING == sortingOrder) {
            ListUtils.reverseList(list);
        }
    }

    private void mergeSort(List<Integer> list) {
        if (list.size() < 2) {
            return;
        }

        int middle = list.size() / 2;
        List<Integer> leftHalf = ListUtils.extractSublist(list, 0, middle - 1);
        List<Integer> rightHalf = ListUtils.extractSublist(list, middle, list.size() - 1);

        mergeSort(leftHalf);
        mergeSort(rightHalf);
        merge(leftHalf, rightHalf, list);
    }

    private void merge(final List<Integer> leftHalf,
                       final List<Integer> rightHalf,
                       List<Integer> list) {
        int leftIndex = 0, rightIndex = 0, listIndex = 0;

        while (leftIndex < leftHalf.size() && rightIndex < rightHalf.size()) {
            if (leftHalf.get(leftIndex) < rightHalf.get(rightIndex)) {
                list.set(listIndex++, leftHalf.get(leftIndex++));
            } else {
                list.set(listIndex++, rightHalf.get(rightIndex++));
            }
        }

        while (leftIndex < leftHalf.size()) {
            list.set(listIndex++, leftHalf.get(leftIndex++));
        }

        while (rightIndex < rightHalf.size()) {
            list.set(listIndex++, rightHalf.get(rightIndex++));
        }
    }
}
