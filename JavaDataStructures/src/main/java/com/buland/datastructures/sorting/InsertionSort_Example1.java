package com.buland.datastructures.sorting;

import java.util.Arrays;
import java.util.List;

public class InsertionSort_Example1 {

    public static void main(String[] args) {
        //int []listToSort = {7, 3, 1, 2};
        int []listToSort = {70, 30, 1, -1, 0, 29, 5};
        insertionSort(listToSort);
        for (int i = 0; i< listToSort.length; i++) {
            System.out.print(listToSort[i] + " , ");
        }
    }

    public static void insertionSort(int[] listToSort) {
        for (int i=0; i<listToSort.length-1; i++) {
            for (int j=i+1; j<listToSort.length; j++) {
                if (listToSort[j] < listToSort[i]) {
                    int tmp = listToSort[i];
                    listToSort[i] = listToSort[j];
                    listToSort[j] = tmp;
                }
            }
        }
    }
}
