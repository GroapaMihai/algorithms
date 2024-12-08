package org.bitwise.strategy;

import org.bitwise.ISortingAlgorithm;
import org.bitwise.utils.ListUtils;
import org.bitwise.utils.SortingOrder;

import java.util.List;

public class BubbleSort implements ISortingAlgorithm {
    @Override
    public void sort(List<Integer> list, SortingOrder sortingOrder) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) > list.get(j)) {
                    int aux = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, aux);
                }
            }
        }

        if (sortingOrder == SortingOrder.DESCENDING) {
            ListUtils.reverseList(list);
        }
    }
}
