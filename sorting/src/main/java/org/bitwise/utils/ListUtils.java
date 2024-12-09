package org.bitwise.utils;

import java.util.List;

public class ListUtils {
    public static void reverseList(List<Integer> list) {
        for (int i = 0; i < list.size() / 2; i++) {
            int aux = list.get(i);
            list.set(i, list.get(list.size() - 1 - i));
            list.set(list.size() - 1 - i, aux);
        }
    }

    public static boolean isSorted(final List<Integer> list, final SortingOrder sortingOrder) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1) && sortingOrder == SortingOrder.ASCENDING) {
                return false;
            }

            if (list.get(i) < list.get(i + 1) && sortingOrder == SortingOrder.DESCENDING) {
                return false;
            }
        }

        return true;
    }

    public static Integer getMaxElement(final List<Integer> list) {
        if (list.isEmpty()) {
            return null;
        }

        Integer max = Integer.MIN_VALUE;

        for (Integer element : list) {
            if (element > max) {
                max = element;
            }
        }

        return max;
    }

    public static Integer getMinElement(final List<Integer> list) {
        if (list.isEmpty()) {
            return null;
        }

        Integer max = Integer.MAX_VALUE;

        for (Integer element : list) {
            if (element < max) {
                max = element;
            }
        }

        return max;
    }
}
