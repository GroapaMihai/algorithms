package org.bitwise;

public class BinarySearch {
    public int search(int[] arr, int value) {
        return searchRecursively(arr, value, 0, arr.length - 1);
    }

    private int searchRecursively(int[] arr, int value, int start, int end) {
        if (start > end) {
            return -1;
        }

        int middle = start + (end - start) / 2;

        if (arr[middle] == value) {
            return middle;
        } else if (value < arr[middle]) {
            return searchRecursively(arr, value, start, middle - 1);
        } else {
            return searchRecursively(arr, value, middle + 1, end);
        }
    }
}
