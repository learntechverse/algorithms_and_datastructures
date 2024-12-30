package com.buland.datastructures.arrays;

import java.util.Arrays;

public class ReverseArray {

    public static void main(String[] args) {
        int[] numbers = {1,3,5,8,0,-1}; //even #s of elements length is 6
        int
                startPointer = 0,
                endPointer = numbers.length-1;
        //int[] reverseArray = reverseArray(numbers, start, end);
        reverseArray(numbers, startPointer, endPointer);
        System.out.printf("*************** reverseArray with Odd Array Length using two pointers (start & end) %s \n", Arrays.toString(numbers));

        numbers = new int[]{1,3,5,8,0,-1,15}; //odd #s of elements length is 7
        startPointer = 0;
        endPointer = numbers.length-1;
        //int[] reverseArray = reverseArray(numbers, start, end);
        reverseArray(numbers, startPointer, endPointer);
        System.out.printf("*************** reverseArray with Even Array Length using two pointers (start & end) %s \n", Arrays.toString(numbers));

        numbers = new int[]{1,3}; //even #s of elements length is 2
        startPointer = 0;
        endPointer = numbers.length-1;
        //int[] reverseArray = reverseArray(numbers, start, end);
        reverseArray(numbers, startPointer, endPointer);
        System.out.printf("*************** reverseArray with Even Array Length using two pointers (start & end) %s \n", Arrays.toString(numbers));

    }

    /**
     * this techniques using two pointers (startPointer & endPointer).
     *
     * Complexity of this algorithm ids O(n/2) as it goes till the half of the array.
     *
     * 1. Loop through till start < end
     * 2. store array[start] into tmp variable
     * 3. swap end and start number in the array (numbers[start] = numbers[end])
     * 4. store tmp into end index (numbers[end] = tmp]
     * 5. increment start
     * 6. decrement end
     * 7. goes back to the loop #1
     *
     * @param numbers - original array
     * @param startPointer - 1st pointer
     * @param endPointer - - 2nd pointer
     */
    private static void reverseArray(int[] numbers, int startPointer, int endPointer) {
        int counter = 0;
        while (startPointer < endPointer) {
            int tmp = numbers[startPointer];
            numbers[startPointer] = numbers[endPointer];
            numbers[endPointer] = tmp;
            startPointer++;
            endPointer--;
            counter++;
        }
        System.out.printf("\nreverseArray called %d many times\n", counter);
    }
}
