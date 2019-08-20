package com.share.algorithm;

public class Sorter<T extends Comparable<T>> {
    public static <T extends Comparable<T>> T[] selectionSort(T[] arr) {
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
        return arr;
    }

    public static <T extends Comparable<T>> T[] insertionSort(T[] arr) {
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

        return arr;

    }

    public static <T extends Comparable<T>> T[] bubboSort(T[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = 1; j < len - i; j++) {
                if (arr[j].compareTo(arr[j - 1]) < 0) {
                    swap(arr, j, j - 1);
                }
            }
        }

        return arr;
    }

    public static <T extends Comparable<T>> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] intArr = {1, 3, 4, 2, 68, 6, 7};
        //selectionSort(intArr);
        //insertionSort(intArr);
        bubboSort(intArr);
        for (int i = 0; i < intArr.length; i++) {
            System.out.println(intArr[i]);
        }
    }
}
