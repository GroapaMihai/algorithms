package org.bitwise;

import org.bitwise.utils.SortingOrder;

import java.util.List;

public interface ISortingAlgorithm {
    void sort(List<Integer> list, final SortingOrder sortingOrder);
}
