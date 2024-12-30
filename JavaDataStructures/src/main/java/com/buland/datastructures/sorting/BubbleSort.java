package com.buland.datastructures.sorting;

import java.util.Arrays;
import java.util.Random;

/**
 * Bubble Sort Explanation
 *
 * Bubble Sort is a simple comparison-based sorting algorithm. It works by repeatedly stepping through the list, comparing adjacent
 * elements, and swapping them if they are in the wrong order. This process continues until no more swaps are needed, which indicates
 * that the list is sorted.
 *
 * How Bubble Sort Works:
 *
 *     Start at the beginning of the list.
 *     Compare each pair of adjacent elements.
 *     If the first element is greater than the second element, swap them.
 *     After the first pass through the list, the largest element will have "bubbled up" to the end of the list.
 *     Repeat the process for the rest of the list, excluding the last sorted element, until the entire list is sorted.
 *
 * Bubble Sort Example:
 *
 * Consider the array: [64, 34, 25, 12, 22, 11]
 *
 * Pass 1:
 *
 *     Compare 64 and 34 → 64 > 34, swap → [34, 64, 25, 12, 22, 11]
 *     Compare 64 and 25 → 64 > 25, swap → [34, 25, 64, 12, 22, 11]
 *     Compare 64 and 12 → 64 > 12, swap → [34, 25, 12, 64, 22, 11]
 *     Compare 64 and 22 → 64 > 22, swap → [34, 25, 12, 22, 64, 11]
 *     Compare 64 and 11 → 64 > 11, swap → [34, 25, 12, 22, 11, 64]
 *
 * After the first pass, 64 is correctly placed at the end.
 *
 * Pass 2:
 *
 *     Compare 34 and 25 → 34 > 25, swap → [25, 34, 12, 22, 11, 64]
 *     Compare 34 and 12 → 34 > 12, swap → [25, 12, 34, 22, 11, 64]
 *     Compare 34 and 22 → 34 > 22, swap → [25, 12, 22, 34, 11, 64]
 *     Compare 34 and 11 → 34 > 11, swap → [25, 12, 22, 11, 34, 64]
 *
 * Now, 34 is correctly placed.
 *
 * Pass 3:
 *
 *     Compare 25 and 12 → 25 > 12, swap → [12, 25, 22, 11, 34, 64]
 *     Compare 25 and 22 → 25 > 22, swap → [12, 22, 25, 11, 34, 64]
 *     Compare 25 and 11 → 25 > 11, swap → [12, 22, 11, 25, 34, 64]
 *
 * Now, 25 is correctly placed.
 *
 * Pass 4:
 *
 *     Compare 12 and 22 → 12 < 22, no swap needed.
 *     Compare 22 and 11 → 22 > 11, swap → [12, 11, 22, 25, 34, 64]
 *
 * Now the array is sorted: [11, 12, 22, 25, 34, 64].
 * Time Complexity:
 *
 *     Best case (already sorted array): O(n) when an optimized version is used that checks if any swaps were made during a pass.
 *     Worst case (reversed array): O(n²)
 *     Average case: O(n²)
 *
 * This is because, in the worst case, the algorithm performs n - 1 passes over the list, with each pass requiring n - 1 comparisons
 * and swaps.
 *
 * Space Complexity:
 *
 *     O(1) because bubble sort is an in-place sorting algorithm. It does not require any extra space apart from a few temporary variables.
 */
public class BubbleSort {

    public static void main(String[] args) {

        BubbleSort sorting = new BubbleSort();
        int numbers[] = new int[]{9,2,6,4,3,5,1};
        System.out.printf("\nArray before soring: %s\n", Arrays.toString(numbers));
        sorting.bubbleSort(numbers);
        System.out.printf("\nArray before soring: %s\n", Arrays.toString(numbers));


        sortGivenSize(1000);
        System.out.println("\n");
        sortGivenSize(3000);
        System.out.println("\n");
        sortGivenSize(5000);
    }

    static void sortGivenSize(int ARRAY_SIZE) {
        int[] numbers = new int[ARRAY_SIZE];
        Random random = new Random();
        for (int i=0; i<ARRAY_SIZE; i++) {
            numbers[i] = random.nextInt(100000);
        }

        //numbers = new int[]{7,3,5,10,-5,-2,0,1,9,6};
        //System.out.printf("Array Before Sorting: %s\n", Arrays.toString(numbers));
        BubbleSort sorting = new BubbleSort();
        long startTime = System.currentTimeMillis();
        sorting.bubbleSort(numbers);
        long endTime = System.currentTimeMillis();

        System.out.printf("Selection Sort of Size=%d took %dms\n", ARRAY_SIZE, (endTime-startTime));
        //System.out.printf("Array After Sorting: %s\n", Arrays.toString(numbers));
    }


    /**
     * Initial Array: [64, 11, 7, 12, 22, 34]
     *
     * Pass 1:
     *
     *     Compare 64 and 11: 64 > 11, so swap → [11, 64, 7, 12, 22, 34]
     *     Compare 64 and 7: 64 > 7, so swap → [11, 7, 64, 12, 22, 34]
     *     Compare 64 and 12: 64 > 12, so swap → [11, 7, 12, 64, 22, 34]
     *     Compare 64 and 22: 64 > 22, so swap → [11, 7, 12, 22, 64, 34]
     *     Compare 64 and 34: 64 > 34, so swap → [11, 7, 12, 22, 34, 64]
     *
     * Result after Pass 1: [11, 7, 12, 22, 34, 64]
     * (The largest element 64 is now in its correct position.)
     *
     * Pass 2:
     *
     *     Compare 11 and 7: 11 > 7, so swap → [7, 11, 12, 22, 34, 64]
     *     Compare 11 and 12: 11 < 12, no swap.
     *     Compare 12 and 22: 12 < 22, no swap.
     *     Compare 22 and 34: 22 < 34, no swap.
     *
     * Result after Pass 2: [7, 11, 12, 22, 34, 64]
     * (The second largest element 34 is now in its correct position.)
     *
     * Pass 3:
     *
     *     Compare 7 and 11: 7 < 11, no swap.
     *     Compare 11 and 12: 11 < 12, no swap.
     *     Compare 12 and 22: 12 < 22, no swap.
     *
     * Result after Pass 3: [7, 11, 12, 22, 34, 64]
     * (The third largest element 22 is now in its correct position.)
     *
     * Pass 4:
     *
     *     Compare 7 and 11: 7 < 11, no swap.
     *     Compare 11 and 12: 11 < 12, no swap.
     *
     * Result after Pass 4: [7, 11, 12, 22, 34, 64]
     * (The fourth largest element 12 is now in its correct position.)
     *
     * Pass 5:
     *
     *     Compare 7 and 11: 7 < 11, no swap.
     *
     * Result after Pass 5: [7, 11, 12, 22, 34, 64]
     *
     * Why Use Bubble Sort?
     *
     *     Simplicity: The algorithm is easy to understand and implement.
     *     Educational: It is often used in teaching to demonstrate sorting algorithms and the idea of comparing and swapping elements.
     *
     * However, Bubble Sort is generally inefficient for large datasets due to its O(n²) time complexity, and more efficient algorithms
     * like Quick Sort or Merge Sort are preferred in most practical scenarios.
     *
     * @param numbers
     */
    private static void bubbleSort(int[] numbers) {
        int arrLength = numbers.length;
        boolean swapped;
        for (int i = 0; i< arrLength; i++) {

            swapped = false; //start new iteration as nothing swapped
            for (int j=0; j<arrLength-i-1 ; j++) {
                if ( numbers[j] > numbers[j+1] ) {
                    swap(numbers, j, j+1);
                    swapped = Boolean.TRUE;
                }
            }

            // If no two elements were swapped by inner loop, then the array is sorted
            if ( !swapped ) {
                break;
            }
        }
    }


    /**
     * method to swap 2 #s at given array indices
     *
     * @param numbers
     * @param index1
     * @param index2
     */
    private static void swap(int[] numbers, int index1, int index2) {
        int tmp = numbers[index1];
       numbers[index1] = numbers[index2];
       numbers[index2] = tmp;
    }

}
