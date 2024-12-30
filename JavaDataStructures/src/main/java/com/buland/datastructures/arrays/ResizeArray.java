package com.buland.datastructures.arrays;

import java.util.Arrays;

public class ResizeArray {

    public static void main(String[] args) {
        int [] numbers = {1,2,3,4};

        System.out.printf("\nNumbers Array before resize: %s\n", Arrays.toString(numbers));
        int []tmpArr = resizeArr(numbers, numbers.length * 2);
        System.out.printf("\nNumbers Array after resize: %s\n", Arrays.toString(numbers));
        System.out.printf("\nTemp Array after resize: %s\n", Arrays.toString(tmpArr));
    }

    private static int[] resizeArr(int[] numbers, int capacity) {
        int [] tmpArr = new int[capacity];
        for (int i=0; i<numbers.length; i++) {
            tmpArr[i] = numbers[i];
        }
        numbers = tmpArr; //after method is completed exeuction, it becomes part of garbage collection
        System.out.printf("\nInside, Numbers Array after resize before garbage collected : %s\n", Arrays.toString(numbers));
        return tmpArr;
    }
}
