package com.google.search;

import java.util.Objects;

public class binarySearchArrayWithSomeEmptyElements {
    public static int findElementIndex(String[] inputArray, String elementToFind) {
        if (inputArray.length == 0) {
            return Integer.MIN_VALUE;
        }

        return searchElement(inputArray, 0, inputArray.length - 1, elementToFind);
    }

    private static int searchElement(String[] a, int left, int right, String x) {
        int mid = (left + right) / 2;

        for (int i = mid; i < right; i++) {
            if (Objects.equals(a[i], x)) {
                return i;
            } else if (isSmaller(x, a[i])) {
                return searchElement(a, left, i, x);
            }
        }

        for (int i = mid; i > left; i--) {
            if (Objects.equals(a[i], x)) {
                return i;
            } else if (isSmaller(a[i], x)) {
                return searchElement(a, i, right, x);
            }
        }

        return Integer.MIN_VALUE;
    }

    private static boolean isSmaller(String a, String b) {
        int compare = a.compareTo(b);

        return compare < 0;
    }
}
