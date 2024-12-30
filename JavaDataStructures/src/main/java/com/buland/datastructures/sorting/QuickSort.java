package com.buland.datastructures.sorting;

import java.util.Arrays;
import java.util.Random;

/**
 * Quick Sort Explanation:
 *
 * Quick Sort is an efficient, recursive, divide-and-conquer sorting algorithm. It works by selecting a pivot element from the array and
 * partitioning the other elements into two subarrays:
 *
 *     Elements smaller than the pivot go into the "left" subarray.
 *     Elements greater than the pivot go into the "right" subarray.
 *
 * The process is then recursively applied to the subarrays.
 * Steps of Quick Sort:
 *
 *     Choose a pivot (typically the first, last, or a random element).
 *     Partition the array so that elements smaller than the pivot are on one side, and larger elements are on the other side.
 *     Recursively apply Quick Sort to the subarrays on either side of the pivot.
 *     Combine the sorted subarrays with the pivot in between.
 *
 * Time Complexity:
 *
 *     Best case: O(n log n) (when partitions are balanced).
 *
 *     Average case: O(n log n) (when partitions are balanced).
 *
 *     Worst case: O(n²) (when partitions are highly unbalanced, e.g., when the array is already sorted, and the pivot is the smallest or
 *     largest element).
 *
 *     Average case: O(n log n).
 *
 * Space Complexity:
 *
 *     O(log n) for recursion stack in the best/average cases.
 *     O(n) in the worst case (due to deep recursion).
 */
public class QuickSort {

    /**
     *
     * @param numbers
     * @param leftIndex its a lowIndex
     * @param rightIndex its a highIndex
     */
    public void quickSort(int[] numbers, int leftIndex, int rightIndex) {

        //System.out.printf("\nIn quickSort: Array: %s, leftIndex: %d, rightIndex: %d\n", Arrays.toString(numbers), leftIndex, rightIndex);

        if ( leftIndex >= rightIndex ) return;

        /**
         * 1. Choose a Pivot
         *
         * how to choose the pivot is important as choosing right pivot results in avegrage bad runtime
         *
         * Few Options:-
         * 1. One option is to pick the last elemtn as pivot always
         * 2. always picks the median
         * 3. pick arandom pivot
         *
         */
        int pivot = numbers[(leftIndex + rightIndex) / 2]; //middle one as pivot

        //randomly picking the pivot
        //int pivotIndex = new Random().nextInt(rightIndex - leftIndex) + leftIndex;
        //int pivotIndex = new Random().nextInt(rightIndex); //we cannot do it as we are sending numbers full array with every oteration and when we send upper bound like leftIndex=4 and rightIndex=6 than we want random index to be in between 4 & 6 and not anywhere from 0-6.
        //pivot = numbers[pivotIndex];


        //2. Partition the Array based of the Pivot (move all elements lower than pivot to teh left side and left side contains all elements greater than pivot)
        int partitionIndex = partition(numbers, leftIndex, rightIndex, pivot);

        //3. recursively call quicksort for left & right sub arrays
        quickSort(numbers, leftIndex, partitionIndex -1 );
        quickSort(numbers, partitionIndex, rightIndex );
    }

    private static int partition(int[] numbers, int leftIndex, int rightIndex, int pivot) {
        while ( leftIndex <= rightIndex) {

            while (numbers[leftIndex] < pivot) { //stop if leftSide index element greater than Pivot because we want to move it to right
                leftIndex++;
            }

            while (numbers[rightIndex] > pivot) { //stop if leftSide index element smaller than Pivot because we want to move it to left
                rightIndex--;
            }

            if ( leftIndex <= rightIndex) {
                swap(numbers, leftIndex, rightIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        return leftIndex;
    }

    static void swap(int[] numbers, int leftIndex, int rightIndex) {
        int tmp = numbers[leftIndex];
        numbers[leftIndex] = numbers[rightIndex];
        numbers[rightIndex] = tmp;
    }

    public static void main(String[] args) {
        QuickSort sorting = new QuickSort();
        int numbers[] = new int[]{9,2,6,4,3,5,1};
        System.out.printf("\nArray before soring: %s\n", Arrays.toString(numbers));
        sorting.quickSort(numbers, 0, numbers.length-1);
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
        QuickSort sorting = new QuickSort();

        long startTime = System.currentTimeMillis();
        sorting.quickSort(numbers, 0, numbers.length-1);
        long endTime = System.currentTimeMillis();

        System.out.printf("Selection Sort of Size=%d took %dms\n", ARRAY_SIZE, (endTime-startTime));
        //System.out.printf("Array After Sorting: %s\n", Arrays.toString(numbers));
    }
}
