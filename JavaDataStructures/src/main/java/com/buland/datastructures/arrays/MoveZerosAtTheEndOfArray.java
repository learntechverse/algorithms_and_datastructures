package com.buland.datastructures.arrays;

import java.util.Arrays;

public class MoveZerosAtTheEndOfArray {

    public static void main(String[] args) {
        int[] numbers = {0,1,0,4,12};

        swapZerosAtTheEndOfArrayOption1(numbers);
        System.out.printf("\nNew Array after Swapping zeros %s\n", Arrays.toString(numbers));

        numbers = new int[]{0,1,0,4,12,0,2};
        swapZerosAtTheEndOfArrayOption1(numbers);
        System.out.printf("\nNew Array after Swapping zeros %s\n", Arrays.toString(numbers));

        numbers = new int[]{1,0,4,12,0,2};
        swapZerosAtTheEndOfArrayOption1(numbers);
        System.out.printf("\nNew Array after Swapping zeros %s\n", Arrays.toString(numbers));

        numbers = new int[]{1};
        swapZerosAtTheEndOfArrayOption1(numbers);
        System.out.printf("\nNew Array after Swapping zeros %s\n", Arrays.toString(numbers));

        numbers = new int[]{1,0};
        swapZerosAtTheEndOfArrayOption1(numbers);
        System.out.printf("\nNew Array after Swapping zeros %s\n", Arrays.toString(numbers));

        numbers = new int[]{0,1};
        swapZerosAtTheEndOfArrayOption1(numbers);
        System.out.printf("\nNew Array after Swapping zeros %s\n", Arrays.toString(numbers));

        numbers = new int[]{0,0};
        swapZerosAtTheEndOfArrayOption1(numbers);
        System.out.printf("\nNew Array after Swapping zeros %s\n", Arrays.toString(numbers));

        numbers = new int[]{8,1,0,2,1,0,3};
        swapZerosAtTheEndOfArrayOption2(numbers);
        System.out.printf("\nswapZerosAtTheEndOfArrayOption2, New Array after Swapping zeros %s\n", Arrays.toString(numbers));

        numbers = new int[]{8,1,0,2,1,0,3};
        swapZerosAtTheEndOfArrayOption3(numbers);
        System.out.printf("\nswapZerosAtTheEndOfArrayOption3, New Array after Swapping zeros %s\n", Arrays.toString(numbers));

    }

    static void swapZerosAtTheEndOfArrayOption1(int[] numbers) {
        if ( numbers == null || numbers.length==0) {
            throw new IllegalArgumentException("Incoming Array is " + ( numbers == null ? "null" : "empty"));
        }
        if ( numbers.length==1) {
            return;
        }
        
        int startPointer = 0;
        int endPointer = 1;

        while (endPointer<numbers.length) {
            if ( numbers[startPointer] ==0 && numbers[endPointer]!=0) {
                numbers[startPointer] = numbers[endPointer];
                numbers[endPointer] = 0;
                startPointer++;
                endPointer++;
            }
            else if (numbers[startPointer] ==0 && numbers[endPointer] ==0 ) {
                endPointer++;
            } else {
                startPointer++;
                endPointer++;
            }
        }

    }


    /**
     * in this algorithms firstPointer always gets incremented while secondPointer gets incremented is value at secondPointer is not 0
     *
     * @param numbers
     */
    static void swapZerosAtTheEndOfArrayOption2(int[] numbers) {
        if ( numbers == null || numbers.length==0) {
            throw new IllegalArgumentException("Incoming Array is " + ( numbers == null ? "null" : "empty"));
        }
        if ( numbers.length==1) {
            return;
        }

        int firstPointer = 0;
        int secondPointer = 0;

        while (firstPointer<numbers.length && secondPointer<numbers.length) {
            if ( numbers[firstPointer] !=0 && numbers[secondPointer]==0) {
                int tmp = numbers[firstPointer];
                numbers[firstPointer] = numbers[secondPointer];
                numbers[secondPointer] = tmp;
            }
            if ( numbers[secondPointer]!=0) {
                secondPointer++;
            }
            firstPointer++;
        }
    }


    /**
     * in this algorithms firstPointer always gets incremented while secondPointer gets incremented is value at secondPointer is not 0
     *
     * @param numbers
     */
    static void swapZerosAtTheEndOfArrayOption3(int[] numbers) {
        if ( numbers == null || numbers.length==0) {
            throw new IllegalArgumentException("Incoming Array is " + ( numbers == null ? "null" : "empty"));
        }

        int secondPointer = 0;
        for ( int firstPointer = 0; firstPointer<numbers.length; firstPointer++) {
            if ( numbers[firstPointer] !=0 && numbers[secondPointer]==0) {
                int tmp = numbers[firstPointer];
                numbers[firstPointer] = numbers[secondPointer];
                numbers[secondPointer] = tmp;
            }
            if ( numbers[secondPointer]!=0) {
                secondPointer++;
            }
        }
    }
}
