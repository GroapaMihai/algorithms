package org.bitwise;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {
    private List<Integer> memo;

    /**
     * Let L(i) be the length of the LIS ending at index i such that arr[i] is the last element of the LIS.
     * Then, L(i) can be recursively written as:
     * L(i) = 1 + max(L(prev) ) where 0 < prev < i and arr[prev] < arr[i]; or
     * L(i) = 1, if no such prev exists.
     * Formally, the length of LIS ending at index i, is 1 greater than the maximum of lengths of all
     * LIS ending at some index prev such that arr[prev] < arr[i] where prev < i.
     * After we fill the L array, we find LIS as maximum of all in L[]
     * Overall LIS =  max(L[i])  where 0 <= i < n
     *
     * @param list the list for which we compute the longest increasing subsequence
     * @return the length of longest increasing subsequence
     */
    public int compute(final List<Integer> list) {
        int max = 0;

        fillMemoList(list.size());

        for (int i = 0; i < list.size(); i++) {
            int result = lisEndingAtIdx(list, i);

            if (result > max) {
                max = result;
                System.out.print(list.get(i) + " ");
            }
        }

        System.out.println();

        return max;
    }

    private int lisEndingAtIdx(final List<Integer> list, int index) {
        if (index == 0) {
            return 1;
        }

        if (memo.get(index) != -1) {
            return memo.get(index);
        }

        int max = 0;
        for (int prev = 0; prev < index; prev++) {
            int lisPrev = lisEndingAtIdx(list, prev);

            if (lisPrev > max && list.get(prev) < list.get(index)) {
                max = lisPrev;
            }
        }

        memo.set(index, 1 + max);

        return 1 + max;
    }

    private void fillMemoList(final int size) {
        memo = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            memo.add(-1);
        }
    }
}
