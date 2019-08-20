package com.share.algorithm;

public class Sorter<T extends Comparable<T>> {
    public static <T extends Comparable<T>> void selectionSort(T[] arr) {
        int len = arr.length;
        int index = 0;
        for (int i = 0; i < len - 1; i++) {
            index = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[j].compareTo(arr[index]) < 0) {
                    index = j;
                }
            }

            swap(arr, i, index);

        }
    }

    public static <T extends Comparable<T>> void insertionSort(T[] arr) {
        int len = arr.length;
        T temp = null;
        for (int i = 1; i < len; i++) {
            temp = arr[i];
            int j = i - 1;
            for (; j >= 0 && temp.compareTo(arr[j]) < 0; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = temp;
        }
    }

    public static <T extends Comparable<T>> void bubboSort(T[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = 1; j < len - i; j++) {
                if (arr[j].compareTo(arr[j - 1]) < 0) {
                    swap(arr, j, j - 1);
                }
            }
        }
    }

    public static <T extends Comparable<T>> void mergeSort(T[] arr) {
        mergeSort(arr, 0, arr.length);
    }

    private static <T extends Comparable<T>> void mergeSort(T[] arr, int start, int end) {
        if ((end - start) == 1) {
            return;
        }

        int mid = (start + end) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid, end);
        int rightIndex = mid, leftIndex = start;

        T[] ret = (T[]) new Comparable[end - start];
        for (int i = 0; i < end - start; i++) {
            if (leftIndex >= mid) {
                ret[i] = arr[rightIndex];
                rightIndex++;
            } else if (rightIndex >= end) {
                ret[i] = arr[leftIndex];
                leftIndex++;
            } else if (arr[leftIndex].compareTo(arr[rightIndex]) < 0) {
                ret[i] = arr[leftIndex];
                leftIndex++;
            } else {
                ret[i] = arr[rightIndex];
                rightIndex++;
            }
        }

        for (int i = start; i < end; i++) {
            arr[i] = ret[i - start];
        }
    }

    public static <T extends Comparable<T>> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] intArr = {1, 3, 4, 2, 68, 6, 7,10};
        //selectionSort(intArr);
        //insertionSort(intArr);
        //bubboSort(intArr);
        mergeSort(intArr);
        for (int i = 0; i < intArr.length; i++) {
            System.out.println(intArr[i]);
        }
    }
}
