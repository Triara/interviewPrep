package com.google.search;

public class searchIntoARotatedSortedArray {
    public static int findElementIndex(int inputArray[], int elementToFind) {
        if (inputArray.length == 0) {
            return -1;
        }
        int left = inputArray[0];
        int right = inputArray[inputArray.length - 1];

        return search(inputArray, left, right, elementToFind);
    }

    private static int search(int inputArray[], int left, int right, int elementToFind) {
        int mid = (left + right) / 2;
        if (elementToFind == inputArray[mid]) {
            return mid;
        }
        if (right < left) {
            return -1;
        }

        if (inputArray[left] < inputArray[right]) {
            if (inputArray[left] <= elementToFind && elementToFind <= inputArray[mid]) {
                return search(inputArray, left, mid - 1, elementToFind);
            } else {
                return search(inputArray, mid + 1, right, elementToFind);
            }
        } else if (inputArray[mid] < inputArray[left]) {
            if (inputArray[mid] <= elementToFind && elementToFind <= inputArray[right]) {
                return search(inputArray, mid + 1, right, elementToFind);
            } else {
                return search(inputArray, left, mid - 1, elementToFind);
            }
        } else if (inputArray[left] == inputArray[mid]) {
            if (inputArray[mid] != inputArray[right]) {
                return search(inputArray, mid + 1, right, elementToFind);
            } else {
                int result = search(inputArray, left, mid - 1, elementToFind);
                if (result == -1) {
                    return search(inputArray, mid + 1, right, elementToFind);
                } else {
                    return result;
                }
            }
        }
        return -1;
    }
}
